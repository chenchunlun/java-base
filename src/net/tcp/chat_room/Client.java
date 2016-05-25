package net.tcp.chat_room;

import java.io.*;
import java.net.Socket;

/**
 * Created by hp on 2016/5/25 0025.
 */
public class Client {
    public static void test(){
        try {
            Socket socket = new Socket("127.0.0.1",8080);
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            DataInputStream dis =new DataInputStream(socket.getInputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            while(true) {
                dos.writeUTF(br.readLine());
                dos.flush();
                System.out.println(Thread.currentThread().getName()+"  "+dis.readUTF());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
