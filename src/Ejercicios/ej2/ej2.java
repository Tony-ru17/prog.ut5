

import java.io.*;
import java.util.Scanner;

public class ej2 {

    //2. Programa que s'execute d'igual forma que l'anterior, amb un únic número de línia, i esborre eixa línia del fitxer.
    public static void main(String[] args) {
        String line=null;
        int index=0;


        //Si no se han pasado argumentos, se piden en el programa
        if(args.length<=1){
            Scanner sc=new Scanner(System.in);
            System.out.println("Dime el fichero y las líneas a leer: ./ruta/fichero/ l1 l2 l3");
            String leer=sc.nextLine();
            args=leer.split(" ");
        }
        int[] linesABorrar=new int[(args.length)-1];
        for(int i=0;i<linesABorrar.length;i++){
            linesABorrar[i]=Integer.parseInt(args[i+1]);
        }

        try {

            BufferedReader br;
            FileWriter fw=new FileWriter(args[0]+".new");
            for(int num:linesABorrar) {
                index=1;
                br=new BufferedReader(new FileReader(args[0]));
                while ((line = br.readLine()) != null) {
                    if(num!=index) {
                        fw.write(line);
                        System.out.println(line);
                    }
                    index++;
                }

            }
            File f = new File(args[0]);
            File f2 = new File(args[0] + ".new");
            f2.renameTo(f);



        }
        catch(FileNotFoundException e){
            System.out.println("Directorio no encontrado.");
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }

    }


}
