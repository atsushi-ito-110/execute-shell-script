import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main (String args[]) {
        try {
            Process process = new ProcessBuilder("ls", "-l").start();
            InputStreamReader isr = new InputStreamReader(process.getInputStream(), "UTF-8");
            BufferedReader reader = new BufferedReader(isr);
            StringBuilder builder = new StringBuilder();
            int c;
            while ((c = reader.read()) != -1) {
                builder.append((char)c);
            }
            System.out.println("result:\n" + builder.toString());
            System.out.println("Command return code: " + process.waitFor());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
