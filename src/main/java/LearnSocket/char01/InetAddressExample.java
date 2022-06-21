package LearnSocket.char01;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class InetAddressExample {
    public static void main(String[] args) throws SocketException, UnknownHostException {
        /*
        NetworkInterface 用于表示一个网络接口，网络接口指的网络设备的各种接口，
        这可以是一个物理的网络接口，也可以是一个虚拟的网络接口
        而一个网络接口通常由一个 IP 地址来表示。既然 NetworkInterface 用来表示一个网络接口，
        那么如果可以获得当前机器所有的网络接口（包括物理的和虚拟的）
         */
        int interfacesNum = 0;
        int addressesNum = 0;
        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
        if (interfaces == null) {
            System.out.println("this is no interface");
        } else {
            while (interfaces.hasMoreElements()) {
                NetworkInterface networkInterface = interfaces.nextElement();

                Enumeration<InetAddress> addresses = networkInterface.getInetAddresses();
                interfacesNum += 1;
                System.out.println("第" + interfacesNum + "个网络接口" + networkInterface.getName());
                if (!addresses.hasMoreElements()) {
                    System.out.println("there has not address");
                }
                while (addresses.hasMoreElements()) {
                    addressesNum += 1;
                    InetAddress address = addresses.nextElement();
                    System.out.println(
                            addressesNum + ":" +"IP" + (address instanceof Inet4Address ? "v4" : "v6") + "地址：" +
                                    address.getHostAddress());
                }
            }
        }

        System.out.println("\n\n");

        for (String host : args) {
            System.out.println(host+":");
            InetAddress[] inets=InetAddress.getAllByName(host);
            for(InetAddress inet:inets){
                System.out.println("域名：" + inet.getHostName()+":");
                System.out.println("IP：" + inet.getHostAddress());
                System.out.println("toString:"+inet.toString());
            }
            System.out.println("\n");
        }
    }
}