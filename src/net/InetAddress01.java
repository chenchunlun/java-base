package net;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URL;
import java.net.UnknownHostException;

/***
 * 互联网的IP地址
 *
 */
public class InetAddress01 {
    public static void test(){
        InputStream in = null;
        try {
            /*InetAddress inetAddress = InetAddress.getLocalHost();
            System.out.println(inetAddress.getHostAddress());
            System.out.println(inetAddress.getHostName());
            inetAddress = InetAddress.getByName("www.baidu.com");
            System.out.println(inetAddress.getHostAddress());
            System.out.println(inetAddress.getHostName());
            inetAddress = InetAddress.getByName("111.13.100.92");
            System.out.println(inetAddress.getHostAddress());
            System.out.println(inetAddress.getHostName());*/

            /*InetSocketAddress inetSocketAddress = new InetSocketAddress("localhost",8080) ;
            inetSocketAddress = new InetSocketAddress(InetAddress.getByName("127.0.0.1"),8080) ;
            System.out.println(inetSocketAddress.getHostName());
            System.out.println(inetSocketAddress.getPort());
            InetAddress inetAddress = inetSocketAddress.getAddress();
            System.out.println(inetAddress.getHostAddress());
            System.out.println(inetAddress.getHostName());*/

            URL url = new URL("https://www.baidu.com?yyy=uuuu");// 只想互联网资源 绝对路径构建  相对路径构建
            url = new URL(url,"");
            System.out.println(url);
            System.out.println(url.getProtocol());
            System.out.println(url.getHost());
            System.out.println(url.getPort());
            System.out.println(url.getFile());
            System.out.println(url.getPath());
            System.out.println(url.getRef());
            System.out.println(url.getQuery());
            in = url.openStream();// 网络流
            byte[] flush = new byte[1024];
            int len = -1;
            while(-1!=(len = in.read(flush))){
                System.out.print(new String(flush,0,len));
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
