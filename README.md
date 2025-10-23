# 🔍 App Search Engine 


![Imagen del proyecto](https://raw.githubusercontent.com/victorgranadosjimenez/search-engine/refs/heads/master/Captura.JPG?raw=true)
![Imagen del proyecto](https://raw.githubusercontent.com/victorgranadosjimenez/search-engine/refs/heads/master/diagrama.png?raw=true)




## Ejemplo en vivo
https://victorgranados.com/shorturl/




## Descripción 📑
Es una aplicación web que permite acortar enlaces largos (por ejemplo, de Wikipedia, YouTube, etc.) en una URL corta y sencilla que redirige automáticamente al sitio original.
Funciona como un pequeño servicio tipo bit.ly o tinyurl.




## Etapas del proyecto:

🧩 1. Indexación
- Añadimos documentos (título + contenido) con endpoint POST "/api/documents"
- Los procesamos (tokenizar, eliminar stopwords, normalizar).
- Creamos un índice invertido que nos dice en qué documentos aparece cada palabra 
y lo guardamos en Base de datos.


🔍 2. Búsqueda
 Dado un texto de búsqueda, encontrar los documentos más relevantes por palabras clave.
 Usar algoritmos de ranking básicos (TF-IDF).




⚡ 3. Interfaz o API
Buscamos con un endpoint REST  /search?q=palabra
Muestra primero los documentos más relevantes, según cuántas veces aparece la palabra.
Además:
- Resaltamos en amarillo las coincidencias en los resultados.
- podemos ver el índice invertido.
- Permitimos búsquedas con ranking de relevancia (TF-IDF)




## 🧱 Arquitectura del proyecto
El proyecto sigue una arquitectura hexagonal, separando claramente las capas del sistema.
Esto permite mantener el código organizado, fácil de probar y de escalar.

Las capas principales son:
1. 🧩 Domain (Dominio) : Contiene la lógica de negocio pura, sin depender de frameworks.
   
*ShortUrl* → modelo del dominio con los datos esenciales (id, originalUrl, createdAt, visits).
ShortUrlRepositoryPort → interfaz que define las operaciones que el dominio necesita (guardar, buscar por ID).

3. 🧠 Application (Aplicación / Servicio)
Orquesta la lógica del dominio y coordina las acciones del sistema.
Esta capa usa el repositorio definido en el dominio, pero no sabe cómo se implementa (base de datos, memoria, etc.).

ShortUrlService  →
Generar un ID corto aleatorio (generateShortId()).
Crear y guardar un nuevo ShortUrl.
Buscar URLs originales para redirigir.



3. 🏗️ Infrastructure (Infraestructura)

Aquí se implementa cómo se conecta el dominio con el mundo real (base de datos, JPA, etc.).

Paquetes:

shorturl.infrastructure.entity → define la entidad ShortUrlEntity que mapea la tabla de la base de datos.

shorturl.infrastructure.repository → contiene:

JpaShortUrlRepository (interfaz que extiende JpaRepository de Spring Data)

ShortUrlRepositoryAdapter → adapta entre el modelo del dominio y la entidad de la base de datos.

💡 Esta capa traduce el modelo del dominio a la base de datos y viceversa.

4. 🌍 Web (Controladores / API REST)

Expone los endpoints para que el frontend u otros servicios puedan usar la aplicación.

Paquete: shorturl.web
Clase: ShortUrlController

Endpoints principales:

POST /api/shorten → recibe una URL larga y devuelve una versión corta.
Ejemplo:

POST /api/shorten?url=https://www.wikipedia.org
→ Respuesta: https://shorturl-tb38.onrender.com/ugh9eij


GET /{id} → redirige a la URL original si existe.
Ejemplo:

GET /ugh9eij
→ Redirección a https://www.wikipedia.org


💡 Aquí es donde se conectan los usuarios o el frontend con el sistema.




## 🚀 Endpoints principales (API REST)

# GET	/api/documents
Devuelve todos los documentos
# POST	/api/documents
Crea un nuevo documento
# GET	/api/documents/search?q=palabra
Busca documentos que contengan la palabra
# GET	/api/documents/search/ranked?q=palabra
Devuelve resultados ordenados por relevancia
# GET	/api/documents/index
Devuelve el índice invertido completo




💻 Frontend
El frontend es una interfaz sencilla desarrollada con HTML, CSS y JavaScript, que interactúa con el backend mediante fetch.
Funcionalidades:
- Añadir nuevos documentos
- Buscar por palabra clave o ranking
- Ver el índice invertido en formato JSON
Interfaz responsive con estilo minimalista tipo Google




🧠 Lógica del índice invertido
Cada documento se tokeniza (palabras individuales), y se crea una estructura Map<String, Set<Long>>, donde cada palabra apunta a los IDs de los documentos que la contienen.
Esto permite realizar búsquedas rápidas sin escanear todo el texto.




⚙️ Cómo ejecutar el proyecto
1. Clona el repositorio:
git clone https://github.com/victorgranadosjimenez/search-engine.git
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

![Imagen del proyecto](https://raw.githubusercontent.com/victorgranadosjimenez/search-engine/refs/heads/master/Captura.JPG?raw=true)
![Imagen del proyecto](https://raw.githubusercontent.com/victorgranadosjimenez/search-engine/refs/heads/master/Captura1.JPG?raw=true)




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





