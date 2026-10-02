import java.util.ArrayList;

// Excepción personalizada
class HistorialVacioException extends RuntimeException {
    public HistorialVacioException(String mensaje) {
        super(mensaje);
    }
}

// Clase genérica
class Historial<E> {
    private final ArrayList<E> registros = new ArrayList<>();

    public void agregar(E elemento) {
        registros.add(elemento);
    }

    public E obtenerUltimo() {
        if (registros.isEmpty()) {
            throw new HistorialVacioException("El historial esta vacio, no hay ultimo registro.");
        }
        return registros.get(registros.size() - 1);
    }

    public E eliminarUltimo() {
        if (registros.isEmpty()) {
            throw new HistorialVacioException("El historial esta vacio, no se puede eliminar.");
        }
        return registros.remove(registros.size() - 1);
    }

    public void mostrar() {
        if (registros.isEmpty()) {
            throw new HistorialVacioException("El historial esta vacio, no hay elementos que mostrar.");
        }
        System.out.println("Historial actual (" + registros.size() + " registros):");
        for (int i = 0; i < registros.size(); i++) {
            System.out.println((i + 1) + ". " + registros.get(i));
        }
    }

    // Método genérico acotado con Comparable
    public static <T extends Comparable<T>> T maximo(Historial<T> historial) {
        if (historial.registros.isEmpty()) {
            throw new HistorialVacioException("El historial esta vacio, no hay maximo.");
        }
        T mayor = historial.registros.get(0);
        for (T actual : historial.registros) {
            if (actual.compareTo(mayor) > 0) {
                mayor = actual;
            }
        }
        return mayor;
    }
}
