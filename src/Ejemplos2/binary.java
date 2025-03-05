
/* Exemple de DataOutputStream
    Programa que pida números introducidos desde teclado por el usuario (hasta acabar en 0)
    y que lo escriba en un fichero binario

 */
import java.io.*;
import java.util.Scanner;
public class binary {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double num;

        //true en el segundo parámetro para no machacar el contenido del fichero si existiera
        try(FileOutputStream fos = new FileOutputStream("nums.dat",true);
            DataOutputStream dos = new DataOutputStream(fos);){

            System.out.println("Introduix un número:");
            num=sc.nextDouble();
            while(num!=0){
                dos.writeDouble(num);
                System.out.println("Introduix un número:");
                num=sc.nextDouble();
            }
        }
        catch(IOException e){
            System.err.println(e.getMessage());
        }
    }
}
