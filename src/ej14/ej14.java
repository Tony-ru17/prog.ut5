/*14. Programa que permeta generar un sorteig de Loteria primitiva (6 números entre 1 i 49, sense repeticions) i registre en un fitxer binari
 49 comptadors que comptabilitzen quantes vegades ha eixit cada número. Per a cada sorteig el programa haurà d'incrementar en una unitat 6 dels
 comptadors. El programa ha d'oferir un menú per a triar entre 2 opcions: a) generar un sorteig, b) mostrar comptadors de tots els números.*/
import java.util.Random;
import java.util.Scanner;
import java.io.*;
public class ej14{
	static Random numRandom= new Random();
	static Scanner sc= new Scanner(System.in);
	public static void main(String[] args) {
		
		int eleccion=0;
		int[] loteria= new int[6];
		
		try(DataOutputStream dos = new DataOutputStream(new FileOutputStream("contadorNumeros.dat"))){
			for(int i=0;i<=49;i++){
				dos.writeInt(i);
				dos.writeInt(0);
			}
			do{
		    System.out.println("\n¿Que quieres hacer?\n0.Salir del programa\n1.Tirar la lotería\n2.Ver cuantas veces se han repetido los números\n3.Ver las repeticiones de un número concreto.");
		    eleccion=sc.nextInt();
			switch(eleccion){
				case 0:
					System.out.println("Saliendo del programa.");
					break;
				case 1:
					loteria=new int[6];;
					System.out.println("Tirando la lotería...");
					for(int i=0;i<loteria.length;i++)
						loteria[i]=obtenerNoRepetido(loteria, i);
					System.out.println(loteria[5]);
					    
					System.out.print("\nTú número ha sido:");
					for(int num:loteria)
						System.out.print(" " +num);
					escribirNumeros(loteria);
					break;
				case 2:
					leerNumeros();
					break;
				case 3:
					break;
				case 4:
					break;
			}
			}
			while(eleccion!=0);
		}
		catch(IOException e){
			System.out.println(e.getMessage());	    
		}
	}
	
	public static void leerNumeros(){
		try(DataInputStream dis= new DataInputStream(new FileInputStream("contadorNumeros.dat"))){
			//Acabará cuando sale la excepción
			while(true){
				System.out.println(dis.readInt()+":"+dis.readInt());
				    
			}
		}
		catch(IOException e){
			System.out.println("Final.");
			    
		}
	}
	public static void escribirNumeros(int[] loteria){
		
		    
		    
		int aux=0;
		int escribir=0;
		int posicion=0;
		int suma=0;
		    
		File f1=new File("contadorNumeros.dat");
		File f2=new File("auxiliar.dat");
		boolean escrito=false;
		try(DataInputStream dis= new DataInputStream(new FileInputStream(f1));
			DataOutputStream dos = new DataOutputStream(new FileOutputStream(f2))){
			
			posicion=dis.readInt();
			suma=dis.readInt();
			for(int i:loteria){
				if(i==posicion)
					suma++;
			}
			dos.writeInt(posicion);
			dos.writeInt(suma);
		}
		catch(IOException e){
			System.out.println(e.getMessage());
		}
		f2.renameTo(f1);

	}
		
	
	public static int obtenerNoRepetido(int[] loteria,int maxPos){
		boolean repetido=false;
		int num=0;
		do{
			repetido=false;
			num=numRandom.nextInt(50);
			for(int i=0;i<maxPos;i++){
				if(loteria[i]==num){
					repetido=true;
					
				}

			}
		}
		while(repetido);
		return num;
	}
}