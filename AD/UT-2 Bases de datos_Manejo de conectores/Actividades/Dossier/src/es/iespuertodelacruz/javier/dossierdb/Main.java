package es.iespuertodelacruz.javier.dossierdb;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import es.iespuertodelacruz.javier.dossierdb.utils.GestorBaseDatos;
import es.iespuertodelacruz.javier.dossierdb.utils.models.GestorLapices;
import es.iespuertodelacruz.javier.dossierdb.utils.models.Lapiz;

public class Main {

	public static void main(String[] args) throws SQLException {

		Scanner sc = new Scanner(System.in);
		GestorBaseDatos gbd = new GestorBaseDatos("oficina", "root", null);
		GestorLapices gl = new GestorLapices(gbd);
		
		boolean finalizar = false;
		
		do {
			int opt = menu(sc);
			
			switch (opt) {
			case 0:
				finalizar = true;
				break;
				
			case 1:
				ArrayList<Lapiz> lapices = (ArrayList<Lapiz>) gl.getAll();
				System.out.println("\nMostrando todos los lapices");
				lapices.forEach(System.out::println);
				break;
				
			case 2:
				System.out.print("\nIntroduce el id del lapiz: ");
				try {
					int id = Integer.parseInt(sc.nextLine());
					Lapiz lapizId = gl.getById(id);
					if (lapizId != null) {
						System.out.println(lapizId);
					} else {
						System.out.println("No existe un lapiz con este id");
					}
				} catch (Exception e) {
					System.err.println("\nSolo puedes insertar valores numericos\n");
				}
				break;
				
			case 3:
				System.out.print("\nPor que marca quieres buscar: ");
				String marca = sc.nextLine();
				lapices = (ArrayList<Lapiz>) gl.getByMarca(marca);
				System.out.println("Mostrando todos los lapices con marca " + marca);
				lapices.forEach(System.out::println);
				break;
				
			case 4:
				System.out.print("\nIntroduce el numero de los lapices: ");
				try {
					int numero = Integer.parseInt(sc.nextLine());
					lapices = (ArrayList<Lapiz>) gl.getByNumero(numero);
					System.out.println("Mostrando todos los lapices con marca " + numero);
					lapices.forEach(System.out::println);
				} catch (Exception e) {
					System.err.println("\nSolo puedes insertar valores numericos\n");
				}
				break;
				
			case 5:
				try {
					System.out.print("\nIntroduce la marca: ");
					marca = sc.nextLine();
					System.out.print("Introduce el numero: ");
					int numero = Integer.parseInt(sc.nextLine());
					Lapiz lapizCreado = gl.save(new Lapiz(marca, numero));
					
					if (lapizCreado != null) {
						System.out.println(lapizCreado);
					} else {
						System.out.println("No hemos podido guardar un nuevo Lapiz");
					}
				} catch (Exception e) {
					System.err.println("\nError al introducir caracteres en los valores numericos\n");
				}
				
				break;
				
			case 6:
				try {
					System.out.print("\nQue Lapiz quieres modificar (ID): ");
					int id = Integer.parseInt(sc.nextLine());
					System.out.print("Introduce la nueva marca: ");
					marca = sc.nextLine();
					System.out.print("Introduce el nuevo numero: ");
					int numero = Integer.parseInt(sc.nextLine());
					gl.actualizar(new Lapiz(id, marca, numero));
				} catch (Exception e) {
					System.err.println("\nError al introducir caracteres en los valores numericos\n");
				}
				break;
				
			case 7:
				try {
					System.out.print("\nQue Lapiz quieres eliminar (ID): ");
					int id = Integer.parseInt(sc.nextLine());
					gl.borrar(id);
				} catch (Exception e) {
					System.err.println("\nError al introducir caracteres en los valores numericos\n");
				}
				break;

			default:
				System.out.println("Este valor no equivale a una posicion de menu");
				break;
			}
		} while (!finalizar);		
		
	}
	
	private static int menu(Scanner sc) {
		String menu = "\nAcciones sobre la DDBB"
				+ "\n\t1) Obtener todos los lapices"
				+ "\n\t2) Obtener lapiz por id"
				+ "\n\t3) Obtener todos los lapices filtrado por marca"
				+ "\n\t4) Obtener todos los lapices filtrado por numero"
				+ "\n\t5) Guardar un nuevo Lapiz"
				+ "\n\t6) Actualizar un lapiz"
				+ "\n\t7) Eliminar un lapiz"
				+ "\n\t0) Salir"
				+ "\n-> ";
		
		System.out.print(menu);
		int opt = -1;
		try {
			opt = Integer.parseInt(sc.nextLine());
		} catch (Exception e) {
			System.err.println("\nSolo puedes insertar valores numericos\n");
		} finally {
			return opt;
		}
	}

}
