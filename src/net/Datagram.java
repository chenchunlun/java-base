package net;

import java.io.IOException;
import java.net.*;

/**
 * Created by Administrator on 2016-5-23.
 */
public class Datagram {
    public static void test(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    DatagramSocket server = new DatagramSocket(8080);
                    byte[] bytes = new byte[1024];
                    DatagramPacket datagramPacket = new DatagramPacket(bytes,0,bytes.length);
                    server.receive(datagramPacket);
                    System.out.println(new String(datagramPacket.getData()));
                    server.close();
                } catch (SocketException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    DatagramSocket client = new DatagramSocket(8088);
                    byte[] bytes = "测试数据包".getBytes();
                    DatagramPacket datagramPacket = new DatagramPacket(bytes,0,bytes.length,InetAddress.getByName("localhost"),8080);
                    client.send(datagramPacket);
                    client.close();
                } catch (SocketException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


}
