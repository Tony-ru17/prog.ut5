/*
    Programa que gestiones librerias(per a cada libro: codigo, título y precio)
*/

import java.util.Scanner;
import java.io.*;
public class biblio {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int eleccion=0;
        int cod=0;
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
                darAlta(cod);
                cod++;
                break;
            case 2:
                System.out.println("Dime el libro a pasar:");
                buscarLibro=sc.nextInt();
                titol=mostrarLibro(buscarLibro);
                System.out.println(titol);
                    
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;


            }  
        }        
        while(eleccion!=5);
                
        
        
    }
    static void darAlta(int cod){
        String titulo;
        double precio;
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
            while((comparar=dis.readInt())!=cod){
                if((comparar==cod){
                    return dis.readUTF();
                }
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
}
