import java.io.*;
import java.util.Scanner;

class numeroAleatorios{
	public static void main(String[] args) {
		int pos;
		double num;

		Scanner sc= new Scanner(System.in);
		System.out.println("Introduce un entero seguido de un valor a escribir (0 o negativo para acabar)");
		pos=sc.nextInt();
		num= sc.nextDouble();
		try (RandomAccessFile raf= new RandomAccessFile("nums.dat","rw")){

			while(pos>0){
				//nos posicionaremos, contanfo los bytes del principio del fichero
				raf.seek((pos-1)* Double.BYTES);
				raf.writeDouble(num);
				System.out.println("Introduce un entero seguido del valor a escribir (0 o negativa para acabar el programa)");
				pos=sc.nextInt();
				num=sc.nextDouble();
				    
			}
				    
		}
		catch(IOException e){
			System.err.println(e.getMessage());
		}
	}
}