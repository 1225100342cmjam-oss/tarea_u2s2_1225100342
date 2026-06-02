package utng.gtid2.cmjam.tarea;
import java.util.ArrayList;

public class Catalogo {

    // Atributo privado: lista de libros
    private ArrayList<Libro> libros;

    // ── Constructor ───────────────────────────────────────────────────────────
    public Catalogo() {
        this.libros = new ArrayList<>();
    }

    // ── Métodos ───────────────────────────────────────────────────────────────

    /** Agrega un libro al catálogo. */
    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    /**
     * Busca un libro por ISBN.
     * @return el Libro encontrado, o null si no existe
     */
    public Libro buscarPorIsbn(String isbn) {
        for (Libro l : libros) {
            if (l.getIsbn().equals(isbn)) {
                return l;
            }
        }
        return null;
    }

    /**
     * Busca libros por autor (coincidencia exacta).
     * @return lista (puede estar vacía) de libros de ese autor
     */
    public ArrayList<Libro> buscarPorAutor(String autor) {
        ArrayList<Libro> resultado = new ArrayList<>();
        for (Libro l : libros) {
            if (l.getAutor().equals(autor)) {
                resultado.add(l);
            }
        }
        return resultado;
    }

    /**
     * Lista todos los libros disponibles.
     * @return ArrayList con los libros cuyo estado es disponible
     */
    public ArrayList<Libro> listarDisponibles() {
        ArrayList<Libro> disponibles = new ArrayList<>();
        for (Libro l : libros) {
            if (l.isDisponible()) {
                disponibles.add(l);
            }
        }
        return disponibles;
    }

    /** Cuenta cuántos libros están disponibles. */
    public int contarDisponibles() {
        int count = 0;
        for (Libro l : libros) {
            if (l.isDisponible()) count++;
        }
        return count;
    }

    /** Resumen del catálogo: "Catalogo: N libros, M disponibles" */
    @Override
    public String toString() {
        return String.format("Catalogo: %d libros, %d disponibles",
            libros.size(), contarDisponibles());
    }
}
