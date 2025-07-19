/*
Script en posgresql para crear las tablas necesarias para el proyecto y cargarlas
NO REQUIERE ACTUALIZAR LAS TABLAS PUES EL CONTENEDOR LO GUARDA EN MEMORIA

Creación de usuario para aplicativo

CREATE ROLE app_backed WITH LOGIN PASSWORD 'backed_pass_123';
GRANT ALL ON SCHEMA seguridad TO app_backed;

*/

--Creación de esquema para guardar la información de las tablas
CREATE SCHEMA seguridad

-- Creación de las tablas con sus relaciones
-- DROP TABLE IF EXISTS seguridad.persona 
-- DROP TABLE IF EXISTS seguridad.cuenta
-- DROP TABLE IF EXISTS seguridad.cliente 
-- DROP TABLE IF EXISTS seguridad.movimiento 

CREATE TABLE seguridad.persona (
	idpersona SERIAL PRIMARY KEY,
	nombre VARCHAR(50) NOT NULL,
	genero VARCHAR(2) NOT NULL,
	edad INT NOT NULL,
	identificacion VARCHAR(10) UNIQUE NOT NULL,
	direccion VARCHAR(200) NOT NULL,
	telefono VARCHAR(10)
);

CREATE TABLE seguridad.cliente (
	idcliente SERIAL PRIMARY KEY,
	contrasenia VARCHAR(20),
	idpersona BIGINT NOT NULL,
	estado BOOLEAN NOT NULL,
	CONSTRAINT fk_persona FOREIGN KEY (idpersona)
		REFERENCES seguridad.persona(idpersona)
);

CREATE TABLE seguridad.cuenta (
	idcuenta SERIAL PRIMARY KEY,
	tipo VARCHAR(10) NOT NULL,
	saldoinicial BIGINT NOT NULL,
	idcliente BIGINT NOT NULL,
	estado BOOLEAN NOT NULL,
	CONSTRAINT fk_cliente FOREIGN KEY (idcliente)
		REFERENCES seguridad.cliente(idcliente)
);

CREATE TABLE seguridad.movimiento (
	idmovimiento SERIAL PRIMARY KEY,
	fecha DATE NOT NULL,
	tipomovimiento VARCHAR(50) NOT NULL,
	valor BIGINT NOT NULL,
	idcuenta BIGINT NOT NULL,
	saldo BIGINT NOT NULL,
	CONSTRAINT fk_cuenta FOREIGN KEY (idcuenta)
		REFERENCES seguridad.cuenta(idcuenta)
);
