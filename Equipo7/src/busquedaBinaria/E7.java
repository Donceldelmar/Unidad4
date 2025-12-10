package busquedaBinaria;

import java.util.Scanner;

public class E7 {
	
	 // Método de búsqueda binaria
    public static int busquedaBinaria(int[] arreglo, int objetivo) {
        int inicio = 0;
        int fin = arreglo.length - 1;

        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;

            if (arreglo[medio] == objetivo) {
                return medio;
            }

            if (arreglo[medio] < objetivo) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] numeros = {3, 8, 15, 23, 42, 56, 72, 91};

        int objetivo = 91;

        int resultado = busquedaBinaria(numeros, objetivo);

        if (resultado != -1) {
            System.out.println("Elemento encontrado en la posición: " + resultado);
        } else {
            System.out.println("Elemento NO encontrado");
        }

        System.out.println("\nCÓDIGO realizado por: GAONA ALCANTAR JUAN ISIDRO");

        System.out.println("\nPresiona ENTER para salir...");
        
        Scanner scanner = new Scanner(System.in);
        
		scanner.nextLine();
		
		scanner.close();
        
        
    }

}
