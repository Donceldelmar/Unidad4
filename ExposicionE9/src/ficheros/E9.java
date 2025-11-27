package ficheros;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class E9 {
	
	public static void main (String [] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		//Crear archivo con el nombre:archivo Equipo9
		
		File miArchivo = new File("archivoEquipo9.txt");
		
		//Si no se crea el archivo
		if(!miArchivo.exists()) {
			
			try {
				
				miArchivo.createNewFile();
				System.out.println(miArchivo.getName() + " ha sido creado por: Gaona Alcantar Diego Angel\n");
				
				
				//Captura las excepciones ante posibles errores
			}catch(IOException ex) {//se crea un objeto IOException
				
				ex.printStackTrace();
				
			}
		}
		
		
		//preguntas de verdadero y falso para verificar si nuestro archivo funciona correctamente
		System.out.println("¿Se puede leer? "+ miArchivo.canRead());
		System.out.println("¿Se puede escribir? " + miArchivo.canWrite());
		System.out.println("¿Se puede ejecutar? " + miArchivo.canExecute());
		System.out.println("¿Es un directorio? " + miArchivo.isDirectory());
		System.out.println("Fecha de actualizaciòn: " + miArchivo.lastModified());
		System.out.println("Tamaño: " + miArchivo.length()+"\n");
		
		System.out.println("Elaborado por Gaona Alcantar Diego Angel");
		System.out.println("Presione enter para salir");
		
		scanner.nextLine();
		scanner.close();
		
		
	}

}
