package OrdInsercion;

import java.util.Scanner;

public class E3 {
	
	 public static void OrdInsercion(int[] a) {

	        int i, j;
	        int aux;

	        for (i = 1; i < a.length; i++) {

	            // Se toma el elemento a insertar
	            j = i;
	            aux = a[i];

	            // Se localiza la posición correcta desplazando elementos hacia arriba
	            while (j > 0 && aux < a[j - 1]) {
	                a[j] = a[j - 1];
	                j--;
	            }

	            // Insertar el elemento en su lugar
	            a[j] = aux;
	        }
	    }

	    // Método para probarlo
	    public static void main(String[] args) {
	    	
	    	Scanner teclado =new Scanner(System.in);
	    	
	    	String tecla;
	    	
	        int[] lista = { 5, 2, 9, 1, 7 };
	        OrdInsercion(lista);

	        for (int x : lista) {
	            System.out.print(x + " ");
	        }
	        
	        System.out.println("\n");
	        
	        System.out.println("Elaborado por: Gaona Alcantar Diego Angel");
	        
	        tecla = teclado.nextLine();
	        
	        teclado.close();
	        
	        System.out.println("Programa detenido: " + tecla);
	    }

}
