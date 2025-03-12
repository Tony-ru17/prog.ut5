package Enunciats.ej11;
import java.io.*;
import java.util.Scanner;
public class ej11 {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        int eleccion;
        do {

            System.out.println("1. Alta de pel·lícula");
            System.out.println("2. Consulta d'una pel·lícula a partir del seu codi");
            System.out.println("3. Llistar totes les pel·lícules");
            System.out.println("4. Esborrar una pel·lícula a partir del seu codi");
            System.out.println("0. Eixir del programa");
            System.out.println("\nQue quieres hacer:");
            eleccion=sc.nextInt();

        }
        while(eleccion!=0);
    }
    public static void alta(){

        try(DataOutputStream dos= new DataOutputStream(new FileOutputStream("videoclub",true))){
            System.out.println("Dime el código:");
            dos.writeInt();
            System.out.println("Dime el título:");
            System.out.println("Dime el director:");
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
