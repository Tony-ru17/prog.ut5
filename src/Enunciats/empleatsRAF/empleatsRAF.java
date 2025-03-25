import java.util.Scanner;
import java.io.*;

public class empleatsRAF{
	static Scanner sc= new Scanner(System.in);
	public static void main(String[] args) {
		
		int eleccion=0;
		int dni=0;
		String nombre=null;
		double salario=0;
		pos=0;
		try(RandomAccessFile raf= new RandomAccessFile("empleados.dat","rw")){
			do{
				System.out.println("1. Alta d'un empleat");    
				System.out.println("2. Consulta d'un empleat (a partir del DNI)");
				System.out.println("3. Modificar salari d'un empleat (a partir del DNI)");
				System.out.println("4. Esborrar empleat (a partir del DNI)");
				System.out.println("5. Mostrar tots els empleats");
				System.out.println("0. Salir del programas");
		    	switch(eleccion){
		    		case 1:
		    			System.out.println("Dime el DNI:");
	    				dni=sc.nextInt();
	    				sc.nextLine();
    					pos=dni%1000*60;
		    			System.out.println("Dime el nombre:");
		    			nombre=	sc.nextLine();					
		    			System.out.println("Dime el salario:");
		    			salario=sc.nextDouble();
		    			ref.seek(pos*60);
		    			raf.writeInt(dni);
		    			raf.write
		    			    
		    			    
		    			    
	    				break;
					case 2:
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
			    
		}
		while(eleccion!=0);
	}
}	