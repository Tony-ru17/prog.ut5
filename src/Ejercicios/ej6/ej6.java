
import java.util.Scanner;
import java.io.*;
public class ej6 {
    public static void main(String[] args) {

        int numPalabras=0;
        try(FileReader f=new FileReader("prueba.txt");
            Scanner sc=new Scanner(f);) {
            while(sc.hasNext()){
                sc.next();
                numPalabras++;
            }
            System.out.println("El texto tiene "+numPalabras+" palabras.");
        }
        catch (IOException e){
            System.err.println(e.getMessage());
        }

    }
}
