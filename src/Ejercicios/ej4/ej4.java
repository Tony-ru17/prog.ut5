

import java.io.*;

public class ej4{
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(args[0]));
            int lineas=0;
            int caracteres=0;
            while(br.read()!=-1)
                caracteres++;
            br=new BufferedReader(new FileReader(args[0]));
            while(br.readLine()!=null)

                lineas++;
            System.out.println("Existen "+lineas+" lineas y "+caracteres+" caracteres.");

        }
        catch(IOException e){
            System.err.println(e.getMessage());
        }
    }

}

