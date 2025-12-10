package busquedaSecuencial;

import java.util.Scanner;

public class E8 {
	
	 // Método que busca un número en un arreglo
    public static int busquedaSecuencial(int[] arreglo, int numeroBuscado) {
        // for: bucle que recorre cada posición del arreglo
        // int i = 0: empezamos en la posición 0 (primera)
        // i < arreglo.length: mientras i sea menor que el tamaño
        // i++: aumentamos i en 1 cada vez
        for (int i = 0; i < arreglo.length; i++) {
            // if: si el elemento actual es igual al buscado
            if (arreglo[i] == numeroBuscado) {
                // return: retornamos la posición donde está
                return i;
            }
        }
        // return -1: si no lo encontramos en todo el arreglo
        return -1;
    }

    // main: método principal que ejecuta Java
    public static void main(String[] args) {
    	
    	Scanner scanner = new Scanner(System.in);
        // Mostrar información del equipo
        System.out.println("Elaborado por: Gaona Alcantar Juan Isidro");
        
        // Crear arreglo con números de ejemplo
        int[] datos = {15, 3, 8, 22, 9, 17, 4, 11};
        
        // Mostrar el arreglo completo
        System.out.print("Arreglo: ");
        // for: recorremos para mostrar cada número
        for (int i = 0; i < datos.length; i++) {
            System.out.print(datos[i] + " ");
        }
        System.out.println(); // Salto de línea
        
        // Número que vamos a buscar
        int objetivo = 9;
        System.out.println("Buscando: " + objetivo);
        
        // Llamar al método de búsqueda
        int resultado = busquedaSecuencial(datos, objetivo);
        
        // if: verificar si encontramos el número
        if (resultado == -1) {
            // No se encontró
            System.out.println("Resultado: No encontrado");
        } else {
            // Se encontró - mostrar posición
            System.out.println("Resultado: Encontrado en posición " + resultado);
        }
        
        System.out.println("Presione enter para salir");
        
        scanner.nextLine();
        
        scanner.close();
    }

}
