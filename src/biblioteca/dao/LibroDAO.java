package biblioteca.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import biblioteca.db.ConexionDB;
import biblioteca.models.Libro;

/* 
 * La clase LibroDAO(Data Access Object),según he consultado, es una buena practica ya que  maneja toda la lógica de acceso a datos(CRUD).
 * Encapsulando responsabilidades y dejando a Libro la única responsabilidad de representar a un libro de la biblioteca.
 */
public class LibroDAO {

    /**
     * convertimos los atributos de Libro en PreparedStatements para introducirlo en
     * la DB
     * 
     * @param libro
     */
    public void agregarLibro(Libro libro) {
        String sql = "INSERT INTO libros (titulo, autor, genero, anio_publicacion, disponible) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConexionDB.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, libro.getTitulo());
            pstmt.setString(2, libro.getAutor());
            pstmt.setString(3, libro.getGenero());
            pstmt.setInt(4, libro.getAnioPublicacion());
            pstmt.setBoolean(5, libro.isDisponible());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarLibro(Libro libro) {
        String sql = "UPDATE libros SET titulo = ?, autor = ?, genero = ?, anio_publicacion = ?, disponible = ? WHERE id = ?";

        try (Connection conn = ConexionDB.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, libro.getTitulo());
            pstmt.setString(2, libro.getAutor());
            pstmt.setString(3, libro.getGenero());
            pstmt.setInt(4, libro.getAnioPublicacion());
            pstmt.setBoolean(5, libro.isDisponible());
            pstmt.setInt(6, libro.getId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarLibro(int id) {
        String sql = "DELETE FROM libros WHERE id = ?";

        try (Connection conn = ConexionDB.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Hacemos la consulta a la base de datos y convertimos el resultado en un
     * objeto Libro
     * 
     * @param titulo
     * @return Lista Libro
     */
    public List<Libro> buscarLibrosPorTitulo(String titulo) {
        List<Libro> libros = new ArrayList<>();
        String sql = "SELECT * FROM libros WHERE titulo LIKE ?";

        try (Connection conn = ConexionDB.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, "%" + titulo + "%");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Libro libro = new Libro(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getString("genero"),
                        rs.getInt("anio_publicacion"),
                        rs.getBoolean("disponible"));
                libros.add(libro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return libros;
    }

    /**
     * Hacemos la consulta a la base de datos y convertimos el resultado en un
     * objeto Libro
     * 
     * @param autor
     * @return Lista Libro
     */
    public List<Libro> buscarLibrosPorAutor(String autor) {
        List<Libro> libros = new ArrayList<>();
        String sql = "SELECT * FROM libros WHERE autor LIKE ?";

        try (Connection conn = ConexionDB.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, "%" + autor + "%");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Libro libro = new Libro(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getString("genero"),
                        rs.getInt("anio_publicacion"),
                        rs.getBoolean("disponible"));
                libros.add(libro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return libros;
    }

    /**
     * Hacemos la consulta a la base de datos y convertimos el resultado en un
     * objeto Libro
     * 
     * @param genero
     * @return Lista Libro
     */
    public List<Libro> buscarLibrosPorGenero(String genero) {
        List<Libro> libros = new ArrayList<>();
        String sql = "SELECT * FROM libros WHERE genero = ?";

        try (Connection conn = ConexionDB.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, genero);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Libro libro = new Libro(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getString("genero"),
                        rs.getInt("anio_publicacion"),
                        rs.getBoolean("disponible"));
                libros.add(libro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return libros;
    }
}