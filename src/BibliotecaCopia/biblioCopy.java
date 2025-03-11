package BibliotecaCopia;
/*
    Programa que gestiones librerias(per a cada libro: codigo, título y precio)
*/

import java.util.Scanner;
import java.util.Vector;
import java.io.*;
public class biblioCopy {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int eleccion=0;
        int cod;
        Vector<Libro> libros=new Vector<Libro>(10,5);
        valoresVector(libros);
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
                darAlta(libros);
                break;
            case 2:
                System.out.println("Dime el libro a pasar:");
                buscarLibro=sc.nextInt();
                titol=mostrarLibro(buscarLibro);
                System.out.println(titol);
                break;
            case 3:
                System.out.println("Libros:\n");
                mostrarLibros(libros);
                break;
            case 4:
                System.out.println("Que código quieres eliminar?:");
                buscarLibro=sc.nextInt();
                borrarLibro(buscarLibro,libros);
                break;
            case 5:
                break;


            }  
        }        
        while(eleccion!=5);
                
        
        
    }
    public static void valoresVector(Vector<Libro> libros){

        try(DataInputStream dis= new DataInputStream(new FileInputStream("binaryBiblio"))){
            while(dis.available()>0)
                libros.add(new Libro(dis.readInt(),dis.readUTF(),dis.readDouble()));


        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    public static void darAlta(Vector<Libro> libros){
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
            libros.add(new Libro(cod,titulo,precio));

        }
        catch(IOException e){
            System.out.println(e.getMessage());
                
        }
    }

    public static String mostrarLibro(int cod){
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
    public static void mostrarLibros(Vector<Libro> libros){
        for(Libro l:libros)
            System.out.println("El libro nº"+l.getCodigo()+" tiene de título "+l.getNombre()+" y precio "+l.getPrecio()+"€");

    }
    public static void borrarLibro(int cod,Vector<Libro> libros){


        File f2= new File("temp");
        int comprobar;
        try(DataInputStream dis = new DataInputStream(new FileInputStream("binaryBiblio"));
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
        libros.removeIf(Libro -> Libro.getCodigo()==cod);
        f2.renameTo(new File("binaryBiblio"));
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


class Libro{
    int codigo;
    String nombre;
    double precio;
    public Libro(int cod, String nombre,double precio){
        codigo=cod;
        this.nombre=nombre;
        this.precio=precio;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

}


