package biblioteca.models;

public class Libro {
    private int id;
    private String titulo;
    private String autor;
    private String genero;
    private int anioPublicacion;
    private boolean disponible;

    // Constructor
    public Libro(int id, String titulo, String autor, String genero, int anioPublicacion, boolean disponible) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.anioPublicacion = anioPublicacion;
        this.disponible = disponible;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "Libro:" +
                "\nId= " + id +
                "\nTitulo= " + titulo +
                "\nAutor= " + autor +
                "\nGenero= " + genero +
                "\nAño de publicación= " + anioPublicacion +
                "\nDisponible= " + disponible +
                "\n-------------------------------";
    }
}