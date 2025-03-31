package Enunciats.empleatsRAF;
import java.util.Scanner;
import java.io.*;

public class empleatsRAF{
	static Scanner sc= new Scanner(System.in);
	public static void main(String[] args) {
		final int TAM=60;
		int eleccion=0;
		int dni=0,aux=0,error=0;

		String nombre=null;
		double salario=0;
		int pos=0;

		try(RandomAccessFile raf= new RandomAccessFile("empleats.dat","rw")){
			do{

				System.out.println("1. Alta d'un empleat");
				System.out.println("2. Consulta d'un empleat (a partir del DNI)");
				System.out.println("3. Modificar salari d'un empleat (a partir del DNI)");
				System.out.println("4. Esborrar empleat (a partir del DNI)");
				System.out.println("5. Mostrar tots els empleats");
				System.out.println("0. Salir del programas");
				eleccion=sc.nextInt();
		    	switch(eleccion){
		    		case 1:
		    			System.out.println("-----------DAR DE ALTA----------");
		    			System.out.println("Dime el DNI:");
	    				dni=sc.nextInt();
	    				sc.nextLine();
    					pos=dni%1000;
    					raf.seek(pos*TAM);
    					if(raf.readInt()==0){
			    			System.out.println("Dime el nombre:");
			    			nombre=	sc.nextLine();
			    			if(nombre.length()>46)
			    				nombre=nombre.substring(0,46);
			    			System.out.println("Dime el salario:");
			    			salario=sc.nextDouble();
			    			raf.seek(pos*TAM);
			    			raf.writeInt(dni);
			    			raf.writeBytes(nombre+"\n");
			    			raf.writeDouble(salario);
		    			}
		    			else
		    				System.out.println("Posición ya ocupada.");

	    				break;
					case 2:
						System.out.println("----------CONSULTA EMPLEADO----------");
						System.out.println("Dime el DNI a buscar:");
						dni=sc.nextInt();
						error=consultarDNI(dni);
						if(error==-1)
							System.out.println("No hay ningún empleado en esta posición.");
						else if(error==0)
							System.out.println("DNI mal escrito");
						else {
							pos=dni%1000;
							raf.seek(pos*TAM);
							System.out.println("DNI: " + raf.readInt() + "\nNombre:" + raf.readLine() + "\nSalario:" + raf.readDouble());
						}
						break;
					case 3:
						System.out.println("----------CAMBIAR SALARIO----------");
						System.out.println("Dime el DNI del empleado:");
						dni=sc.nextInt();
						error=consultarDNI(dni);

						if(error==-1)
							System.out.println("En esta posición no hay ningún DNI.");
						else if(error==0)
							System.out.println("DNI mal escrito.");
						else {
							pos=dni%1000;
							raf.seek(pos*TAM);
							raf.readLine();
							System.out.println("Dime el nuevo salario:");
							salario = sc.nextDouble();
							raf.writeDouble(salario);
						}
						break;
					case 4:
						System.out.println("----------BORRAR EMPLEADO----------");
						System.out.println("Dime el DNI a buscar:");
						dni=sc.nextInt();
						error=consultarDNI(dni);
						if(error==-1)
							System.out.println("En esta posición no hay ningún DNI.");
						else if(error==0)
							System.out.println("DNI mal escrito.");
						else {
							pos=dni%1000;
							raf.seek(pos*TAM);
							raf.writeInt(0);
							raf.writeBytes(" ");
							raf.writeDouble(0);
						}

						break;
					case 5:
						break;
		    		default:
		    			break;
	    		}
    		}
			while(eleccion!=0);
		}
		catch (SecurityException e){
			System.out.println("securityException");
		}
		catch(IllegalArgumentException e){
			System.out.println("IllegalArgumentException");
		}
		catch(FileNotFoundException e){
			System.out.println("no va");

		}
		catch(IOException e){
			System.out.println("error");

		}


	}
	public static int consultarDNI(int dni) {
		try (RandomAccessFile raf = new RandomAccessFile("empleats.dat", "r")) {
			final int TAM = 60;
			int pos = dni % 1000;
			raf.seek(pos * TAM);
			int aux = raf.readInt();
			System.out.println(aux);
			if (aux == 0)
				//Con -1 devolvemos que en la posición no existen valores
				return -1;
			if (aux != dni)
				//Con 0 devolveríamos que el DNI a buscar no es exactamente el mismo que el del fichero
				return 0;
			else
				//con esto devolvemos que todo está correcto
				return 1;
		} catch (IOException e) {
			e.getMessage();
			return 0;
		}

	}
}