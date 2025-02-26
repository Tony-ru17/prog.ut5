
/*1. Programa que mostre unes determinades línies d'un fitxer de text. Tant el fitxer com els números de línia (en ordre creixent) seran passats com a paràmetres en l'execució. Exemple:

	java ex1 /ruta/Al/Fitxer 3 7 10
 */
import java.io.*;
import java.util.Scanner;
public class ej1 {
    public static void main(String[] args) {
        String line=null;
        int index=0;
        int numLinea;

        //Si no se han pasado argumentos, se piden en el programa
        if(args.length<=0){
            Scanner sc=new Scanner(System.in);
            System.out.println("Dime el fichero y las líneas a leer: ./ruta/fichero/ l1 l2 l3");
            String leer=sc.nextLine();
            args=leer.split(" ");
        }

        try {

            BufferedReader br;
            for (int i=1;i<(args.length);i++){
                br=new BufferedReader(new FileReader(args[0]));
                numLinea=Integer.parseInt(args[i]);
                index=1;
                try {
                    while ((line = br.readLine()) != null){
                        if(index==numLinea)
                            System.out.println(line);

                        index++;

                    }
                }
                catch(IOException e){
                    System.out.println(e.getMessage());
                }
            }
        }
        catch(FileNotFoundException e){
            System.out.println("Directorio no encontrado.");
        }
    }
}
