package mergeSort;

import java.util.Scanner;

public class E10 {
	
	// Método principal de Merge Sort
    public static void mergeSort(int[] arreglo, int izquierda, int derecha) {

        // Imprime el subarreglo que se va a dividir
        System.out.print("Dividir: ");
        imprimirSubarreglo(arreglo, izquierda, derecha);

        // Si todavía hay más de un elemento en el subarreglo, se sigue dividiendo
        if (izquierda < derecha) {

            // Calcula el punto medio del arreglo
            int medio = (izquierda + derecha) / 2;

            // Ordena recursivamente la mitad izquierda
            mergeSort(arreglo, izquierda, medio);

            // Ordena recursivamente la mitad derecha
            mergeSort(arreglo, medio + 1, derecha);

            // Mezcla ambas mitades ya ordenadas
            merge(arreglo, izquierda, medio, derecha);

            // Imprime el resultado de mezclar
            System.out.print("Mezclar: ");
            imprimirSubarreglo(arreglo, izquierda, derecha);
        }
    }

    // Método que mezcla dos subarreglos ordenados
    public static void merge(int[] arreglo, int izquierda, int medio, int derecha) {

        // Tamaños de los subarreglos
        int n1 = medio - izquierda + 1;
        int n2 = derecha - medio;

        // Arreglos temporales
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copia los elementos al arreglo temporal L[]
        for (int i = 0; i < n1; i++) {
            L[i] = arreglo[izquierda + i];
        }

        // Copia los elementos al arreglo temporal R[]
        for (int j = 0; j < n2; j++) {
            R[j] = arreglo[medio + 1 + j];
        }

        // Índices iniciales
        int i = 0;    // Para L[]
        int j = 0;    // Para R[]
        int k = izquierda; // Para el arreglo original

        // Mezcla los arreglos temporales en orden
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arreglo[k] = L[i];
                i++;
            } else {
                arreglo[k] = R[j];
                j++;
            }
            k++;
        }

        // Copia los elementos restantes de L[]
        while (i < n1) {
            arreglo[k] = L[i];
            i++;
            k++;
        }

        // Copia los elementos restantes de R[]
        while (j < n2) {
            arreglo[k] = R[j];
            j++;
            k++;
        }
    }

    // Método para imprimir un SUBARREGLO desde izquierda hasta derecha
    public static void imprimirSubarreglo(int[] arreglo, int izquierda, int derecha) {
        System.out.print("[ ");
        for (int i = izquierda; i <= derecha; i++) {
            System.out.print(arreglo[i] + " ");
        }
        System.out.println("]");
    }

    // Método para imprimir el arreglo completo
    public static void imprimirArreglo(int[] arreglo) {
        for (int num : arreglo) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Método main para ejecutar el programa
    public static void main(String[] args) {
    	
    	Scanner teclado = new Scanner(System.in);
    	
    	String tecla;
    	
        int[] arreglo = {54, 26, 93, 17, 77, 31, 44, 55, 20};

        System.out.println("Arreglo original:");
        imprimirArreglo(arreglo);

        mergeSort(arreglo, 0, arreglo.length - 1);

        System.out.println("\nArreglo ordenado:");
        imprimirArreglo(arreglo);

        System.out.println("\nPrograma realizado por: Gaona ALcantar Diego Angel");
        
        tecla=teclado.nextLine();
        
        teclado.close();
        
        System.out.println("El programa se ha detenido" + tecla);
    }

}
