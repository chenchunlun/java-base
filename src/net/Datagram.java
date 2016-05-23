package net;

import java.io.*;
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
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(datagramPacket.getData());
                    DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
                    System.out.println(dataInputStream.readDouble());
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
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(baos));
                    dos.writeDouble(12.34);
                    dos.flush();
                    byte[] bytes = baos.toByteArray();
                    baos.close();
                    dos.close();
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
