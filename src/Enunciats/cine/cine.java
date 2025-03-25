import java.io.*;
import java.util.Scanner;

public class cine{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try(RandomAccessFile raf= new RandomAccessFile("nums.dat","rw")){
			final int maxString=50;
			int eleccion=0;
			do{
				System.out.println("¿Qué quieres hacer?");
				System.out.println("0. Salir del programa.");
				System.out.println("1. Escribir película.");
				System.out.println("2. Leer película.");
			    System.out.println("\tEscriba su elección:");
				eleccion= sc.nextInt();
				switch(eleccion){
					case 0:
						System.out.println("Saliendo del programa...");
					    break;
				    case 1:

				    	break;
				    case 2:
				    	break;
			    	default:
				}

			}
			
			    

		}
		catch(IOException e){
			System.out.println("MAL");
			    
		}
	}
}