# PROYECTO BLOG DE JUEGOS - PRUEBA TECNICA

## Tecnologias
- Lenguaje: Java - version 17
- Framework: Spring Boot - version 3.3.3
- En base a los requerimientos se utiliza H2 DBMS para el almacenamiento de la informacion.

## Estrategia
Se crearon los endpoints para los autores, el blog y los comentarios, cada uno con su logica de negocio y para las vistas se utilizara thymeleaf que se usa en los formularios y el despliegue de la informacion, los mismo que consumen y envian informacion a los endpoints mencionados.

## Diseno de la base de datos 
![blog_games drawio](https://github.com/user-attachments/assets/3fbc0660-c022-406b-80d9-e874c609b3fe)


## Explicacion del codigo fuente
Se trabajo con tres modelos, los cuales son: post, userblog, comentarios, cada uno con sus services, repositories y controllers para el funcionamiento y creacion de los APIs Rest.
1. Para el registro de un blog es necesario registrarse como un usuario, el mismo registro lo utilizamos para acceder a la pagina web, posteriormente podemos adicionar un nuevo blog.
2. Cuando se creo un blog se puede adicionar un comentario.


