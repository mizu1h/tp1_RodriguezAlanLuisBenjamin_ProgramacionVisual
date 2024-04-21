package ar.edu.unju.fi.ejercicio18main;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import ar.edu.unju.fi.ejercicio18model.Pais;
import ar.edu.unju.fi.ejercicio18model.DestinoTuristico;
public class Main {

	public static void main(String[] args) {
		final int CantP = 6;
		Pais pais1 = new Pais("Ar-0000","Argentina");
		Pais pais2 = new Pais("Br-0001","Brazil");
		Pais pais3 = new Pais("UR-0002","Uruguay");
		ArrayList<Pais> ListaPaises = new ArrayList<>(List.of(pais1,pais2,pais3));
		
		ArrayList<DestinoTuristico> ListaDestino = new ArrayList<>();
		Scanner sc = new Scanner (System.in);
		int Opcion = 0, Cant = 0;
		
		do {
			System.out.println("***Menu***");
			System.out.println("1-Alta de destino turístico");
			System.out.println("2-Mostrar todos los destinos turísticos.");
			System.out.println("3-Modificar el país de un destino turístico.");
			System.out.println("4-Limpiar el ArrayList de destino turísticos");
			System.out.println("5-Eliminar un destino turístico");
			System.out.println("6-Mostrar los destinos turísticos ordenados por nombre");
			System.out.println("7-Mostrar todos los países");
			System.out.println("8-Mostrar los destinos turísticos que pertenecen a un país");
			System.out.println("9-Salir");
			System.out.println("Ingrese una opcion: ");
			Opcion = sc.nextInt();
			
			switch(Opcion){
			case 1:{
				DestinoTuristico Destino = new DestinoTuristico();
				Boolean band = false;
				
				do {
				try {
				System.out.println("**Ingrese los datos del destino**");
				System.out.println("Nombre: ");
				String Nombre = sc.next();
				Destino.setNombre(Nombre);
				band = true;
				} catch(Exception e) {
					System.out.println("Ingreso mal el nombre");
				}
				}while(band != true);
				band = false;
				
				do {
					try {
						System.out.println("Codigo: ");
						String codigo = sc.next();
						Destino.setCodigo(codigo);
						band = true;
					}catch (Exception e) {
						System.out.println("Ingreso mal el codigo");
					}
					
					}while(band != true);
				band = false;
				
				do {
					try {
						System.out.println("Precio: ");
						Double Precio = sc.nextDouble();
						Destino.setPrecio(Precio);
					band = true;
					} catch(Exception e) {
						System.out.println("Ingreso mal el precio");
					}
					}while(band != true);
				band = false;
				
				
				
				do {
					try {
						System.out.println("Elija un codigo del pais: ");
						System.out.println("1)Ar-0000 Argentina");
						System.out.println("2)Br-0001 Brazil");
						System.out.println("3)UR-0002 Uruguay");
						int op = sc.nextInt();
						switch(op) {
						case 1:{
							Destino.setPais(pais1);
							break;
						}
						case 2:{
							Destino.setPais(pais2);
							break;
						}
						case 3:{
							Destino.setPais(pais3);
							break;
						}			
						default:{
							System.out.println("Ingreso mal el codigo");
							break;
						}
					}	
						
					band = true;
					} catch(Exception e) {
						System.out.println("Ingreso mal el codigo");
					}
				}while (band != true);
				band = false;
				
				do {
					try {
						System.out.println("Cantidad de dias: ");
						int Dias = sc.nextInt();
						Destino.setCantDia(Dias);	
						band = true;
					} catch(Exception e) {
						System.out.println("Ingreso mal el dia");
					}
					}while(band != true);
				band = false;
				
				ListaDestino.add(Destino);
				Cant++;
				
				break;
			}
			case 2:{
				System.out.println("**Mostrar todos los destinos**");
				
				for(DestinoTuristico dt : ListaDestino) {
					dt.MostraDatos();
				}			
				break;
			}
			case 3:{
				Boolean band =false;
				do {
					try {
					System.out.println("**Modificar el pais de un destino turistico**");
					System.out.println("Ingrese el nombre del destino: ");
					String nombre = sc.next();
					for(DestinoTuristico dt1 : ListaDestino) {
							if(nombre.equals(dt1.getNombre())){
								
									System.out.println("Elija un codigo del pais: ");
									System.out.println("1)Ar-0000 Argentina");
									System.out.println("2)Br-0001 Brazil");
									System.out.println("3)Mx-0002 Uruguay");
									int op = sc.nextInt();
									switch(op) {
										case 1:{
											dt1.setPais(pais1);
											break;
										}
										case 2:{
											dt1.setPais(pais2);
											break;
										}
										case 3:{
											dt1.setPais(pais3);
											break;
										}										
										default:{
											System.out.println("Ingreso mal el codigo");
											break;
										}
									
									}
								band = true;
								break;
							}
							else {
								System.out.println("No se encuentra es destino");
							}
					}
					}catch(Exception e) {
						System.out.println("Ingreso mal el nombre");
					}
				}while(band != true);
				break;
				}
			case 4:{
				System.out.println("**Eliminar todos los destino turisticos**");
				ListaDestino.clear();
				Cant = 0;
				break;
			}
			case 5:{
				Boolean band = false;
				try {
					System.out.println("**Eliminar un destino turistico**");
					System.out.println("Codigo: ");
					String codigo = sc.next();
					for(DestinoTuristico dt : ListaDestino){
						if (codigo.equals(dt.getCodigo())){
							ListaDestino.remove(dt);
							Cant--;
							band = true;
							break;
						}
					}
					if(band == false) {
						System.out.println("No hay ningun destino con ese codigo");
					}
				}catch(Exception e) {
					System.out.println("Ingreso mal el codigo");
				}
				break;
			}
			case 6:{
				System.out.println("**Destino ordenados por nombre");
				
				Collections.sort(ListaDestino, Comparator.comparing(DestinoTuristico::getNombre));
				for (DestinoTuristico destino : ListaDestino) {
		            System.out.println(destino.getNombre());
		        }
				break;
			}
			case 7:{
				System.out.println("**Mostrar datos de todos los paises**");
				for(Pais p : ListaPaises){
					p.MostrarDatos();
				}
				break;
			}
			case 8:{
				Boolean band = false;
				do {
				
					System.out.println("**Mostrar destino que tengan el mismo pais**");
					System.out.println("");
					System.out.println("Elija un codigo del pais: ");
					System.out.println("1)Ar-0000 Argentina");
					System.out.println("2)Br-0001 Brazil");
					System.out.println("3)Ur-0002 Uruguay");
					int codigo = sc.nextInt();
					switch (codigo){
					case 1:{
						for(DestinoTuristico dt : ListaDestino) {
							if(dt.getPais().getCodigo().equals("Ar-0000")) {
								dt.MostraDatos();
							}
						}
						band = true;
						break;
					}
					case 2:{
						for(DestinoTuristico dt : ListaDestino) {
							if(dt.getPais().getCodigo().equals("Br-0001")) {
								dt.MostraDatos();
							}
						}
						band = true;
						break;
					}
					case 3:{
						for(DestinoTuristico dt : ListaDestino) {
							if(dt.getPais().getCodigo().equals("Ur-0002")) {
								dt.MostraDatos();
							}
						}
						band = true;
						break;
					}					
					default:{
						System.out.println("Ingreso mal el codigo");
						break;
					}
					}
					
				}while(band != true);
				
				if(band == false) {
					System.out.println("codigo invalido");
				}
				break;
			}
			case 9:{
				System.out.println("Fin del programa");
				break;
			}
			default:{
				System.out.println("fuera del rango");
				break;
			}
			}
		}while(Opcion != 9);
		
		sc.close();

	}

}
