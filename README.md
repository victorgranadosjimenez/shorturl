# 🔍 App Search Engine 


![Imagen del proyecto](https://raw.githubusercontent.com/victorgranadosjimenez/shorturl/refs/heads/master/Captura.JPG?raw=true)




## Ejemplo en vivo
https://victorgranados.com/shorturl/




## Descripción 📑
Es una aplicación web que permite acortar enlaces largos (por ejemplo, de Wikipedia, YouTube, etc.) en una URL corta y sencilla que redirige automáticamente al sitio original.
Funciona como un pequeño servicio tipo bit.ly o tinyurl.





## 🧱 Arquitectura del proyecto
El proyecto sigue una arquitectura hexagonal, separando claramente las capas del sistema.
Esto permite mantener el código organizado, fácil de probar y de escalar.

Las capas principales son:
1. 🧩 Domain (Dominio) : Contiene la lógica de negocio pura, sin depender de frameworks.
   
- ShortUrl → modelo del dominio con los datos esenciales (id, originalUrl, createdAt, visits).
- ShortUrlRepositoryPort → interfaz que define las operaciones que el dominio necesita (guardar, buscar por ID).

3. 🧠 Application (Aplicación / Servicio)
Orquesta la lógica del dominio y coordina las acciones del sistema.
Esta capa usa el repositorio definido en el dominio, pero no sabe cómo se implementa (base de datos, memoria, etc.).

- ShortUrlService  →
Generar un ID corto aleatorio (generateShortId()).
Crear y guardar un nuevo ShortUrl.
Buscar URLs originales para redirigir.


3. 🏗️ Infrastructure (Infraestructura)
Aquí se implementa cómo se conecta el dominio con el mundo real (base de datos, JPA, etc.).
Traduce el modelo del dominio a la base de datos y viceversa.
- ShortUrlEntity → mapea la tabla de la base de datos.
- JpaShortUrlRepository → interfaz que extiende JpaRepository de Spring Data
- ShortUrlRepositoryAdapter → adapta entre el modelo del dominio y la entidad de la base de datos.


4. 🌍 Web (Controladores / API REST)
Expone los endpoints para que el frontend u otros servicios puedan usar la aplicación.
Aquí es donde se conectan los usuarios o el frontend con el sistema.

- ShortUrlController
  
Endpoints principales:
POST /api/shorten → recibe una URL larga y devuelve una versión corta.
Ejemplo:
POST /api/shorten?url=https://www.wikipedia.org
→ Respuesta: https://shorturl-tb38.onrender.com/ugh9eij

GET /{id} → redirige a la URL original si existe.
Ejemplo:
GET /ugh9eij
→ Redirección a https://www.wikipedia.org



💻 Frontend
El frontend es una interfaz sencilla desarrollada con HTML, CSS y JavaScript, que interactúa con el backend mediante fetch.



🚀 Flujo de funcionamiento
1. El usuario introduce una URL larga en el frontend.

2. El frontend hace una petición POST /api/shorten al backend (Render).

3. El backend genera un ID corto aleatorio y lo guarda en la base de datos con la URL original.

4. El backend devuelve un enlace corto, por ejemplo: https://shorturl-tb38.onrender.com/ugh9eij

Cuando alguien visita ese enlace corto:

5. El backend busca el id en la base de datos.

6. Si existe, redirige a la URL original (https://www.wikipedia.org).




⚙️ Cómo ejecutar el proyecto
1. Clona el repositorio:
git clone https://github.com/victorgranadosjimenez/shorturl.git
2. Abre el proyecto en tu IDE (IntelliJ, VSCode o Eclipse).
- Asegúrate de tener MySQL ejecutándose en tu máquina.
3. Ejecuta la aplicación:
mvn spring-boot:run
4. Abre el frontend (por ejemplo con http-server o doble clic en index.html):
npx http-server frontend
5. Visita:
http://localhost:8080/api/documents






## Tecnologías 🛠
[![JAVA](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://es.wikipedia.org/wiki/Java_(lenguaje_de_programaci%C3%B3n))
[![SPRINGBOOT](https://img.shields.io/badge/SpringBoot-6DB33F?style=flat-square&logo=Spring&logoColor=white)](https://en.wikipedia.org/wiki/Spring_Boot)
[![MYSQL](https://img.shields.io/badge/-SQL-000?&logo=MySQL&logoColor=4479A1)](https://en.wikipedia.org/wiki/MySql)
[![JAVASCRIPT](https://shields.io/badge/JavaScript-F7DF1E?logo=JavaScript&logoColor=000&style=flat-square)](https://en.wikipedia.org/wiki/JavaScript)



## Vista previa del proyecto
Si quieres hechas un vistazo al proyecto, te recomiendo:

![Imagen del proyecto](https://raw.githubusercontent.com/victorgranadosjimenez/shorturl/refs/heads/master/Captura.JPG?raw=true)
![Imagen del proyecto](https://raw.githubusercontent.com/victorgranadosjimenez/shorturl/refs/heads/master/Captura2.PNG?raw=true)




## Autor ✒️
VÍCTOR GRANADOS JIMÉNEZ

<img src="https://avatars.githubusercontent.com/u/57761479?v=4" width=115><br>

* [Portafolio](https://victorgranados.com/)
* [Perfil Github](https://github.com/victorgranadosjimenez)
* [Correo](granadosvictor01@gmail.com)
* [LinkedIn](www.linkedin.com/in/victorgranadosjimenez/)




## Instalación 
Este proyecto no necesita de instalación. Simplemente abre la carpeta o haz doble click en el .html


  
## Licencia 📄
MIT Public License v3.0
No puede usarse comencialmente.





