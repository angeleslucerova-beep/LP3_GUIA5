class ExcepcionPilaLlena extends RuntimeException {
    public ExcepcionPilaLlena(String mensaje) {
        super(mensaje);
    }
}

class ExcepcionPilaVacia extends RuntimeException {
    public ExcepcionPilaVacia(String mensaje) {
        super(mensaje);
    }
}

class Pila<E> {
    private final int tamanio; 
    private int superior; 
    private E[] elementos; 

    public Pila() {
        this(10); 
    } 

    @SuppressWarnings("unchecked")
    public Pila(int s) {
        tamanio = s > 0 ? s : 10; 
        superior = -1; 
        elementos = (E[]) new Object[tamanio]; 
    } 

    // Mete un elemento en la pila
    public void push(E valorAMeter) {
        if (superior == tamanio - 1) {
            throw new ExcepcionPilaLlena(String.format("La Pila está llena, no se puede meter %s", valorAMeter));
        }
        elementos[++superior] = valorAMeter; 
    } 

    // Elimina y devuelve el último elemento
    public E pop() {
        if (superior == -1) {
            throw new ExcepcionPilaVacia("Pila vacía, no se puede sacar");
        }
        return elementos[superior--]; 
    } 

    // --- NUEVO MÉTODO IMPLEMENTADO PARA LA ACTIVIDAD 2 ---
    public boolean contains(E elemento) {

        for (int i = superior; i >= 0; i--) {
            // Manejo seguro de comparación de objetos evitando NullPointerException
            if (elementos[i] == elemento || (elementos[i] != null && elementos[i].equals(elemento))) {
                return true; // Se encontró el elemento
            }
        }
        return false; 
    }
}


public class PruebaPila {
    public static void main(String[] args) {

        Pila<String> miPila = new Pila<>(5);

        miPila.push("Fondo");
        miPila.push("Medio");
        miPila.push("Tope");

        System.out.println("--- Probando el método contains(E elemento) ---");
        
        System.out.println("¿Contiene 'Tope'?: " + miPila.contains("Tope"));    // Debe ser true
        System.out.println("¿Contiene 'Medio'?: " + miPila.contains("Medio"));  // Debe ser true
        System.out.println("¿Contiene 'Fondo'?: " + miPila.contains("Fondo"));  // Debe ser true

        System.out.println("¿Contiene 'Inexistente'?: " + miPila.contains("Inexistente")); // Debe ser false

        System.out.println("\n--- Verificación de Inmutabilidad ---");
        // Sacamos un elemento para comprobar que la pila no se alteró durante las búsquedas
        System.out.println("Elemento en el tope real extraído con pop(): " + miPila.pop()); // Debe seguir siendo "Tope"
    }
}
