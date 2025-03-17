package Ejemplos2.exDeserialitza;

import java.io.*;

public class exDeserialitza {
    public static void main(String[] args) {
        try(FileInputStream fis = new FileInputStream("rectangles.dat");
            ObjectInputStream ois = new ObjectInputStream(fis)){
            rectangle r1,r2,r3;
            r1= (rectangle) ois.readObject();
            r2= (rectangle) ois.readObject();
            r3= (rectangle) ois.readObject();
            System.out.println(r1);
            System.out.println(r2);
            System.out.println(r3);

        }
        catch(IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
}
