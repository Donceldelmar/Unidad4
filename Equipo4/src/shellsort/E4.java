package shellsort;

import java.util.Scanner;

public class E4 {
	public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion;
        int[] datos = null; 
        int n = 0;

        do {
            System.out.println("\n================ MENU SHELL SORT ===================");
            System.out.println("\n===== Elaborado por Gaona Alcantar Diego Angel =====");
            System.out.println("\n1. Capturar datos manualmente");
            System.out.println("2. Generar datos aleatorios");
            System.out.println("3. Ordenar (Shell Sort)");
            System.out.println("4. Mostrar datos");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Limpia el buffer

            switch (opcion) {

                case 1:
                    System.out.print("\n¿Cuántos datos deseas ingresar?: ");
                    n = sc.nextInt();
                    sc.nextLine(); // Limpia buffer
                    datos = new int[n];

                    System.out.println("Ingresa los números:");
                    for (int i = 0; i < n; i++) {
                        System.out.print("Dato " + (i + 1) + ": ");
                        datos[i] = sc.nextInt();
                    }
                    sc.nextLine(); // Limpia buffer
                    pausa(sc);
                    break;

                case 2:
                    System.out.print("\n¿Cuántos datos aleatorios deseas generar?: ");
                    n = sc.nextInt();
                    sc.nextLine(); // Limpia buffer
                    datos = new int[n];

                    for (int i = 0; i < n; i++) {
                        datos[i] = (int)(Math.random() * 100);
                    }
                    System.out.println("\nDatos generados correctamente.");
                    pausa(sc);
                    break;

                case 3:
                    if (datos == null) {
                        System.out.println("\nPrimero debes ingresar o generar datos.");
                    } else {
                        shellSort(datos);
                        System.out.println("\nDatos ordenados correctamente.");
                    }
                    pausa(sc);
                    break;

                case 4:
                    if (datos == null) {
                        System.out.println("\nNo hay datos para mostrar.");
                    } else {
                        System.out.println("\n===== DATOS =====");
                        for (int num : datos) {
                            System.out.print(num + " ");
                        }
                        System.out.println();
                    }
                    pausa(sc);
                    break;

                case 5:
                    System.out.println("\nSaliendo... Gracias por usar el programa.");
                    break;

                default:
                    System.out.println("Opción inválida.");
                    pausa(sc);
            }

        } while (opcion != 5);

        sc.close();
    }

    public static void shellSort(int[] arr) {
        int n = arr.length;
        int salto = n / 2;

        while (salto > 0) {
            for (int i = salto; i < n; i++) {
                int temp = arr[i];
                int j = i;

                while (j >= salto && arr[j - salto] > temp) {
                    arr[j] = arr[j - salto];
                    j -= salto;
                }
                arr[j] = temp;
            }
            salto /= 2;
        }
    }

    public static void pausa(Scanner sc) {
        System.out.println("\nPresiona ENTER para continuar...");
        sc.nextLine();  // Solo espera a ENTER
    }
}
