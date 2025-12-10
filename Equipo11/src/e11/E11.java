package e11;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class E11 extends JFrame{
	
	private JTextField inputField; // Entrada donde el usuario escribe números
    private JButton sortButton;    // Botón para ordenar
    private JButton exitButton;    // Botón para salir

    public E11() {
        // Configuración básica de la ventana: título, tamaño, cierre y diseño
        setTitle("Fusión Natural");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Se crean los componentes: texto explicativo, caja de entrada y botones
        JLabel label = new JLabel("Ingresa números separados por comas:");
        inputField = new JTextField(25);
        sortButton = new JButton("Ordenar");
        exitButton = new JButton("Salir");
        JLabel label2 = new JLabel("Elaborado por: Gaona Alcantar Juan Isidro");

        // Se añaden los componentes a la ventana
        add(label);
        
        add(inputField);
        add(sortButton);
        add(exitButton);
        add(label2);

        // Se definen las acciones de los botones
        sortButton.addActionListener(e -> ordenar()); // Ordena al dar clic
        exitButton.addActionListener(e -> System.exit(0)); // Cierra el programa
    }

    private void ordenar() {
        try {
            // Convierte la entrada en números y aplica el algoritmo
            String[] partes = inputField.getText().split(",");
            int[] numeros = Arrays.stream(partes).map(String::trim).mapToInt(Integer::parseInt).toArray();
            int[] resultado = fusionNatural(numeros);

            // Muestra el resultado en una ventana emergente
            JOptionPane.showMessageDialog(this, "Ordenado: " + Arrays.toString(resultado));
        } catch (Exception ex) {
            // Si hay error en la entrada, se avisa al usuario
            JOptionPane.showMessageDialog(this, "Entrada inválida. Usa números separados por comas.");
        }
    }

    private int[] fusionNatural(int[] arreglo) {
        // Detecta sublistas ordenadas dentro del arreglo
        ArrayList<ArrayList<Integer>> runs = new ArrayList<>();
        ArrayList<Integer> run = new ArrayList<>();
        run.add(arreglo[0]);

        for (int i = 1; i < arreglo.length; i++) {
            if (arreglo[i] >= arreglo[i - 1]) {
                run.add(arreglo[i]);
            } else {
                runs.add(run);
                run = new ArrayList<>();
                run.add(arreglo[i]);
            }
        }
        runs.add(run);

        // Va fusionando las sublistas hasta que quede una sola lista ordenada
        while (runs.size() > 1) {
            ArrayList<ArrayList<Integer>> nuevas = new ArrayList<>();
            for (int i = 0; i < runs.size(); i += 2) {
                if (i + 1 < runs.size()) {
                    nuevas.add(merge(runs.get(i), runs.get(i + 1)));
                } else {
                    nuevas.add(runs.get(i));
                }
            }
            runs = nuevas;
        }

        return runs.get(0).stream().mapToInt(Integer::intValue).toArray();
    }

    private ArrayList<Integer> merge(ArrayList<Integer> a, ArrayList<Integer> b) {
        // Junta dos sublistas ordenadas en una sola
        ArrayList<Integer> resultado = new ArrayList<>();
        int i = 0, j = 0;

        while (i < a.size() && j < b.size()) {
            if (a.get(i) <= b.get(j)) {
                resultado.add(a.get(i++));
            } else {
                resultado.add(b.get(j++));
            }
        }

        // Agrega lo que quede en cualquiera de las dos listas
        while (i < a.size()) resultado.add(a.get(i++));
        while (j < b.size()) resultado.add(b.get(j++));

        return resultado;
    }

    public static void main(String[] args) {
        // Lanza la aplicación y muestra la ventana
        SwingUtilities.invokeLater(() -> new E11().setVisible(true));
    }

}
