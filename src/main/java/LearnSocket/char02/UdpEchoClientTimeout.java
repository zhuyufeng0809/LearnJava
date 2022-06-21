package LearnSocket.char02;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

public class UdpEchoClientTimeout {

    public static void main(String[] args) throws IOException {

        InetAddress address = InetAddress.getByName("47.103.7.129");

        System.out.println(address);

        byte[] data = "hello udp socket".getBytes(StandardCharsets.UTF_8);
        int port = 8034;
        DatagramPacket sendPacket = new DatagramPacket(data, data.length, address, port);
        DatagramSocket datagramSocket = new DatagramSocket();
        int timeOut = 3000;//阻塞时间3秒
        datagramSocket.setSoTimeout(timeOut);
        DatagramPacket recivePacket = new DatagramPacket(new byte[data.length], data.length);
        int tries = 0;
        boolean receivedResponse = false;
        int times = 5;
        do {
            datagramSocket.send(sendPacket);
            try {
                datagramSocket.receive(recivePacket);
                 /*
                 超时会抛出InterruptedIOException
                 */
                //检测收到的Packet是否来自于目标地址
                if (!recivePacket.getAddress().equals(address)) {
                    System.out.println("recive message from a unknow host!");
                }
                receivedResponse = true;
            } catch (InterruptedIOException e) {
                tries++;
                System.out.println("retry " + tries + " time");
            }
        } while (tries < times && !receivedResponse);

        if (receivedResponse) {
            System.out.println("Received:" + new String(recivePacket.getData()));
        } else {
            System.out.println("No response -- give up!");
        }
        datagramSocket.close();

    }
}