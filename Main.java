package utng.gtid2.cmjam.tarea;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== Tarea 1: Casos de prueba Clase Libro ===");

        Libro l1 = new Libro("978-1", "Clean Code", "Robert C. Martin", 2008, 431);
        Libro l2 = new Libro("978-2", "Effective Java", "Joshua Bloch");

        l1.prestar();

        System.out.println(l1.isDisponible());          // false
        System.out.println(Libro.getTotalLibros());     // 2
        System.out.println(l1);                         // [978-1] Clean Code por Robert C. Martin (2008) - no disponible

        System.out.println();
        System.out.println("=== Tarea 2: Casos de prueba Clase Catalogo ===");

        Catalogo cat = new Catalogo();
        cat.agregarLibro(l1);
        cat.agregarLibro(l2);

        System.out.println(cat.contarDisponibles());                    // 1 (l1 está prestado)
        System.out.println(cat.buscarPorIsbn("978-2").getTitulo());    // Effective Java

        System.out.println();
        System.out.println("=== Pruebas adicionales ===");

        // Devolver libro
        l1.devolver();
        System.out.println(l1.isDisponible());          // true
        System.out.println(cat.contarDisponibles());    // 2

        // Buscar por autor
        System.out.println(cat.buscarPorAutor("Joshua Bloch").size()); // 1

        // toString catálogo
        System.out.println(cat);                        // Catalogo: 2 libros, 2 disponibles

        // Prestar dos veces → IllegalStateException
        try {
            l1.prestar();
            l1.prestar();  // debe lanzar excepción
        } catch (IllegalStateException e) {
            System.out.println("Excepción capturada: " + e.getMessage());
        }

        // Año inválido → IllegalArgumentException
        try {
            Libro lInvalido = new Libro("000", "Test", "Autor", 1000, 100);
        } catch (IllegalArgumentException e) {
            System.out.println("Excepción capturada: " + e.getMessage());
        }
    }
}

