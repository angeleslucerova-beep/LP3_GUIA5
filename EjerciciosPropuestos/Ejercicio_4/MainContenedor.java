public class MainContenedor {
	public static void main(String[] args) {
        Contenedor<String, String> biblioteca = new Contenedor<>();

        biblioteca.agregarPar("Cien años de soledad", "Gabriel García Márquez");
        biblioteca.agregarPar("1984", "George Orwell");
        biblioteca.agregarPar("El Quijote", "Miguel de Cervantes");

        System.out.println("Mostrar pares");
        biblioteca.mostrarPares();

        System.out.println("Par en indice 1");
        System.out.println(biblioteca.obtenerPar(1));

        System.out.println("Todos los pares");
        for (Par<String, String> p : biblioteca.obtenerTodosLosPares()) {
            System.out.println(p);
        }
    }
}
