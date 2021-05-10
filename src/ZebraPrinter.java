import java.io.*;
import java.net.Socket;
public class ZebraPrinter {
    public static void main(String[] args) throws IOException {
        String host = "127.0.0.1";
        Socket socket = new Socket(host, 9100);
        File file = new File("/Users/XXX/Documents/printnew.txt");
        long length = file.length();
        byte[] bytes = new byte[16 * 1024];
        InputStream in = new FileInputStream(file);
        OutputStream out = socket.getOutputStream();
        int count;
        while ((count = in.read(bytes)) > 0) {
            out.write(bytes, 0, count);
        }
        out.close();
        in.close();
        socket.close();
    }
}
