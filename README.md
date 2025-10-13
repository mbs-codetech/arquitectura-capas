# Proyecto base capas

### Este proyecto es la plantilla para desarrollo en capas

La plantilla cuenta con una estructura en donde vamos a poder encontrar los servicio, los modelos, las interfaces, entre otras:

### Configuration 

Se encuentra la información para la configuración en los proyectos 

Aquí puedes definir beans, configuración de seguridad, manejo de CORS, propiedades personalizadas, o integración con otros módulos (por ejemplo, bases de datos o servicios externos).

Ejemplos comunes:

WebConfig.java → configuración de CORS o interceptores.

SecurityConfig.java → configuración de Spring Security.

SwaggerConfig.java → configuración para documentación API.

### Controller

Esta capa representa el punto de entrada a tu aplicación (la capa web o API).
Los controladores reciben las solicitudes HTTP, llaman a la capa de servicio y devuelven respuestas al cliente.

### DTO

Contiene los objetos usados para transferir datos entre capas (por ejemplo, entre controller y service).
Se usan para evitar exponer directamente las entidades del dominio.

### Entity

Se definen las entidades del dominio

### Mapper

Contiene las clases o interfaces encargadas de convertir entre entity y dto.
Esto ayuda a mantener el código limpio y separar responsabilidades.

### Repository

Capa encargada del acceso a datos. Se encarga de la interacción con la base de datos.

### Servicio
En este vamos a encontrar los paths de los servicios que vamos a exponer

### Util

Incluye clases de utilidad con metodos estaticos o funcionalidades comunes usadas en varias partes del proyecto

## Cambios para usar la plantilla

Se debe cambiar el nombre la carpeta **arquitecturacapas** por el nombre del proyecto que se va a realizar

Se debe cambiar la propiedad **spring.application.name** ubicado en el **application.properties**

Se debe cambiar la propiedad **rootProject.name** ubicado en **settings.gradle**

Se debe cambiar el valor de la descripcion por el nombre del proyecto en el archivo **build.gradle**
