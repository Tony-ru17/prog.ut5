package files;

import java.io.File;

public class exemple1 {
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";
    
    public static void main(String[] args) {

        File fichero;

        if(args.length==0){
            fichero=new File("./");
            mostrar(fichero,0);

        }
        else if(args.length==1){
            fichero=new File(args[0]);
            mostrar(fichero,-4);
        }

    }
    public static void mostrar(File files,int index){
        File[] arrayFiles=files.listFiles();
        index+=4;

        String tabu=" ";
        for(File fichero : arrayFiles){
            if(fichero.isDirectory()){
                System.out.println(tabu.repeat(index)+ANSI_YELLOW+fichero.getName()+ANSI_RESET);

                mostrar(fichero,index);
            }
            else 
                System.out.println(tabu.repeat(index)+fichero.getName());
        }
    }
}
