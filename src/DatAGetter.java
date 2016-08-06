import java.io.*;
import java.net.URL;
import java.net.URLConnection;


public class DatAGetter {

    public static void main(String[] args) throws IOException {
        getResultAmount("https://github.com/91Seconds/WebPuller");
    }

    private static int getResultAmount(String url) throws IOException {

        URLConnection connection = new URL(url).openConnection();
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
        connection.connect();

        BufferedReader r = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        BufferedWriter writer = new BufferedWriter(new FileWriter("data.html"));
        String line;
        String src = "";
        while ((line = r.readLine()) != null) {
            src += line;
            //System.out.println(line);
            writer.write(line);
            writer.newLine();
        }
        System.out.println("\n\n" + src);
        return 1;
    }

}
