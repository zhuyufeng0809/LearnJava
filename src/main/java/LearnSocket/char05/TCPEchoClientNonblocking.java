package LearnSocket.char05;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author zhuyufeng
 * @version 1.0
 * @date 2021-03-03
 * @Description:
 */

public class TCPEchoClientNonblocking {

    public static void main(String[] args) throws IOException {
        String message = "nonBlock-test";
        byte[] data = message.getBytes();
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        String hostName = "127.0.0.1";
        int port = 13132;
        if (!socketChannel.connect(new InetSocketAddress(hostName, port))) {
            // 如果没有连上
            while (!socketChannel.finishConnect()) {
                // socketChannel 没有结束连接
                System.out.println("client do something else!");
            }
        }
        ByteBuffer writeBuffer = ByteBuffer.wrap(data);
        ByteBuffer readBuffer = ByteBuffer.allocate(data.length);
        int totalByteReceive = 0;
        int receive = 0;
        while (totalByteReceive < data.length) {
            if (writeBuffer.hasRemaining()) {
                socketChannel.write(writeBuffer);
            }
            if ((receive = socketChannel.read(readBuffer)) == -1) {
                throw new SocketException();
            }
            totalByteReceive += receive;
        }
        System.out.println("receive response:" + new String(readBuffer.array()));
        socketChannel.close();
    }
}