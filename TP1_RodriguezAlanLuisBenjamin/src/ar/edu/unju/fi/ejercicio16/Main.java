package ar.edu.unju.fi.ejercicio16;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
	        String[] nombres = new String[5];
	        //estructura for
	        System.out.println("Ingrese 5 nombres:");
	        for (int i = 0; i < nombres.length; i++) {
	            System.out.print("Nombre " + (i+1) + ": ");
	            nombres[i] = scanner.nextLine();
	        }
	        
	        // estructura while
	        System.out.println("\nNombres ingresados:");
	        int index = 0;
	        while (index < nombres.length) {
	            System.out.println("[" + index + "] " + nombres[index]);
	            index++;
	        }
	        
	        System.out.println("\nTamaño del arreglo: " + nombres.length);
	        
	        // indice a eliminar con do-while
	        byte indice;
	        do {
	            System.out.print("\nIngrese el índice del elemento a eliminar (0 - 4): ");
	            indice = scanner.nextByte();
	        } while (indice < 0 || indice >= nombres.length);
	        
	        // desplazamiento de los elementos
	        for (int i = indice; i < nombres.length - 1; i++) {
	            nombres[i] = nombres[i + 1];
	        }
	        nombres[nombres.length - 1] = ""; // Asignar un espacio en blanco al último elemento
	        
	        // arreglo después de eliminar el elemento
	        System.out.println("\nArreglo después de eliminar el elemento:");
	        for (int i = 0; i < nombres.length; i++) {
	            System.out.println("[" + i + "] " + nombres[i]);
	        }
	        
	        scanner.close();
	}

}
