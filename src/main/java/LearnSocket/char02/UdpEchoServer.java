package LearnSocket.char02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpEchoServer {

    public static void main(String[] args) throws IOException {
        int port = 8034;
        @SuppressWarnings("resource")
        DatagramSocket datagramSocket = new DatagramSocket(port);
        int maxLength = 255;
        DatagramPacket packet = new DatagramPacket(new byte[maxLength], maxLength);
        while (true) {
            datagramSocket.receive(packet);
            System.out.println(
                    "handle client at " + packet.getAddress().getHostAddress() + " on port " + packet.getPort());
            datagramSocket.send(packet);
            /*
            处理了接收到的消息后，数据包的内部长度将设置为刚处理过的消息的长度，
            而这可能比缓冲区的原始长度短。如果接收新消息前不对内部长度进行重置，
            后续的消息一旦长于之前消息，就会被截断（？没有复现出来）
             */
            System.out.println(packet.getLength());
            //packet.setLength(maxLength);
            System.out.println(new String(packet.getData()));
            System.out.println(packet.getData().length);
        }
    }
}