import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://www.tab.co.nz/sport/#game/201343/1/hurricanes-v-lions");
        //socketShet();
        openconection(url);
    }

    private static void socketShet() throws IOException {
        Socket theSocket = new Socket("google.com",42423);
        Scanner sc = new Scanner(theSocket.getInputStream());
        while(true) {
            System.out.println(sc.next());
        }
    }

    private static void openconection(URL url) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        BufferedWriter writer = new BufferedWriter(new FileWriter("data.html"));
        String line;

        while ((line = reader.readLine()) != null) {
            System.out.println(line);
            writer.write(line);
            writer.newLine();
        }

        reader.close();
        writer.close();
    }
}