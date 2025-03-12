package Enunciats.ej10;
import java.util.Scanner;
import java.io.*;

public class ej10 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int num=0;
        int divisor=0;
        int suma=0;
        double resulatado=0;


        try(DataOutputStream dos= new DataOutputStream(new FileOutputStream("numeros"));
            DataInputStream dis= new DataInputStream(new FileInputStream("numeros"))){
            System.out.println("Dime el número entero a añadir");
            num=sc.nextInt();
            do{

                dos.writeInt(num);
                System.out.println("Dime el número entero a añadir.(Acaba en 0)");
                num=sc.nextInt();
            }
            while(num!=0);
            while(dis.available()>0) {
                num=dis.readInt();
                System.out.println(num);
                suma+=num;
                divisor++;
            }
            System.out.println("La media aritmética es: "+(double)suma/(double) divisor);



        }
        catch(IOException e){
            System.err.println(e.getMessage());
        }
    }

}
