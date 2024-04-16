package ar.edu.unju.fi.ejercicio13;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		final int Max = 8;
		int[] Array = new int[Max];
		Scanner scanner = new Scanner(System.in);
		
		for(int i = 0 ; i < Max ; i++ ){
			System.out.println("ingrese valores: ");
			Array[i] = scanner.nextInt();
		}
		for(int i = 0 ; i < Max ; i++ ){
			System.out.println("En el indice " + (i+1) + " esta almacenado el valor: " + Array[i]);
		}
		scanner.close();
	}

}
