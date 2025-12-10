package sortmax;

import java.util.Scanner;

public class E2 {
	

    // Método que realiza el algoritmo Selection Sort DESCENDENTE
    public static void selectionSortDescendente(int[] arr) {

        System.out.println(); // Imprime una línea en blanco
        System.out.print("Lista original: "); // Texto previo
        imprimirArreglo(arr); // Imprime el arreglo original
        System.out.println("-----------------------------------");

        // Ciclo principal: recorre cada posición del arreglo
        for (int i = 0; i < arr.length; i++) {

            int maxIndex = i; //  CAMBIO: Ahora buscamos el MÁXIMO

            // Segundo ciclo: busca el valor MÁXIMO en el resto del arreglo
            for (int j = i + 1; j < arr.length; j++) {

                //  CAMBIO: Si encontramos un valor MAYOR, actualizamos maxIndex
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }

            // Intercambio entre el valor actual (i) y el MÁXIMO encontrado
            int temp = arr[i];
            arr[i] = arr[maxIndex];
            arr[maxIndex] = temp;

            // Muestra el progreso del algoritmo después de cada iteración
            System.out.println("Iteración " + (i + 1) + ": máximo = " + arr[i]); //  CAMBIO: "mínimo" por "máximo"
            System.out.print("Estado actual del arreglo: ");
            imprimirArreglo(arr);
            System.out.println("-----------------------------------");
        }
    }

    // Método auxiliar que imprime el contenido de un arreglo (igual)
    public static void imprimirArreglo(int[] arr) {

        // Recorre cada elemento del arreglo
        for (int num : arr) {
            System.out.print(num + " "); // Imprime el número con un espacio
        }
        System.out.println(); // Salto de línea al final
    }

    // Método principal que ejecuta el programa
    public static void main(String[] args) {
    	
    	Scanner teclado = new Scanner(System.in);
    	
    	String tecla;

        int[] numeros = {9, 0, 4, 5, 4, 7, 1}; // Arreglo de prueba sin ordenar

        selectionSortDescendente(numeros); //  CAMBIO: Llamada al método descendente

        System.out.print("Arreglo final ordenado DESCENDENTE: "); //  CAMBIO: texto
        imprimirArreglo(numeros); // Imprime el arreglo ya ordenado

        System.out.println();
        System.out.print("Código realizado por Gaona Alcantar Juan Isidro"); // Mensaje final
        
        tecla=teclado.nextLine();
        
        teclado.close();
        
        System.out.println("El programa se ha detenido"+ tecla);
    }

}
