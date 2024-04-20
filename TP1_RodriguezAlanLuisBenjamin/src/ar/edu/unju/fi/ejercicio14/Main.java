package ar.edu.unju.fi.ejercicio14;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);
        
        System.out.println("Ingrese un número entero en el rango [3, 10]: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Error: No se ingresó un número entero.");
            System.exit(1);
        }
        int cant = scanner.nextInt();
        
        if (cant < 3 || cant > 10) {
            System.out.println("Error: El número ingresado está fuera del rango especificado.");
            System.exit(1);
        }
        
        int[] array = new int[cant];
        
        System.out.println("Ingrese " + cant + " números enteros para llenar el array:");
        for (int i = 0; i < cant; i++) {
            if (!scanner.hasNextInt()) {
                System.out.println("Error: No se ingresó un número entero.");
                System.exit(1);
            }
            array[i] = scanner.nextInt();
        }
        
        System.out.println("Valores almacenados en el array:");
        for (int i = 0; i < cant; i++) {
            System.out.println("En la posición " + (i + 1) + " está almacenado el valor: " + array[i]);
        }
        
        int totalSum = 0;
        for (int value : array) {
            totalSum += value;
        }
        System.out.println("La suma total de los valores es: " + totalSum);
        
        scanner.close();
	}

}
