package net.tcp.chat_room;

import java.io.*;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by hp on 2016/5/25 0025.
 */
public class Client {
    private static ExecutorService es = Executors.newCachedThreadPool();
    public static void test() {
        try {
            Socket socket = new Socket("127.0.0.1", 8088);
            es.execute(new Sender(socket,Thread.currentThread().getName()));

            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String msg;
            while(null != (msg=br.readLine())){
                System.out.println(Thread.currentThread().getName()+"---->"+msg);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class Sender implements Runnable{
        private BufferedWriter bw ;
        private BufferedReader br;
        private String name;

        private Sender(Socket socket,String name){
            try {
                this.name = name;
                bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"));
                br = new BufferedReader(new InputStreamReader(System.in,"UTF-8"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            while (true){
                try {
                    String msg = br.readLine();
                    bw.write(msg);
                    bw.newLine();
                    bw.flush();
                    if("exit".equals(msg)){
                        es.shutdownNow();
                        break;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
