public class Actividad4 {
    public static void main(String[] args) {
        System.out.println("=== HISTORIAL DE NAVEGACION (String) ===");
        Historial<String> navegador = new Historial<>();
        navegador.agregar("google.com");
        navegador.agregar("ucsm.edu.pe");
        navegador.agregar("github.com");
        navegador.mostrar();
        System.out.println("Ultimo registro: " + navegador.obtenerUltimo());
        System.out.println("Eliminado: " + navegador.eliminarUltimo());
        navegador.mostrar();

        System.out.println("\n=== HISTORIAL DE NOTAS (Integer) ===");
        Historial<Integer> notas = new Historial<>();
        notas.agregar(15);   // autoboxing
        notas.agregar(18);
        notas.agregar(12);
        notas.mostrar();
        System.out.println("Nota maxima (Comparable): " + Historial.maximo(notas));

        System.out.println("\n=== PROBANDO HISTORIAL VACIO ===");
        Historial<Double> vacio = new Historial<>();
        try {
            vacio.eliminarUltimo();
        } catch (HistorialVacioException e) {
            System.out.println("Capturado: " + e.getMessage());
        }
    }
}
