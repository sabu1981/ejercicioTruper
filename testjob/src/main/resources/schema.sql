DROP TABLE IF EXISTS cliente cascade;
CREATE TABLE cliente (
  id_cliente INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  nombre VARCHAR(50) NOT NULL,
  activo INT,
  email VARCHAR(50) NOT NULL,
  password VARCHAR(60)
);

DROP TABLE IF EXISTS producto cascade;
CREATE TABLE producto (
  id_producto INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  clave VARCHAR(15),
  descripcion VARCHAR(150),
  activo INT
);

DROP TABLE IF EXISTS lista_compra cascade;
CREATE TABLE lista_compra (
  id_lista_compra INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  id_cliente INT NOT NULL,
  nombre_lista VARCHAR (20),
  fecha_registro DATE,
  fecha_ultima_actualizacion DATE,
  activo INT,
  foreign key (id_cliente) references cliente(id_cliente)
);

DROP TABLE IF EXISTS lista_compra_detalle cascade;
CREATE TABLE lista_compra_detalle (
  id_lista_compra INT NOT NULL,
  id_producto INT NOT NULL,
  cantidad INT,
  foreign key (id_lista_compra) references lista_compra(id_lista_compra),
  foreign key (id_producto) references producto(id_producto)
);

CREATE SEQUENCE IF NOT EXISTS LISTA_COMPRAS_SEQ START WITH 4
MINVALUE 1 
MAXVALUE 999999999 
INCREMENT BY 1 
