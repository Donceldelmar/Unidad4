package Ordenamiento;

import java.util.Scanner;

public class E1 {
public static void main(String[] args) {
		
		Scanner teclado=new Scanner(System.in);
		
		String tecla;
		
        int[] datos = {5, 2, 9, 1, 3}; //se crea un arreglo de tipo entero con 5 elementos
        for(int i=0; i<datos.length-1; i++){ //se crea for anidado para poder comparar cada elemento con el resto de los elementos -
            for(int j=i+1; j<datos.length; j++){ // y asi ir determinando cual es mayor y cual es menor
                if(datos[i] > datos[j]){//condición para validar si el númnero en la posición inicial es mayor que el número en la siguiente posición
                    int temp = datos[i]; //variable temporal en la cual se almacena el valor mayor resultante de la comparación entre un elemento y otro
                    datos[i] = datos[j]; // el valor menor toma el lugar del valor mayor
                    datos[j] = temp; //el valor mayor guardado en la variable temporal, toma el lugar del núnero menor
                    //es decir que los números van intercambiando lugares hasta quedar acomodados de menor a mayor
                }
            }
        }

        for(int x : datos){ //ciclo for-each para poder imprimir en consola el arreglo ordenado de menor a mayor
            System.out.print(x + " ");
        }
        System.out.println("\nPresione enter para salir");
        
        System.out.println("\nElaborado por Gaona Alcantar Diego Angel");
        
        tecla=teclado.nextLine();
        
        teclado.close();
        
        
        
        System.out.println("El programa se ha detenido"+ tecla);
        
        
    }

}
