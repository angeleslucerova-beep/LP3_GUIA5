class ParE2<F, S> {
    private F primero;
    private S segundo;

    public ParE2(F primero, S segundo) {
        this.primero = primero;
        this.segundo = segundo;
    }

    public F getPrimero() { return primero; }
    public void setPrimero(F primero) { this.primero = primero; }
    public S getSegundo() { return segundo; }
    public void setSegundo(S segundo) { this.segundo = segundo; }

    @Override
    public String toString() {
        return String.format("(Primero: %s, Segundo: %s)", primero, segundo);
    }


    public boolean esIgual(ParE2<F, S> otroPar) {
        if (otroPar == null) {
            return false;
        }

        // Comparación segura del primer atributo (contenido profundo)
        boolean primeroIgual = (this.primero == otroPar.getPrimero()) || 
                               (this.primero != null && this.primero.equals(otroPar.getPrimero()));

        // Comparación segura del segundo atributo (contenido profundo)
        boolean segundoIgual = (this.segundo == otroPar.getSegundo()) || 
                               (this.segundo != null && this.segundo.equals(otroPar.getSegundo()));

        // Devuelve verdadero únicamente si coinciden ambos campos en el mismo orden
        return primeroIgual && segundoIgual;
    }
}

public class PruebaParIgualdad {
    public static void main(String[] args) {
        System.out.println("--- EJERCICIO PROPUESTO 2: Evaluación del Método esIgual ---");

        // Instanciación de instancias con idénticos valores
        ParE2<String, Integer> parA = new ParE2<>("Sistemas", 2026);
        ParE2<String, Integer> parB = new ParE2<>("Sistemas", 2026);
        
        // Instanciación de una instancia con valores diferentes
        ParE2<String, Integer> parC = new ParE2<>("Industrial", 2026);

        System.out.println("parA: " + parA);
        System.out.println("parB: " + parB);
        System.out.println("parC: " + parC);

        // Pruebas relacionales en consola
        System.out.println("\n¿Es parA igual a parB? (Mismo contenido y orden): " + parA.esIgual(parB)); // true
        System.out.println("¿Es parA igual a parC? (Diferentes valores): " + parA.esIgual(parC));     // false
    }
}
