package LearnSocket.char02;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

public class TcpEchoServer {

    public static void main(String[] args) throws NumberFormatException, IOException, InterruptedException {
        @SuppressWarnings("resource")
        ServerSocket serverSocket = new ServerSocket(8034);

        while (true) {
            Socket socket = serverSocket.accept();
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();

            byte[] data = new byte[200];
            TimeUnit.SECONDS.sleep(10);

            int i = in.read(data);

            System.out.println(new String(data));

            out.write("hello".getBytes(StandardCharsets.UTF_8));

            socket.close();
        }
    }
}