package LearnSocket.char02;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

public class TcpEchoClient {
    public static void main(String[] args) throws IOException, InterruptedException {
        //IP地址
        String server = "47.103.7.129";
        //传输数据
        byte[] data = "hello tcp socket".getBytes();
        //端口号
        int serverPort = 8034;
        @SuppressWarnings("resource")
        Socket socket = new Socket(server, serverPort);
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        out.write(data);

        byte[] result = new byte[5];

        //因为基于流，所以等待3秒，读取完整数据
        TimeUnit.SECONDS.sleep(3);

        int i = in.read(result);

        System.out.println("length:" + i);
        System.out.println("received:" + new String(result));
        //socket.close();
    }
}