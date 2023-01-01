package com.demo.udemy.project.controllers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.demo.udemy.project.entities.ClienteEntity;
import com.demo.udemy.project.entities.RegionEntity;
import com.demo.udemy.project.services.ClienteService;
import com.demo.udemy.project.services.IUploadFileService;

@CrossOrigin(origins = {"http://localhost:4200/", "*"})
@RestController
@RequestMapping("/api")
public class ClienteRestController {

	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private IUploadFileService uploadFileService;
	
	@GetMapping("/clientes")
	public List<ClienteEntity> index(){
		return clienteService.findAll();
	}
	
	@GetMapping("/clientes/page/{page}")
	public Page<ClienteEntity> index(@PathVariable Integer page){
		Pageable pageable = PageRequest.of(page, 4);
		return clienteService.findAll(pageable);
	}
	
	//Manejamos el error de asegurarnos si se encuentra el id del cliente en la BD
	@Secured({"ROLE_ADMIN","ROLE_USER"})
	@GetMapping("/clientes/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		ClienteEntity cliente = null;
		Map<String, Object> response = new HashMap<>();
		try {
			cliente = clienteService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos.");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if(cliente == null) {
			response.put("mensaje", "El cliente Id: ".concat(id.toString().concat("No existe en la base de datos.")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ClienteEntity>(cliente, HttpStatus.OK);
	}
	
	@Secured({"ROLE_ADMIN"})
	@PostMapping("/clientes")
	public ResponseEntity<?> create(@Valid @RequestBody ClienteEntity cliente, BindingResult result) {
		ClienteEntity clienteNew = null;
		Map<String, Object> response = new HashMap<>();
		
		if(result.hasErrors()) {
			/*List<String> errors = new ArrayList<>();
			for (FieldError err : result.getFieldErrors()) {
				errors.add("El campo '" + err.getField() + "' " + err.getDefaultMessage());
			}*/
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		try {
			clienteNew = clienteService.save(cliente);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos.");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El cliente ha sido creado con éxito.");
		response.put("cliente", clienteNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	//Método para ACTUALIZAR Cliente
	@Secured({"ROLE_ADMIN"})
	@PutMapping("/clientes/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody ClienteEntity cliente, BindingResult result, @PathVariable Long id) {		
		//Del id del cliente recibido lo buscamos en la BD y lo almacenamos en un cliente
		ClienteEntity clienteActual = clienteService.findById(id);
		//Creamos una variable de tipo cliente para actualizar
		ClienteEntity clienteUpdated = null;
		//Creamos un MAP para gestionar los mensajes
		Map<String, Object> response = new HashMap<>();
		//Si el result tiene mensaje de error
		if(result.hasErrors()) {
			//Almacenamos los mensajes del result en un arreglo tipo String en errors stream y los mapeamos 
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());
			//
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		if(clienteActual == null) {
			response.put("mensaje", "Error: no se pudo editar, el cliente Id: ".concat(id.toString().concat("No existe en la base de datos.")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		try {			
			clienteActual.setApellido(cliente.getApellido());
			clienteActual.setNombre(cliente.getNombre());
			clienteActual.setEmail(cliente.getEmail());
			clienteActual.setCreateAt(cliente.getCreateAt());
			clienteActual.setRegion(cliente.getRegion());
			
			clienteUpdated = clienteService.save(clienteActual);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar en la base de datos.");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El cliente ha sido actualizado con éxito.");
		response.put("cliente", clienteUpdated);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	//Método para ELIMINAR al Cliente (y su imagen)
	@Secured({"ROLE_ADMIN"})
	@DeleteMapping("/clientes/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();
		try {
			//Buscamos al cliente por su id recibido del PathVariable
			ClienteEntity cliente = clienteService.findById(id);
			//Se busca si el cliente tiene una foto antes de ser eliminado
			String fotoAnterior = cliente.getFoto();
			//Si el cliente tiene una foto procedemos a eliminar
			uploadFileService.eliminar(fotoAnterior);
			//Luego de eliminar la foto pasamos a eliminar al cliente
			clienteService.delete(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar en la base de datos.");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El cliente ha sido eliminado con éxito.");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	//Método para ACTUALIZAR la imagen del cliente
	@Secured({"ROLE_ADMIN","ROLE_USER"})
	@PostMapping("/clientes/upload")
	public ResponseEntity<?> upload(@RequestParam("archivo") MultipartFile archivo, @RequestParam("id") Long id){
		Map<String, Object> response = new HashMap<>();
		
		ClienteEntity cliente = clienteService.findById(id);
		
		if(!archivo.isEmpty()) {
			String nombreArchivo = null;
			try {
				nombreArchivo = uploadFileService.copiar(archivo);
			} catch (IOException e) {
				response.put("mensaje", "Error al subir la imagen del cliente ");
				response.put("error", e.getMessage().concat(": ").concat(e.getCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			//En caso se quiera actualizar, la imagen anterior la eliminamos
			String fotoAnterior = cliente.getFoto();
			uploadFileService.eliminar(fotoAnterior);
			
			cliente.setFoto(nombreArchivo);
			clienteService.save(cliente);
			response.put("cliente", cliente);
			response.put("mensaje", "Has subido correctamente la imagen: " + nombreArchivo);
		}
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@GetMapping("/uploads/img/{nombreFoto:.+}")
	public ResponseEntity<Resource> verFoto(@PathVariable String nombreFoto){
		Resource recurso = null;
		
		try {
			recurso = uploadFileService.cargar(nombreFoto);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HttpHeaders cabecera = new HttpHeaders();
		cabecera.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + recurso.getFilename() + "\"");
		
		return new ResponseEntity<Resource>(recurso, cabecera, HttpStatus.OK);
	}
	
	@Secured({"ROLE_ADMIN"})
	@GetMapping("/clientes/regiones")
	public List<RegionEntity> listarRegiones(){
		return clienteService.findAllRegiones();
	}
}
