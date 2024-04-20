package ar.edu.unju.fi.ejercicio15;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el tamaño que esté dentro del rango [5-10] del array: ");
        if (!scanner.hasNextInt()) {
            System.out.println("No se ingresó un número entero.");
            System.exit(1);
        }
        int cont = scanner.nextInt();

        if (cont >= 5 && cont <= 10) {
            String[] array = new String[cont];

            System.out.println("Ingrese un nombre para llenar el array:");
            String nombre = scanner.next();

            if (nombre.length() <= cont) {
                // Descomponer el nombre en caracteres individuales y almacenarlos en el array
                for (int i = 0; i < nombre.length(); i++) {
                    array[i] = Character.toString(nombre.charAt(i));
                }

                System.out.println("Caracteres del nombre en Orden Normal:");
                for (int i = 0; i < cont; i++) {
                    System.out.println("En el índice " + i + " está almacenado el valor: " + array[i]);
                }

                System.out.println("Caracteres del nombre Al revés:");
                for (int i = nombre.length() - 1, j = 0; i >= 0; i--, j++) {
                    System.out.println("En el índice " + j + " está almacenado el valor: " + array[i]);
                }
            } else {
                System.out.println("El nombre ingresado excede el tamaño permitido del array.");
            }
        } else {
            System.out.println("El tamaño ingresado está fuera del rango especificado.");
        }

        scanner.close();
	}

}
