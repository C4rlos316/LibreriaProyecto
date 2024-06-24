# LiterAlura: Catálogo de Libros

Este proyecto es un catálogo de libros desarrollado en Java con Spring Boot, que permite interactuar con la API de Gutendex para consultar información sobre libros y gestionar datos en una base de datos MySQL.

## Objetivo

El objetivo de LiterAlura es proporcionar una herramienta que permita a los usuarios buscar, listar y filtrar libros utilizando una interfaz de consola. Utiliza Spring Boot para la gestión del backend, integra la manipulación de datos JSON con la biblioteca Jackson y ofrece persistencia de datos a través de MySQL.

## Funcionalidades

El proyecto LiterAlura permite realizar las siguientes acciones a través de un menú de consola:

1. **Buscar libro por título**
   - Realiza una búsqueda por título de libro utilizando la API de Gutendex.

2. **Listar libros registrados**
   - Muestra los libros almacenados localmente en la base de datos.

3. **Listar autores registrados**
   - Muestra los autores de los libros almacenados localmente en la base de datos.

4. **Listar autores vivos en un determinado año**
   - Filtra y muestra los autores que estaban vivos en el año especificado.

5. **Listar libro por idioma**
   - Filtra y muestra los libros según el idioma especificado.

6. **Salir**
   - Finaliza la ejecución del programa.

## Configuración y Desarrollo

### Configuración del Entorno

1. **IDE:** Utiliza IntelliJ IDEA para el desarrollo del proyecto.

2. **Dependencias:** Agrega las siguientes dependencias en el archivo `pom.xml`:

   ```xml
   <!-- Spring Boot Starter Web -->
   <dependency>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-starter-web</artifactId>
   </dependency>

   <!-- Spring Boot Starter Data JPA -->
   <dependency>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-starter-data-jpa</artifactId>
   </dependency>

   <!-- MySQL Connector -->
   <dependency>
       <groupId>mysql</groupId>
       <artifactId>mysql-connector-java</artifactId>
   </dependency>

   <!-- Jackson Databind -->
   <dependency>
       <groupId>com.fasterxml.jackson.core</groupId>
       <artifactId>jackson-databind</artifactId>
   </dependency>
