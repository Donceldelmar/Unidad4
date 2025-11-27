package ordenarVectorRacional;

import java.util.Scanner;
import java.util.Vector;

//---------------------------------------------------------
//Interfaz Comparador
//Esta interfaz define los métodos que permiten comparar
//dos objetos cualquiera (Object). Las clases que la
//implementen deben definir cómo saber si un objeto es:
//
//- igual
//- menor
//- menor o igual
//- mayor
//- mayor o igual
//
//Es útil para ordenar elementos de un Vector.
//---------------------------------------------------------
interface Comparador {
 boolean igualQue(Object op2);
 boolean menorQue(Object op2);
 boolean menorIgualQue(Object op2);
 boolean mayorQue(Object op2);
 boolean mayorIgualQue(Object op2);
}

//---------------------------------------------------------
//Clase Racional (representa una fracción A/B)
//Implementa la interfaz Comparador para definir cómo se
//comparan dos números racionales.
//
//Aquí se comparan convirtiéndolos a valores decimales.
//---------------------------------------------------------

class Racional implements Comparador {

    private int numerador, denominador;

    // Constructor: crea una fracción dada.
    // Lanza excepción si el denominador es cero.
    public Racional(int n, int d) throws Exception {
        if (d == 0)
            throw new Exception("Denominador == 0"); // No existe división por cero
        numerador = n;
        denominador = d;
    }

    // Devuelve el valor decimal del racional para poder compararlo
    private double valorDecimal() {
        return (double) numerador / denominador;
    }

    // Compara si dos racionales son iguales
    public boolean igualQue(Object op2) {
        Racional r = (Racional) op2;
        return valorDecimal() == r.valorDecimal();
    }

    // Compara si este racional es menor que otro
    public boolean menorQue(Object op2) {
        Racional r = (Racional) op2;
        return valorDecimal() < r.valorDecimal();
    }

    // Menor o igual
    public boolean menorIgualQue(Object op2) {
        Racional r = (Racional) op2;
        return valorDecimal() <= r.valorDecimal();
    }

    // Mayor que
    public boolean mayorQue(Object op2) {
        Racional r = (Racional) op2;
        return valorDecimal() > r.valorDecimal();
    }

    // Mayor o igual
    public boolean mayorIgualQue(Object op2) {
        Racional r = (Racional) op2;
        return valorDecimal() >= r.valorDecimal();
    }

    // Devuelve la representación en texto de la fracción
    public String toString() {
        return numerador + "/" + denominador;
    }
}

public class E6 {
	
	public static void ordVector(Vector<Racional> v) {

        boolean interruptor = true; // Indica si hubo intercambios en la pasada
        int n = v.size();           // Tamaño del vector

        // Realiza pasadas mientras haya cambios
        for (int pasada = 0; pasada < n - 1 && interruptor; pasada++) {

            interruptor = false; // Si no cambia nada en una pasada, ya está ordenado

            // Recorre elementos adyacentes
            for (int j = 0; j < n - pasada - 1; j++) {

                // Elemento actual
                Racional actual = v.elementAt(j);

                // Si está mayor que el siguiente → intercambio
                if (actual.mayorQue(v.elementAt(j + 1))) {
                    interruptor = true;   // Hubo cambio
                    intercambiar(v, j, j + 1);
                }
            }
        }
    }

    // Intercambia dos elementos del vector usando una variable temporal
    private static void intercambiar(Vector<Racional> v, int i, int j) {
        Racional aux = v.elementAt(i);        // Guarda el elemento i
        v.setElementAt(v.elementAt(j), i);    // Mueve j a i
        v.setElementAt(aux, j);               // Pone i en j
    }

    //-----------------------------------------------------
    // MAIN
    // Aquí inicia el programa:
    // 1. Crea un vector de racionales
    // 2. Pide 10 fracciones al usuario (con Scanner)
    // 3. Muestra el vector sin ordenar
    // 4. Lo ordena con burbuja
    // 5. Lo muestra ordenado
    // 6. Espera ENTER para cerrar
    //-----------------------------------------------------
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in); // Para leer del teclado

        Vector<Racional> v = new Vector<Racional>(2); // Vector con capacidad para 10 racionales

        System.out.println("Introduce 2 racionales:");

        // Se piden 10 fracciones al usuario
        for (int i = 0; i < 2; i++) {
            System.out.println("\nRacional " + (i + 1));

            System.out.print(" Numerador: ");
            int num = sc.nextInt();
            

            System.out.print(" Denominador: ");
            int den = sc.nextInt();
           

            // Se agregan al vector
            v.addElement(new Racional(num, den));
        }

        // Mostrar vector sin ordenar
        System.out.println("\nVector sin ordenar:");
        for (Racional r : v)
            System.out.println(r);

        // Ordenarlo
        ordVector(v);

        // Mostrar vector ordenado
        System.out.println("\nVector ordenado:");
        for (Racional r : v)
            System.out.println(r);

        // Pausa final antes de cerrar el programa
         System.out.println("\nCodigo realizado por Gaona Alcantar Diego Angel");
        System.out.println("\nPresiona ENTER para cerrar...");
        sc.nextLine(); // Limpia buffer del scanner
        sc.nextLine(); // Espera el ENTER final
        
        sc.close();
    }

}
