package Biblioteca;
/*
    Programa que gestiones librerias(per a cada libro: codigo, título y precio)
*/

import javax.xml.crypto.Data;
import java.util.Scanner;
import java.io.*;
public class biblio {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int eleccion=0;
        int cod;

        int buscarLibro=0;
        String titol;
        double preu;
        do{

            System.out.println("1. Alta de libro.");
            System.out.println("2. Mostrar libro a partir de su código.");
            System.out.println("3. Mostrar todos los libros.");
            System.out.println("4. Dar de baja un libro.");
            System.out.println("5. Acabé");
            System.out.println("\tElige una opción");
            eleccion=sc.nextInt();
            sc.nextLine();
            switch(eleccion){
                
            case 1:
                darAlta();
                break;
            case 2:
                System.out.println("Dime el libro a pasar:");
                buscarLibro=sc.nextInt();
                titol=mostrarLibro(buscarLibro);
                System.out.println(titol);
                break;
            case 3:
                System.out.println("Libros:\n");
                mostrarLibros();
                break;
            case 4:
                System.out.println("Que código quieres eliminar?:");
                buscarLibro=sc.nextInt();
                borrarLibro(buscarLibro);
                break;
            case 5:
                break;


            }  
        }        
        while(eleccion!=5);
                
        
        
    }
    static void darAlta(){
        String titulo;
        double precio;
        int cod=obtenerCod();
        try(DataOutputStream dos =new DataOutputStream(new FileOutputStream("binaryBiblio",true))){
            dos.writeInt(cod);
            System.out.println("Dime el nombre del libro.");
            titulo=sc.nextLine();
            dos.writeUTF(titulo);
            System.out.println("Dime el precio.");
            precio=sc.nextDouble();
            dos.writeDouble(precio);

        }
        catch(IOException e){
            System.out.println(e.getMessage());
                
        }
    }

    static String mostrarLibro(int cod){
        int comparar;
        try (DataInputStream dis= new DataInputStream(new FileInputStream("binaryBiblio"))){
            while(dis.available()>0){
                comparar=dis.readInt();
                if(comparar==cod)
                    return dis.readUTF();

                else{
                    dis.readUTF();
                    dis.readDouble();
                }
            }
        }
        catch(IOException e){
            System.out.println(e.getMessage());
                
        }
        return "No se ha encontrado el libro.";
    }
    static void mostrarLibros(){
        try (DataInputStream dis= new DataInputStream( new FileInputStream("binaryBiblio"))) {
            while(dis.available()>0)
                System.out.println("El libro nº"+dis.readInt()+" tiene de nombre "+dis.readUTF()+" y vale "+dis.readDouble()+"€");
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
        System.out.println("\n ");

    }
    public static void borrarLibro(int cod){

        File f1 = new File("binaryBiblio");
        File f2= new File("temp");
        int comprobar;
        try(DataInputStream dis = new DataInputStream(new FileInputStream(f1));
            DataOutputStream dos= new DataOutputStream(new FileOutputStream(f2))){
            while(dis.available()>0){
                comprobar=dis.readInt();
                if(comprobar!=cod){
                    dos.writeInt(comprobar);
                    dos.writeUTF(dis.readUTF());
                    dos.writeDouble(dis.readDouble());
                }
                else{
                    dis.readUTF();
                    dis.readDouble();
                }
            }


        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
        f2.renameTo(f1);
        System.out.println("Elemento "+cod+" eliminado.");
    }
    public static int obtenerCod(){
        int cod=0;
        int temp=0;
        try(DataInputStream dis= new DataInputStream(new FileInputStream("binaryBiblio"))){
            while(dis.available()>0) {
                temp=dis.readInt();
                dis.readUTF();
                dis.readDouble();
                cod=temp+1;
            }
        }
        catch (IOException e){
            System.out.println("Codigo: "+cod);
            return cod;
        }
        System.out.println("Codigo: "+cod);
        return cod;

    }
}


