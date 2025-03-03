
import java.util.Scanner;
import java.io.*;
/*
5. Es necessita crear una classe censura amb un mètode aplicaCensura, a la qual se li passe com a paràmetre el nom d'un fitxer, i substituïsca cada aparició de "Linux" per "Unix" en aquest fitxer. No et preocupes pels canvis de línia si es perden. Recomanacions:

 - utilitza la classe Scanner, amb els seus mètodes next i hasNext.
 - crea un segon fitxer en el qual vages escrivint cada paraula, llegida del fitxer original, diferent de "Linux", i escrivint "Unix" quan la paraula llegida siga aquella. Al final, pots eliminar el fitxer original i canviar de nom el nou amb el de l'original.

 */

public class ej5 {
    public static void main(String[] args) {
        if(args.length==0) {
            System.out.println("El programa se debe ejecutar como java ej5 *archivo*");
            return;
        }
        Censura censurar= new Censura("Linux","Unix");
        censurar.aplicaCensura(args[0]);


    }

}
class Censura {
    private String palabraCensurada;
    private String palabraCambio;
    public Censura(String censurada,String cambio){
        palabraCensurada=censurada;
        palabraCambio=cambio;
    }
    public void aplicaCensura(String fichero){
        File f=new File(fichero);
        File f2=new File("archivoCensura.txt");
        String linea=null;
        String[] lineaSplit=null;
        try (Scanner sc=new Scanner (f);
             BufferedWriter bw=new BufferedWriter(new FileWriter(f2));
            )
        {
            while(sc.hasNextLine()){
                linea=sc.nextLine();
                lineaSplit=linea.split("\\s+");
                for (String palabra : lineaSplit) {
                    if (palabra.equalsIgnoreCase(palabraCensurada))
                        palabra = palabraCambio;
                    bw.write(palabra+" ");
                }
                bw.newLine();
            }


        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

}
