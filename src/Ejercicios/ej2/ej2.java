

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
        File f = new File(args[0]);
        File f2 = new File(args[0] + ".tmp");
        int[] linesABorrar=new int[(args.length)-1];
        for(int i=0;i<linesABorrar.length;i++){
            linesABorrar[i]=Integer.parseInt(args[i+1]);
        }

        try {
            FileWriter fw=new FileWriter(args[0]+".tmp");
            BufferedReader br=null;

            for(int num:linesABorrar) {
                br=new BufferedReader(new FileReader(args[0]));
                index=1;
                System.out.println(num);
                while ((line = br.readLine()) != null) {
                    if(num!=index) {
                        fw.write(line+"\n");
                        System.out.println(line);
                    }
                    index++;
                }

            }

            f2.renameTo(f);
            fw.close();
            br.close();


        }
        catch(FileNotFoundException e){
            System.out.println("Directorio no encontrado.");
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }

    }


}
