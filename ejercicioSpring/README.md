# Sistema de Gestión de Estudiantes CRUD

Una API REST en Spring Boot para la gestión de estudiantes con operaciones CRUD.

## Requisitos

- Java 17 o superior
- Maven 3.8.x o superior

## Instalación y Configuración

1. Clonar el repositorio:
   ```
   git clone https://github.com/tuusuario/gestion-estudiantes.git
   cd gestion-estudiantes
   ```

2. Compilar el proyecto:
   ```
   mvn clean install
   ```

3. Ejecutar la aplicación:
   ```
   mvn spring-boot:run
   ```

## Endpoints de la API

| Método | URL                        | Descripción                     | Código de Estado   |
| ------ | -------------------------- | ------------------------------- | ------------------ |
| GET    | /api/estudiantes           | Obtener todos los estudiantes   | 200 (OK)           |
| GET    | /api/estudiantes/{id}      | Obtener estudiante por ID       | 200 (OK)           |
| POST   | /api/estudiantes           | Crear un nuevo estudiante       | 201 (Created)      |
| PUT    | /api/estudiantes/{id}      | Actualizar estudiante por ID    | 200 (OK)           |
| DELETE | /api/estudiantes/{id}      | Eliminar estudiante por ID      | 204 (No Content)   |

## Ejemplo de cuerpo de petición para POST y PUT

```json
{
  "nombre": "Juan",
  "apellido": "Pérez",
  "email": "juan.perez@example.com",
  "edad": 22,
  "carrera": "Informática"
}
```

## Base de Datos

La aplicación utiliza una base de datos H2 en memoria que se puede acceder en:

- URL: http://localhost:9090/h2-console
- JDBC URL: jdbc:h2:mem:studentdb
- Usuario: sa
- Contraseña: password

## Pruebas con Postman o cURL

### Ejemplos de comandos cURL:

1. Obtener todos los estudiantes:
   ```
   curl -X GET http://localhost:9090/api/estudiantes
   ```

2. Obtener estudiante por ID:
   ```
   curl -X GET http://localhost:9090/api/estudiantes/1
   ```

3. Crear un nuevo estudiante:
   ```
   curl -X POST http://localhost:9090/api/estudiantes \
     -H "Content-Type: application/json" \
     -d '{"nombre": "María", "apellido": "García", "email": "maria.garcia@example.com", "edad": 21, "carrera": "Matemáticas"}'
   ```

4. Actualizar un estudiante:
   ```
   curl -X PUT http://localhost:9090/api/estudiantes/1 \
     -H "Content-Type: application/json" \
     -d '{"nombre": "María", "apellido": "García", "email": "maria.actualizado@example.com", "edad": 22, "carrera": "Matemáticas"}'
   ```

5. Eliminar un estudiante:
   ```
   curl -X DELETE http://localhost:9090/api/estudiantes/1
   ``` 