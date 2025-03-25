//escibir y leer con Raf Double

import java.util.Scanner;
import java.io.*;

public class escribirRaf{
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		try(RandomAccessFile raf= new RandomAccessFile("nums.dat","rw")){
			int eleccion=0;
			int pos;
			int num;

			do{
				System.out.println("¿Qué quieres hacer?");
				System.out.println("0. Salir del programa.");
				System.out.println("1. Escribir.");
				System.out.println("2. Leer.");
			    System.out.println("\tEscriba su elección:");
		        eleccion=sc.nextInt();
		        if(eleccion<0)
		        	eleccion=0;
		        switch(eleccion){
	        		case 0: 
	        			System.out.println("Saliendo del programa...");
	        			break;
        			case 1:
        				System.out.println("¿Qué posición quieres elegir?");
    				    pos=sc.nextInt();
						raf.seek((pos-1)*Integer.BYTES);
						System.out.println("¿Qué número quieres escribir?");
						num=sc.nextInt();
						raf.writeInt(num);
						System.out.println("ESCRIBIDO!!!!!!!!!!!!");
						break;
				    case 2: 
				    	System.out.println("¿Que posición quieres leer?");
				    	pos=sc.nextInt();
				    	raf.seek((pos-1)*Integer.BYTES);
				    	System.out.println("El número de la posición "+pos+" es "+raf.readInt()+".");
				    	break;
			    	default:
		    			System.out.println("Número no permitido.");

		        }
			}
			while(eleccion>0);
		}		
		catch(IOException e){
			System.out.println("PUTILLA, ESTO NO VA");
			    
		}
	}
}