
import java.io.*;
public class ej3 {
    public static void main(String[] args) {
        File f1=new File(args[0]);
        File f2=new File(args[0]+".tmp");
        String line=null;
        try {
            BufferedReader br = new BufferedReader(new FileReader(args[0]));
            BufferedWriter bw = new BufferedWriter(new FileWriter(args[0]+".tmp"));
            while((line=br.readLine())!=null)
                bw.write(line+"\n");
            bw.write(args[1]);
            bw.close();
            f2.renameTo(f1);
        }

        catch (IOException e) {
            System.err.println(e.getMessage());
        }


    }
}
