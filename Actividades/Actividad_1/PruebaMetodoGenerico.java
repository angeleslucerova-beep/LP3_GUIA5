// 1. Definición de la excepción personalizada requerida
class InvalidSubscriptException extends RuntimeException {
    public InvalidSubscriptException(String mensaje) {
        super(mensaje);
    }
}

public class PruebaMetodoGenerico {

    public static <E> void imprimirArreglo(E[] arregloEntrada) {
        for (E elemento : arregloEntrada) {
            System.out.printf("%s ", elemento);
        }
        System.out.println();
    }

    // 2. MÉTODO SOBRECARGADO 
    public static <E> int imprimirArreglo(E[] arregloEntrada, int subindiceInferior, int subindiceSuperior) {
        
        // Validación de rangos e índices
        if (subindiceInferior < 0 || 
            subindiceSuperior >= arregloEntrada.length || 
            subindiceSuperior <= subindiceInferior) {
            
            throw new InvalidSubscriptException("Índices inválidos: Fuera de rango o subindiceSuperior es menor/igual a subindiceInferior.");
        }

        int cantidadImpresos = 0;
        
        for (int i = subindiceInferior; i <= subindiceSuperior; i++) {
            System.out.printf("%s ", arregloEntrada[i]);
            cantidadImpresos++;
        }
        System.out.println();

        return cantidadImpresos;
    }

    public static void main(String args[]) {

        Integer[] arregloInteger = { 1, 2, 3, 4, 5, 6 };
        Double[] arregloDouble = { 1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7 };
        Character[] arregloCharacter = { 'H', 'O', 'L', 'A' };

        // --- EJECUCIÓN VERSIÓN 1 (Método Original) ---
        System.out.println("--- Versión Original (Todo el arreglo) ---");
        System.out.print("arregloInteger contiene: ");
        imprimirArreglo(arregloInteger); 

        System.out.print("arregloDouble contiene: ");
        imprimirArreglo(arregloDouble); 

        System.out.print("arregloCharacter contiene: ");
        imprimirArreglo(arregloCharacter); 

        // --- EJECUCIÓN VERSIÓN 2 (Método Sobrecargado - Casos Válidos) ---
        System.out.println("\n--- Versión Sobrecargada (Por rangos válidos) ---");
        
        int totalInt = imprimirArreglo(arregloInteger, 1, 4); // Debe imprimir del índice 1 al 4
        System.out.println("Cantidad de elementos impresos: " + totalInt);

        int totalDouble = imprimirArreglo(arregloDouble, 2, 5); // Debe imprimir del índice 2 al 5
        System.out.println("Cantidad de elementos impresos: " + totalDouble);

        int totalChar = imprimirArreglo(arregloCharacter, 0, 2); // Debe imprimir del índice 0 al 2
        System.out.println("Cantidad de elementos impresos: " + totalChar);

        // --- PRUEBA DE CONTROL DE EXCEPCIONES ---
        System.out.println("\n--- Probando Lanzamiento de Excepciones ---");
        try {
            // Esto fallará porque el índice superior (10) excede el tamaño del arreglo
            imprimirArreglo(arregloInteger, 0, 10); 
        } catch (InvalidSubscriptException e) {
            System.out.println("Excepción capturada con éxito: " + e.getMessage());
        }

        try {
            // Esto fallará porque el subindiceSuperior es menor o igual al inferior
            imprimirArreglo(arregloCharacter, 3, 1); 
        } catch (InvalidSubscriptException e) {
            System.out.println("Excepción capturada con éxito: " + e.getMessage());
        }
    }
}
