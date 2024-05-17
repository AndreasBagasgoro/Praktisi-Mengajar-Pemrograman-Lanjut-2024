
import java.io.*;

public class JavaIO {
    public static void main(String[] args) {
        try{
            File inputFile = new File("input.txt");
            System.out.println(inputFile.getCanonicalPath());
            
            FileReader reader = new FileReader(inputFile);
            BufferedReader buffer = new BufferedReader(reader);

            String output = buffer.readLine();
            while (output != null) {
                System.out.println(output);
                output = buffer.readLine();
            }

            buffer.close();
            reader.close();

        } catch(Exception e){
            System.out.println(e.toString());
        }
    }
}