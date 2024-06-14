**Importar la Base de Datos**:

- Abre la consola de MySQL.
- Navega al directorio donde se encuentra el archivo `empresa.sql`.
- Ejecuta el siguiente comando para importar el archivo `empresa.sql`:
  ```bash
  mysql -u root -p < empresa.sql
  ```
- Ingresa la contraseña del usuario `root` cuando si la solicita.

## Configurar el Archivo `.env`

**Agregar las Variables de Entorno**:

- Añade las siguientes líneas al archivo `.env` y reemplace `Usuario` y `Pass` con las credenciales de su usuario de MySQL:
  ```plaintext
  DB_URL=jdbc:mysql://localhost:3306/empresa
  DB_USER=Usuario
  DB_PASSWORD=pass
  ```

## ENUNCIADO DE LA ACTIVIDAD

Imagina que eres un desarrollador de software y te han encargado crear una aplicación de gestión de una biblioteca. La aplicación debe permitir a los usuarios buscar libros por título, autor y género, así como agregar nuevos libros y actualizar la información de aquellos que ya están en la biblioteca. También se debe proporcionar una funcionalidad para eliminar libros que ya no estén disponibles.

 Para implementar esta aplicación, utilizarás una base de datos orientada a objetos, y para ello, seguirás los siguientes pasos:

 1. Investiga las características de las bases de datos orientadas a objetos y realiza un informe donde detalles las ventajas y desventajas de este enfoque.

 2. Instala el gestor de bases de datos que utilizarás en el desarrollo de la aplicación y crea una nueva base de datos.

 3. Diseña y crea la estructura de tablas necesarias para almacenar la información de los libros en la biblioteca.

 4. Implementa las consultas SQL necesarias para realizar búsquedas, actualizaciones y eliminaciones de libros en la base de datos.

 5. Define los tipos de datos objeto y colección que utilizarás en la aplicación para representar libros y otros elementos relevantes.