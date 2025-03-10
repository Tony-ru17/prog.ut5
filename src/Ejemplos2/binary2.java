package Ejemplos2;/* Exemplde de DataInputStream
    programa que muestra el contenido de un fichiero
 */

import java.io.*;
public class binary2 {
    public static void main(String[] args) {
        double num;
        File f= new File("nums.dat");
        if(f.exists() && f.canRead()){
            try(DataInputStream dis= new DataInputStream(new FileInputStream(f))){
                num=dis.readDouble();
                while(true){
                    System.out.println(num);
                    num=dis.readDouble();
                }

            }
            catch(EOFException e){
                //System.err.println(e.getMessage());
            }
            catch(IOException e){
                System.err.println(e.getMessage());
            }
            /* finally
            {
                System.out.println("Continuació del programa");


            }*/
        }
        else
            System.out.println("No existeix el fitxer nums.dat o no tens permís de lectura");
    }

}
