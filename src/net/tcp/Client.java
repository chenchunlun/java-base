package net.tcp;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by hp on 2016/5/24 0024.
 */
public class Client {
    public static void test(){
        try {
            Socket client = new Socket("localhost",8080);
           /* BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
            System.out.println(Thread.currentThread().getName()+br.readLine());*/
            DataInputStream dis = new DataInputStream(client.getInputStream());
            System.out.println(Thread.currentThread().getName()+dis.readUTF());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
