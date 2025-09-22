package Desafios;
import java.util.Arrays;
import java.util.List;
public class Desafio3 {

	public static void main(String[] args) {
		List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, -3, -4, -5 );
		numeros.stream()
		.filter (Desafio3 :: isPositivo )
	    .sorted()
	    .forEach (numero -> System.out.println (numero));
		
	}
private static boolean isPositivo(int numero) {
	return numero > 0; 
	
	
	
	
}
}
