insert into tb_regiones (id, nombre) values (1, 'Centro America');
insert into tb_regiones (id, nombre) values (2, 'Sur America');
insert into tb_regiones (id, nombre) values (3, 'Norte America');
insert into tb_regiones (id, nombre) values (4, 'Europa');
insert into tb_regiones (id, nombre) values (5, 'Asia');
insert into tb_regiones (id, nombre) values (6, 'Africa');
insert into tb_regiones (id, nombre) values (7, 'Oceania');
insert into tb_regiones (id, nombre) values (8, 'Antardida');

insert into tb_clientes (region_id, nombre, apellido, email, create_at) values (3, "Franco", 'Arteaga', "asalas@gmail.com", '2022-09-20');
insert into tb_clientes (region_id, nombre, apellido, email, create_at) values (6, "Carla", 'Dulanto', "cdulanto@gmail.com", '2022-09-15');
insert into tb_clientes (region_id, nombre, apellido, email, create_at) values (2, "Ximena", 'Ortiz', "xortiz@gmail.com", '2022-09-05');
insert into tb_clientes (region_id, nombre, apellido, email, create_at) values (7, "Roberto", 'Atencio', "ratencio@gmail.com", '2022-09-06');

/* Poblar data de usuarios */
insert into tb_usuarios(username, password, enabled, nombre, apellido, email) values ('andres','$2a$10$BWVJWYDI/ThZcn7/FXRU6.qL9k18nwSmpFTzBAaSFVibDyJdpSP3u',1, 'Andres', 'Guzman', 'profesor@bolsadeideas.com');
insert into tb_usuarios(username, password, enabled, nombre, apellido, email) values ('admin','$2a$10$3sytV6KX1gmKqlCqP8YL9erVhM1.HFGdU64vSY9oKREALXGhqL2MG',1, 'John', 'Doe', 'john.doe@bolsadeideas.com');

insert into tb_roles(nombre) values ('ROLE_USER');
insert into tb_roles(nombre) values ('ROLE_ADMIN');

insert into tb_usuarios_roles(usuario_id, rol_id) values (1,1);
insert into tb_usuarios_roles(usuario_id, rol_id) values (2,2);

/* Poblar data de productos */
insert into tb_productos (nombre, precio, create_at) values ('Panasonic Pantalla LCD', 950, NOW());
insert into tb_productos (nombre, precio, create_at) values ('Celular Samsung S50', 850, NOW());
insert into tb_productos (nombre, precio, create_at) values ('Licuadora Oster 600', 700, NOW());
insert into tb_productos (nombre, precio, create_at) values ('Laptop Lenovo L340', 1500, NOW());
insert into tb_productos (nombre, precio, create_at) values ('Tablet Samsung A55', 760, NOW());
insert into tb_productos (nombre, precio, create_at) values ('Mouse Pad Logitech', 80, NOW());
insert into tb_productos (nombre, precio, create_at) values ('Microondas Oster', 450, NOW());
insert into tb_productos (nombre, precio, create_at) values ('Refrigeradora ElectroLux', 450, NOW());

/* Poblar data de facturas */
insert into tb_facturas (descripcion, observacion, cliente_id, create_at) values ('Factura equipos de oficina', null, 1, NOW());
insert into tb_facturas_detalles (cantidad, factura_id, producto_id) values (1,1,1);
insert into tb_facturas_detalles (cantidad, factura_id, producto_id) values (2,1,4);
insert into tb_facturas_detalles (cantidad, factura_id, producto_id) values (1,1,5);
insert into tb_facturas_detalles (cantidad, factura_id, producto_id) values (1,1,6);

insert into tb_facturas (descripcion, observacion, cliente_id, create_at) values ('Factura Implementos de cocina', 'Alguna nota importante', 1, NOW());
insert into tb_facturas_detalles (cantidad, factura_id, producto_id) values (3,2,3);
insert into tb_facturas_detalles (cantidad, factura_id, producto_id) values (2,2,7);
insert into tb_facturas_detalles (cantidad, factura_id, producto_id) values (1,2,8);