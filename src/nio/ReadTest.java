package nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by Administrator on 2016-6-22.
 */
public class ReadTest {
    public static void test() {
        FileInputStream fin = null;
        try {
            fin = new FileInputStream("D:\\IdeaProjects\\java-base\\src\\nio\\ReadTest.java");
            byte[] buffer = new byte[1024];
            int len = -1;
            while (-1 != (len = fin.read(buffer))) {
                System.out.print(new String(buffer, 0, len));
            }
            System.out.println();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fin != null) {
                try {
                    fin.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void nioStyle() {
        FileInputStream fin = null;
        FileChannel channel = null;
        try {
            fin = new FileInputStream("D:\\IdeaProjects\\java-base\\src\\nio\\ReadTest.java");
            // 获取通道
            channel = fin.getChannel();
            // 创建缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            // 将数据从通道读到缓冲区中
            channel.read(buffer);

            System.out.println(new String(buffer.array()));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fin != null) {
                try {
                    fin.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(channel!=null){
                try {
                    channel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
