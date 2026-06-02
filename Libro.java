package utng.gtid2.cmjam.tarea;

public class Libro {
 // Atributos privados
    private String isbn;
    private String titulo;
    private String autor;
    private int anio;
    private boolean disponible;
    private int numPaginas;

    // Atributo estático para contar libros
    private static int totalLibros = 0;

    // ── Constructor completo ──────────────────────────────────────────────────
    public Libro(String isbn, String titulo, String autor, int anio, int numPaginas) {
        this.isbn       = isbn;
        this.titulo     = titulo;
        this.autor      = autor;
        setAnio(anio);          // usa setter con validación
        this.disponible  = true;
        this.numPaginas  = numPaginas;
        totalLibros++;
    }

    // ── Constructor sobrecargado (isbn, titulo, autor) → usa this() ───────────
    public Libro(String isbn, String titulo, String autor) {
        this(isbn, titulo, autor, 0, 0);
    }

    // ── Getters ───────────────────────────────────────────────────────────────
    public String getIsbn()       { return isbn; }
    public String getTitulo()     { return titulo; }
    public String getAutor()      { return autor; }
    public int    getAnio()       { return anio; }
    public int    getNumPaginas() { return numPaginas; }

    public boolean isDisponible() { return disponible; }

    public static int getTotalLibros() { return totalLibros; }

    // ── Setters ───────────────────────────────────────────────────────────────
    public void setIsbn(String isbn)           { this.isbn       = isbn; }
    public void setTitulo(String titulo)       { this.titulo     = titulo; }
    public void setAutor(String autor)         { this.autor      = autor; }
    public void setNumPaginas(int numPaginas)  { this.numPaginas = numPaginas; }

    /** Setter con validación: 1450 <= anio <= 2025 */
    public void setAnio(int anio) {
        if (anio < 1450 || anio > 2025) {
            throw new IllegalArgumentException(
                "Año inválido: " + anio + ". Debe estar entre 1450 y 2025.");
        }
        this.anio = anio;
    }

    // ── Métodos de negocio ────────────────────────────────────────────────────

    /**
     * Marca el libro como prestado.
     * @throws IllegalStateException si ya está prestado
     */
    public void prestar() {
        if (!disponible) {
            throw new IllegalStateException(
                "El libro [" + isbn + "] ya está prestado.");
        }
        this.disponible = false;
    }

    /** Marca el libro como devuelto (disponible = true). */
    public void devolver() {
        this.disponible = true;
    }

    // ── toString ──────────────────────────────────────────────────────────────
    @Override
    public String toString() {
        return String.format("[%s] %s por %s (%d) - %s",
            isbn,
            titulo,
            autor,
            anio,
            disponible ? "disponible" : "no disponible");
    }
}
