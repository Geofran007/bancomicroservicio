# bancomicroservicio
Proyecto basico de un banco con microservicios y postgres

# 🏦 Proyecto Banco - Microservicio REST con Docker

Este proyecto es una simulación de un banco implementado como parte de una prueba técnica para un puesto junior. Está desarrollado utilizando arquitectura de microservicios y se despliega mediante contenedores Docker.

## 🚀 Tecnologías y Herramientas

- **Java + Spring Boot**: Para el desarrollo del microservicio REST
- **PostgreSQL**: Base de datos principal
- **pgAdmin**: Herramienta web para administrar la base de datos
- **Docker y Docker Compose**: Para contenerizar y orquestar los servicios
- **Postman**: Para pruebas de los endpoints del microservicio

## ⚙️ Puertos Utilizados

| Servicio      | Puerto |
|---------------|--------|
| PostgreSQL    | 5432   |
| pgAdmin       | 5050   |
| Microservicio | 8080   |

## 📁 Estructura del Proyecto

- `db/`: Carpeta con el script inicial que se ejecuta al correr por primera vez el contenedor de PostgreSQL.
- `pgadmin-data/`: Carpeta donde se almacena el volumen de pgAdmin.
- `postgres-data/`: Carpeta donde se almacena el volumen de PostgreSQL.
- `src/`: Código fuente del microservicio.
- `target/`: Carpeta donde se genera el archivo `.jar` del microservicio.
- `Banco_backend.postman_collection.json`: Archivo importable para ejecutar los endpoints (CRUD) desde Postman.
- `BasedeDatos.sql`: Script SQL que crea los esquemas, tablas, roles y carga la información inicial de la base de datos.
- `Dockerfile`: Archivo que permite construir la imagen Docker del microservicio.
- `docker-compose.yml`: Archivo para levantar todo el entorno mediante contenedores Docker.

## ▶️ Ejecución del Proyecto

### 1. Clona el repositorio

```bash
git clone https://github.com/Geofran007/bancomicroservicio
cd mi-proyecto-banco
