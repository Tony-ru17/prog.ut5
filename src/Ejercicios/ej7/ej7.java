
import java.io.*;

public class ej7 {
    public static void main(String[] args) {
        String line;

        try(BufferedReader br=new BufferedReader(new FileReader("prueba.txt"));
            BufferedWriter bw= new BufferedWriter(new FileWriter("prueba2.txt"));) {
            while((line=br.readLine())!=null){
                line=line.replaceAll("\\s+","");
                bw.write(line+"\n");
            }
        }
        catch(IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
