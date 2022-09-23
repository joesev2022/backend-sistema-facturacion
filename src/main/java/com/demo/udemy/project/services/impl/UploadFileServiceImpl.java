package com.demo.udemy.project.services.impl;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.demo.udemy.project.services.IUploadFileService;

@Service
public class UploadFileServiceImpl implements IUploadFileService{
	
	private final Logger log = LoggerFactory.getLogger(UploadFileServiceImpl.class);
	
	private final static String DIRECTORIO_UPLOAD = "uploads";

	@Override
	public Resource cargar(String nombreFoto) throws MalformedURLException {
		Path rutaArchivo = getPath(nombreFoto);
		log.info(rutaArchivo.toString());
		Resource recurso = null;
		recurso = new UrlResource(rutaArchivo.toUri());
		//Si la foto no existe o no se puede leer
		if (!recurso.exists() && !recurso.isReadable()) {
			//Hacemos que se muestre la imagen por defecto de usuario
			rutaArchivo = Paths.get("src/main/resources/static/images").resolve("user-icon.png").toAbsolutePath();
			recurso = new UrlResource(rutaArchivo.toUri());
			//Y cargamos el error por el log
			log.error("Error, no se pudo cargar la imagen: " + nombreFoto);
		}
		return recurso;
	}

	@Override
	public String copiar(MultipartFile archivo) throws IOException {
		//Configuro el nombre de la imagen con un identificador único y si hay espacios lo elimino.
		String nombreArchivo = UUID.randomUUID().toString() + "_" + archivo.getOriginalFilename().replace(" ", "");
		Path rutaArchivo = getPath(nombreArchivo);
		log.info(nombreArchivo.toString());
		Files.copy(archivo.getInputStream(), rutaArchivo);
		return nombreArchivo;
	}

	@Override
	public boolean eliminar(String nombreFoto) {
		//Si el cliente tiene una foto procedemos a eliminar
		if(nombreFoto != null && nombreFoto.length()>0) {
			//Encontramos la ruta de la imagen en 'uploads'
			Path rutaFotoAnterior = Paths.get("uploads").resolve(nombreFoto).toAbsolutePath();
			//Obtenemos el archivo encontrado
			File archivoFotoAnterior = rutaFotoAnterior.toFile();
			//Si el archivo es confirmado que existe y puede leerse
			if(archivoFotoAnterior.exists() && archivoFotoAnterior.canRead()) {
				//eliminamos la foto
				archivoFotoAnterior.delete();
				return true;
			}
		}
		return false;
	}

	@Override
	public Path getPath(String nombreFoto) {
		return Paths.get(DIRECTORIO_UPLOAD).resolve(nombreFoto).toAbsolutePath();
	}

}
