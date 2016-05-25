package net.tcp.chat_room;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by hp on 2016/5/25 0025.
 */
public class Server {
    public static void test(){
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            Socket socket = serverSocket.accept();
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            while(true) {
                String msg = dis.readUTF();
                dos.writeUTF("服务器响应：" + msg);
                dos.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
