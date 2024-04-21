package ar.edu.unju.fi.ejercicio17main;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import ar.edu.unju.fi.ejercicio17model.Jugador;
public class Main {

	public static void main(String[] args) {
		ArrayList<Jugador> Jugadores = new ArrayList<Jugador>();
		Scanner sc = new Scanner (System.in);
		int Opcion = 0,Cant = 0;
		while(Opcion != 8){
			System.out.println("------------");
			System.out.println("***Menu***");
			System.out.println("1-Alta de jugador");
			System.out.println("2-Mostrar Datos del jugador");
			System.out.println("3-Mostrar todos los jugadores ordenados por apellido");
			System.out.println("4-Modificar los datos de un jugador");
			System.out.println("5-Eliminar un jugador");
			System.out.println("6-Mostrar la cantidad total de jugadores que tiene el ArrayList");
			System.out.println("7-Mostrar la cantidad de jugadores que pertenecen a una nacionalidad");
			System.out.println("8-Salir");
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------");
			
			Opcion = sc.nextInt();
			
			switch(Opcion){
			case 1:{
				
				Jugador jugador = new Jugador();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				Boolean band = false;
				LocalDate FechaNac = null;
				
				
				System.out.println("**Ingrese los datos del  jugador**");
				System.out.println("Nombre: ");
				String Nombre = sc.next();
				jugador.setNombre(Nombre);
				
				System.out.println("Apellido: ");
				String Apellido = sc.next();
				jugador.setApellido(Apellido);
				
				System.out.println("Fecha de Nacimiento (yyyy-MM-dd): ");
				do{
					String Fecha = sc.next();
					try {
						FechaNac = LocalDate.parse(Fecha, formatter);
						band = true;
					}catch (Exception e) {
						System.out.println("Formato incorrecto. Asegúrate de que esté en el formato correcto (yyyy-MM-dd).");
						System.out.println("Ingrese otra vez: ");
					}
				}while(band != true);
				band = false;
				jugador.setFechaNac(FechaNac);
				
				System.out.println("Nacionalidad: ");
				String Nacionalidad = sc.next();
				jugador.setNacionalidad(Nacionalidad);
				
				System.out.println("Estatura (metros con ,): ");
				do{
					try {
						float estatura = sc.nextFloat();
						jugador.setEstatura(estatura);
						band = true;
					}catch (Exception e) {
						System.out.println("formato invalido");
						System.out.println("Ingrese otra vez: ");
						sc.nextLine();
					}
				}while(band != true);
				band = false;
				
				
				System.out.println("Peso (kg con ,): ");
				do{
					try {
						float peso = sc.nextFloat();
						jugador.setPeso(peso);
						band = true;
					}catch (Exception e) {
						System.out.println("formato invalido");
						System.out.println("Ingrese otra vez: ");
						sc.nextLine();
					}
				}while(band != true);
				band = false;
				
				System.out.println("Posicion (delantero, medio, defensa, arquero): ");
				
				do {
					String posicion = sc.next();
					if(posicion.equals("delantero") || posicion.equals("medio") || posicion.equals("defensa") || posicion.equals("arquero")){
						jugador.setPosicion(posicion);
						band = true;
					}
					else {
						System.out.println("posicion invalida");
						System.out.println("Ingrese otra vez:");
					}
				}while(band != true);
				
				
				Jugadores.add(Cant,jugador);
				Cant++;
				break;
			}
			case 2:{
				if (Cant != 0) {
				Boolean band = false;
				
				do {
					try {
						System.out.println("**Mostrar Datos**");
						System.out.println("Ingrese el nombre del jugador: ");
						String nombre = sc.next();
						System.out.println("Ingrese el apellido del jugador: ");
						String apellido = sc.next();
						
						for (int i = 0 ; i < Cant ; i ++) {
							if(	nombre.equals((Jugadores.get(i)).getNombre()) && apellido.equals((Jugadores.get(i)).getApellido()) ){
								Jugadores.get(i).MostrarDatos();
								band = true;
								break;
							}
						}
						if (band == false) {
							System.out.println("No se encontro el jugador con nombre " + nombre + " y apellido " + apellido);
						}
					}catch(Exception e) {
						System.out.println("nacionalidad invalida");
						System.out.println("Ingrese otra vez: ");
					}
				}while (band != true);
				}
				else {
		            System.out.println("no hay jugadores en el array");
		        }
				break;
			}
			case 3:{
				if(Cant != 0) {
				System.out.println("Jugadores ordenados por el apellido");
				
				Collections.sort(Jugadores, Comparator.comparing(Jugador::getApellido));
				for (Jugador persona : Jugadores) {
		            System.out.println(persona.getApellido());
		        }
				break;
				}
				else {
					System.out.println("no hay jugadores en el array");
		        }
				break;
			}
			case 4:{
				if(Cant != 0) {
				Boolean band = false;
				
				
						System.out.println("Modificar Datos");
						System.out.println("Ingrese el nombre del jugador: ");
						String nombre = sc.next();
						System.out.println("Ingrese el apellido del jugador: ");
						String apellido = sc.next();
						
						for (Jugador j : Jugadores) {
							if(nombre.equals(j.getNombre()) && apellido.equals(j.getApellido())){
								int op = 0;
								do {
									System.out.println("1-Nombre");
									System.out.println("2-Apellido");
									System.out.println("3-Fecha de nacimiento");
									System.out.println("4-Nacionalidad");
									System.out.println("5-Estatura");
									System.out.println("6-Peso");
									System.out.println("7-Posicion");
									System.out.println("8-Salir");
									op = sc.nextInt();
									switch (op) {
										case 1:{
											System.out.println("**Ingrese los datos del  jugador**");
											System.out.println("Nombre: ");
											String Nombre = sc.next();
											j.setNombre(Nombre);
											break;
										}
										case 2:{
											System.out.println("Apellido: ");
											String Apellido = sc.next();
											j.setApellido(Apellido);
											break;
										}
										case 3:{
											DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
											Boolean b = false;
											LocalDate FechaN = null;
											
											System.out.println("Fecha de Nacimiento (yyyy-MM-dd): ");
											do{
												String Fecha = sc.next();
												try {
													FechaN = LocalDate.parse(Fecha, formatter);
													j.setFechaNac(FechaN);
													b = true;
												}catch (Exception e) {
													System.out.println("Formato incorrecto. Asegúrate de que esté en el formato correcto (yyyy-MM-dd).");
													System.out.println("Ingrese otra vez la fecha: ");
												}
											}while(b != true);
											
											break;
										}
										case 4:{
											System.out.println("Nacionalidad: ");
											String Nacionalidad = sc.next();
											j.setNacionalidad(Nacionalidad);
											break;
										}
										case 5:{
											Boolean b = false;
											do{
												try {
													float estatura = sc.nextFloat();
													j.setEstatura(estatura);
													b = true;
												}catch (Exception e) {
													System.out.println("formato invalido");
													System.out.println("Ingrese otra vez: ");
													sc.nextLine();
												}
											}while(b != true);
											break;
										}
										case 6:{
											Boolean b = false;
											do{
												try {
													float peso = sc.nextFloat();
													j.setPeso(peso);
													b = true;
												}catch (Exception e) {
													System.out.println("formato invalido");
													System.out.println("Ingrese otra vez: ");
													sc.nextLine();
												}
											}while(b != true);
											break;
										}
										case 7:{
											Boolean b = false;
											
											System.out.println("Posicion (delantero, medio, defensa, arquero): ");
											
											do {
												String posicion = sc.next();
												if(posicion.equals("delantero") || posicion.equals("medio") || posicion.equals("defensa") || posicion.equals("arquero")){
													j.setPosicion(posicion);
													b = true;
												}
												else {
													System.out.println("posicion invalida");
													System.out.println("Ingrese otra vez:");
												}
											}while(b != true);
											break;
										}
										default :{
											System.out.println("opcion invalida");
											System.out.println("Ingrese otra vez: ");
											break;
										}
									
									}
								}while(op != 8);
								band = true;
								break;
							}
						}
						if (band == false) {
							System.out.println("No se encontro el jugador con nombre " + nombre + " y apellido " + apellido);
						}
				}
				else {
		            System.out.println("No hay jugadores en el array");
		        }
				break;
			}
			case 5:{
				if(Cant != 0) {
				Boolean band = false;
				
				do {
					try {
						System.out.println("**Eliminar Jugador**");
						System.out.println("Ingrese el nombre del jugador: ");
						String nombre = sc.next();
						System.out.println("Ingrese el apellido del jugador: ");
						String apellido = sc.next();
						
						for (Jugador j : Jugadores) {
							
							if(	nombre.equals(j.getNombre()) && apellido.equals(j.getApellido()) ){
								Jugadores.remove(j);
								band = true;
								Cant --;
								break;
							}
						}
						if(band == false) {
							System.out.println("No se encontro el jugador con nombre " + nombre + " y apellido " + apellido);
						}
					}catch(Exception e) {
						System.out.println("Igreso mal la nacionalidad");
						System.out.println("Ingrese otra vez: ");
					}
				}while(band != true);
				}
				else {
					System.out.println("No hay jugadores en el array");
				}
				break;
			}
			case 6:{
				System.out.println("La cantidad de jugadores es de " + Cant);
				break;
			}
			case 7:{
				int contador = 0;
				Boolean band = false;
				do {
					try {
						System.out.println("**Cantidad de jugadores por nacionalidad**");
						System.out.println("Ingrese la nacionalidad del jugador: ");
						String nacionalidad = sc.next();
						
						for (Jugador j : Jugadores) {
							
							if( nacionalidad.equals(j.getNacionalidad()) ){
								contador ++;		
							}
						}
						System.out.println("Hay " + contador + " jugadores con nacionalidad " + nacionalidad);
						band = true;
					}catch(Exception e) {
						System.out.println("Igreso mal la nacionalidad");
						System.out.println("Ingrese otra vez: ");
					}
				}while(band != true);
				break;
			}
			case 8:{
				System.out.println("Fin del programa");
				break;
			}

			default:{
				System.out.println("Opcion fuera del rango");
				break;
			}
			}
		}
		sc.close();

	}

}
