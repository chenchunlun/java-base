package net.tcp.chat_room;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by hp on 2016/5/25 0025.
 */
public class Server {
    private static ExecutorService es = Executors.newCachedThreadPool();
    private static Set<Socket> clients = new HashSet<>();
    public static void test(){
        try {
            ServerSocket serverSocket = new ServerSocket(8088);
            while (true){
                Socket socket = serverSocket.accept();
                clients.add(socket);
                es.execute(new Client(socket));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class Client implements Runnable{
        private Socket socket;
        private Client(Socket socket){
            this.socket = socket;
        }
        @Override
        public void run() {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
                String msg;
                while (null != (msg = br.readLine())){
                    if("exit".equals(msg)){
                        clients.remove(socket);
                        break;
                    }
                    for(Socket socket : clients){
                        try {
                            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                            bw.write(msg);
                            bw.newLine();
                            bw.flush();
                        }catch (Exception e){

                        }
                    }
                }


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
