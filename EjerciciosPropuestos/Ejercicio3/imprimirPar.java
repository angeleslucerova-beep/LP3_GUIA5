package e3;

public class imprimirPar {
	public static <F, S> void imprimirpar (Par<F, S> par) {
		System.out.println(par);
	}
	
	 public static void main(String[] args) {
	        imprimirpar(new Par<>("Juan", 25));
	        imprimirpar(new Par<>(3.14, true));
	        imprimirpar(new Par<>(new Persona("Ana", 30), 12345));
		
	}
}
