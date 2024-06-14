import java.util.List;
import java.util.Scanner;

import Utils.InputUtils;
import biblioteca.dao.LibroDAO;
import biblioteca.models.Libro;

public class App {
    public static void main(String[] args) {
        LibroDAO libroDAO = new LibroDAO();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("=== Gestión de Biblioteca ===");
            System.out.println("1. Agregar Libro");
            System.out.println("2. Actualizar Libro");
            System.out.println("3. Eliminar Libro");
            System.out.println("4. Buscar Libros por Título");
            System.out.println("5. Buscar Libros por Autor");
            System.out.println("6. Buscar Libros por Género");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = InputUtils.leerEntero(scanner);

            switch (opcion) {
                case 1:
                    agregarLibro(libroDAO, scanner);
                    break;
                case 2:
                    actualizarLibro(libroDAO, scanner);
                    break;
                case 3:
                    eliminarLibro(libroDAO, scanner);
                    break;
                case 4:
                    buscarLibrosPorTitulo(libroDAO, scanner);
                    break;
                case 5:
                    buscarLibrosPorAutor(libroDAO, scanner);
                    break;
                case 6:
                    buscarLibrosPorGenero(libroDAO, scanner);
                    break;
                case 7:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida, intente de nuevo.");
            }
        } while (opcion != 7);

        scanner.close();
    }

    private static void agregarLibro(LibroDAO libroDAO, Scanner scanner) {
        System.out.print("Ingrese el título: ");
        String titulo = scanner.nextLine();
        System.out.println("-------------------------------");
        System.out.print("Ingrese el autor: ");
        String autor = scanner.nextLine();
        System.out.println("-------------------------------");
        System.out.print("Ingrese el género: ");
        String genero = scanner.nextLine();
        System.out.println("-------------------------------");
        System.out.print("Ingrese el año de publicación: ");
        int anioPublicacion = InputUtils.leerEntero(scanner);
        System.out.println("-------------------------------");

        Libro libro = new Libro(0, titulo, autor, genero, anioPublicacion, true);
        libroDAO.agregarLibro(libro);
        System.out.println("Libro agregado exitosamente.");
    }

    private static void actualizarLibro(LibroDAO libroDAO, Scanner scanner) {
        System.out.print("Ingrese el ID del libro a actualizar: ");
        int id = InputUtils.leerEntero(scanner);
        System.out.println("-------------------------------");
        System.out.print("Ingrese el nuevo título: ");
        String titulo = scanner.nextLine();
        System.out.println("-------------------------------");
        System.out.print("Ingrese el nuevo autor: ");
        String autor = scanner.nextLine();
        System.out.println("-------------------------------");
        System.out.print("Ingrese el nuevo género: ");
        String genero = scanner.nextLine();
        System.out.println("-------------------------------");
        System.out.print("Ingrese el nuevo año de publicación: ");
        int anioPublicacion = InputUtils.leerEntero(scanner);
        System.out.println("-------------------------------");
        System.out.print("¿Está disponible? (true/false): ");
        boolean disponible = Boolean.parseBoolean(scanner.nextLine());
        System.out.println("-------------------------------");

        Libro libro = new Libro(id, titulo, autor, genero, anioPublicacion, disponible);
        libroDAO.actualizarLibro(libro);
        System.out.println("Libro actualizado exitosamente.");
        System.out.println("-------------------------------");
    }

    private static void eliminarLibro(LibroDAO libroDAO, Scanner scanner) {
        System.out.print("Ingrese el ID del libro a eliminar: ");
        int id = InputUtils.leerEntero(scanner);
        libroDAO.eliminarLibro(id);
        System.out.println("Libro eliminado exitosamente.");
        System.out.println("-------------------------------");
    }

    private static void buscarLibrosPorTitulo(LibroDAO libroDAO, Scanner scanner) {
        System.out.print("Ingrese el título: ");
        String titulo = scanner.nextLine();
        System.out.println("-------------------------------");
        List<Libro> libros = libroDAO.buscarLibrosPorTitulo(titulo);
        libros.forEach(System.out::println);
    }

    private static void buscarLibrosPorAutor(LibroDAO libroDAO, Scanner scanner) {
        System.out.print("Ingrese el autor: ");
        String autor = scanner.nextLine();
        System.out.println("-------------------------------");
        List<Libro> libros = libroDAO.buscarLibrosPorAutor(autor);
        libros.forEach(System.out::println);
    }

    private static void buscarLibrosPorGenero(LibroDAO libroDAO, Scanner scanner) {
        System.out.print("Ingrese el género: ");
        String genero = scanner.nextLine();
        System.out.println("-------------------------------");
        List<Libro> libros = libroDAO.buscarLibrosPorGenero(genero);
        libros.forEach(System.out::println);
    }
}