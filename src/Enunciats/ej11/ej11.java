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

        try(DataOutputStream dos= new DataOutputStream(new FileOutputStream("videoclub.dat",true))){
            int cod;
            String titulo;
            String director;
            System.out.println("Dime el código:");
            cod=sc.nextInt();
            sc.nextLine();
            System.out.println("Dime el título:");
            titulo=sc.nextLine();
            System.out.println("Dime el director:");
            director=sc.nextLine();
            dos.writeInt(cod);
            dos.writeUTF(titulo);
            dos.writeUTF(director);
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    public static int consulta(int cod){
        try(DataInputStream dis= new DataInputStream(new FileInputStream("videoclub.dat"))){
            int leerCod;
            String leertiutlo;
            String leerDirector;
            while(dis.available()>0) {
                leerCod = dis.readInt();
                leertiutlo=dis.readUTF();
                leerDirector=dis.readUTF();
                if (leerCod == cod)
                    return cod;
            }
            return -1;

        }
        catch(IOException e){
            System.out.println(e.getMessage());
            return -1;
        }

    }
}
