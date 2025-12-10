package Quicksort;

import java.util.Scanner;

public class E5 {
	
	// Función principal (Main) donde inicia el programa
    public static void main(String[] args) {
    	
    	Scanner teclado = new Scanner(System.in);
		
		String tecla;
        // Definimos un arreglo desordenado de ejemplo
        int[] arreglo = {40, 21, 8, 17, 51, 33};

        System.out.println("Arreglo Original:");
        imprimirArreglo(arreglo);

        // Llamamos a la función de ordenamiento Quicksort
        // Le pasamos el arreglo, el índice inicial (0) y el final (longitud - 1)
        quickSort(arreglo, 0, arreglo.length - 1);

        System.out.println("\nArreglo Ordenado con Quicksort:");
        imprimirArreglo(arreglo);

        // --- SECCIÓN DE AUTORÍA ---
        System.out.println("\n=========================================================================");
        System.out.println("Elaborado por: Gaona Alcantar Juan Isidro");
        System.out.println("=========================================================================");
        
        tecla = teclado.nextLine();
        
        teclado.close();
        
        System.out.println("Programa detenido " + tecla);
        
    }

    /**
     * Método recursivo QuickSort
     * @param arreglo El array a ordenar
     * @param bajo El índice más bajo (inicio del sub-arreglo)
     * @param alto El índice más alto (fin del sub-arreglo)
     */
    public static void quickSort(int[] arreglo, int bajo, int alto) {
        if (bajo < alto) {
            // Encontramos el índice de partición (pi)
            // Aquí es donde el pivote ya está en su lugar correcto
            int pi = particion(arreglo, bajo, alto);

            // Ordenamos recursivamente los elementos antes de la partición
            quickSort(arreglo, bajo, pi - 1);

            // Ordenamos recursivamente los elementos después de la partición
            quickSort(arreglo, pi + 1, alto);
        }
    }

    /**
     * Función Partición: Toma el último elemento como pivote,
     * coloca el pivote en su posición correcta y pone todos los más chicos
     * a la izquierda y los más grandes a la derecha.
     */
    public static int particion(int[] arreglo, int bajo, int alto) {
        // Elegimos el último elemento como Pivote
        int pivote = arreglo[alto];
        
        // Índice del elemento más pequeño
        int i = (bajo - 1); 

        // Recorremos el arreglo desde el bajo hasta el alto - 1
        for (int j = bajo; j < alto; j++) {
            // Si el elemento actual es más pequeño o igual al pivote
            if (arreglo[j] <= pivote) {
                i++; // Incrementamos el índice del menor elemento

                // Intercambiamos arreglo[i] y arreglo[j]
                int temp = arreglo[i];
                arreglo[i] = arreglo[j];
                arreglo[j] = temp;
            }
        }

        // Intercambiamos el arreglo[i+1] con el pivote (arreglo[alto])
        // Esto pone al pivote en su lugar final correcto
        int temp = arreglo[i + 1];
        arreglo[i + 1] = arreglo[alto];
        arreglo[alto] = temp;

        // Retornamos la posición donde quedó el pivote
        return i + 1;
    }

    // Método auxiliar para imprimir el arreglo en consola
    public static void imprimirArreglo(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(arreglo[i] + " ");
        }
        System.out.println();
    }

}
