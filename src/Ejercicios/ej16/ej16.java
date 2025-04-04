

import java.util.Scanner;
import java.io.*;
/*16. Programa que afija línies de text codificades a un fitxer de text. El programa ha de
 permetre afegir una línia de text nova codificada o mostrar tot el contingut del fitxer (codificat o descodificat).
 Pots inventar-te l'algorisme o forma de codificació.*/
public class ej16 {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {

        int opcion=0;
        String linea=null;
        while (opcion != 5) {
            System.out.println("Que opción eliges?\n1. Añadir línea de texto.\n2.Mostrar línea de texto.\n3.Codificar línea de texto\n4.Decodificar línea de texto.\n5.Salir del programa.");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    linea=AnadeLinea();
                    break;
                case 2:
                    linea=LeerLinea();
                    System.out.println(linea);
                    break;
                case 3:
                    System.out.println(linea);
                    break;
                case 4:
                    System.out.println(DeCodifica(linea));
                    break;

                case 5:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("No has elegido ninguna de las opciones. \n\n");

            }

        }



    }
    public static String AnadeLinea(){
        try(FileWriter fw= new FileWriter("prueba.txt",true)){
            System.out.println("Que línea quieres añadir?");
            sc.nextLine();
            String linea=sc.nextLine();
            linea=Codifica(linea);
            fw.write(linea+"\n");
            return linea;
        }
        catch(IOException e){
            System.err.println(e.getMessage());
        }
        return null;

    }
    public static String LeerLinea(){
        try{
            BufferedReader br=new BufferedReader(new FileReader("prueba.txt"));
            int numLineas=0;
            int lineaAVer=0;
            String line="nada";
            while(br.readLine()!=null)
                numLineas++;
            br=new BufferedReader(new FileReader("prueba.txt"));
            System.out.println("Que línea quieres ver? Entre 1 y "+numLineas);
            lineaAVer=sc.nextInt();
            int index=1;
            while((line=br.readLine())!=null){
                if(index==lineaAVer)
                    return line;
                index++;
            }
        }
        catch (IOException e){
            e.getMessage();
            return "error";
        }
        return null;
    }
    public static String Codifica(String linea){
        char[] caracteres= linea.toCharArray();
        for(int i=0;i<linea.length();i++)
            caracteres[i]+=13;
        return new String(caracteres);

    }

    public static String DeCodifica(String linea){
        char[] caracteres= linea.toCharArray();
        for(int i=0;i<linea.length();i++)
            caracteres[i]-=13;
        return new String(caracteres);

    }
}
