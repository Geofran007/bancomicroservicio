
/*
Script en posgresql para crear las tablas necesarias para el proyecto y cargarlas
NO REQUIERE ACTUALIZAR LAS TABLAS PUES EL CONTENEDOR LO GUARDA EN MEMORIA

Creación de usuario para aplicativo




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

CREATE ROLE app_backed WITH LOGIN PASSWORD 'backed_pass_123';

GRANT ALL ON SCHEMA seguridad TO app_backed;

GRANT ALL ON TABLE seguridad.cliente TO app_backed;
GRANT ALL ON TABLE seguridad.persona TO app_backed;
GRANT ALL ON TABLE seguridad.movimiento TO app_backed;
GRANT ALL ON TABLE seguridad.cuenta TO app_backed;
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA seguridad TO app_backed;
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA seguridad TO app_backed;
GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA seguridad TO app_backed;


INSERT INTO seguridad.persona (nombre, genero, edad, identificacion, direccion, telefono)
VALUES ('Jose Lema', 'H', 35, '1734567890', 'Otavalo sn y principal', '0982547854');
INSERT INTO seguridad.persona (nombre, genero, edad, identificacion, direccion, telefono)
VALUES ('Marianela Montalvo', 'M', 28, '1134567890', 'Amazonas y NNUU', '0975489656');
INSERT INTO seguridad.persona (nombre, genero, edad, identificacion, direccion, telefono)
VALUES ('Juan Osorio', 'H', 15, '1158567890', '13 junio y Equinoccial', '098874587');

INSERT INTO seguridad.cliente(contrasenia,idpersona,estado)
VALUES('1234',1,true);
INSERT INTO seguridad.cliente(contrasenia,idpersona,estado)
VALUES('5678',2,true);
INSERT INTO seguridad.cliente(contrasenia,idpersona,estado)
VALUES('1245',3,true);