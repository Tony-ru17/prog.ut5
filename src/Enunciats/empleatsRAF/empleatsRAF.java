import java.util.Scanner;
import java.io.*;

public class empleatsRAF{
	static Scanner sc= new Scanner(System.in);
	public static void main(String[] args) {
		final int TAM=60;
		int eleccion=0;
		int dni=0;
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
    					raf.seek(pos*60);
    					if(raf.readInt()==0){
			    			System.out.println("Dime el nombre:");
			    			nombre=	sc.nextLine();				
			    			if(nombre.length()>47)	
			    				nombre=nombre.substring(0,47);
			    			System.out.println("Dime el salario:");
			    			salario=sc.nextDouble();
			    			raf.seek(pos*60);
			    			raf.writeInt(dni);
			    			raf.writeBytes(nombre);
			    			raf.writeDouble(salario);
		    			}
		    			else
		    				System.out.println("Posición ya ocupada.");
		    				    
	    				break;
					case 2:
						System.out.println("----------CONSULTA EMPLEADO----------");
						System.out.println("Dime el DNI a buscar:");
						dni=sc.nextInt();
						pos=dni%1000;
						System.out.println(pos);
						    
						raf.seek(pos*60);
						System.out.println("DNI: "+raf.readInt());
						System.out.println("\nNombre:"+raf.readLine()+"\nSalario:"+raf.readDouble());
						    

						    
						break;
					case 3:
						break;
					case 4:
						break;
					case 5:
						break;
		    		default:
		    			break;
	    		}
    		}
			while(eleccion!=0);	    
		}
		catch(FileNotFoundException e){
			System.out.println("no va");
			    
		}
		catch(IOException e){
			System.out.println("error");
			    
		}

	}
}	