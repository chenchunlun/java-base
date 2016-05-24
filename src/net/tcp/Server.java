package net.tcp;

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by hp on 2016/5/24 0024.
 */
public class Server {
    public static void test(){
        try {
            ServerSocket server = new ServerSocket(8080);
            Socket socket = server.accept();
            System.out.println(Thread.currentThread().getName()+"一个客户端建立连接");
           /* BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bw.write("这是一个测试");
            bw.newLine();
            bw.flush();*/
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            dos.writeUTF("测试");
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
