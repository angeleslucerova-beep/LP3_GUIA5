class Par<F, S> {
    private F primero;
    private S segundo;

    public Par(F primero, S segundo) {
        this.primero = primero;
        this.segundo = segundo;
    }

    public F getPrimero() {
        return primero;
    }

    public void setPrimero(F primero) {
        this.primero = primero;
    }

    public S getSegundo() {
        return segundo;
    }

    public void setSegundo(S segundo) {
        this.segundo = segundo;
    }

    @Override
    public String toString() {
        return String.format("(Primero: %s, Segundo: %s)", primero, segundo);
    }
}

public class PruebaPar {
    public static void main(String[] args) {
        System.out.println("--- EJERCICIO PROPUESTO 1: Estructura Básica de Par ---");
        
        // Instanciación del objeto genérico con tipos mixtos (Integer y String)
        Par<Integer, String> parEjemplo = new Par<>(102, "Sistemas UCSM");
        System.out.println("Representación del par: " + parEjemplo);
    }
}
