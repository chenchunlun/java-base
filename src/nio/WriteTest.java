package nio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by Administrator on 2016-6-22.
 */
public class WriteTest {
    public static void test() {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("d:/1.txt");
            byte[] message = "这是一个测试".getBytes();
            fos.write(message);
            fos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fos!= null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void noiStyle() {
        FileOutputStream fos = null;
        FileChannel channel = null;
        try {
            byte[] message = "Some bytes".getBytes();
            fos = new FileOutputStream("D:/1.txt");
            // 获取通道
            channel = fos.getChannel();
            // 创建缓冲区
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            for (byte b : message) {
                byteBuffer.put(b);
            }
            byteBuffer.flip();
            // 写入缓冲区
            channel.write(byteBuffer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (channel != null) {
                try {
                    channel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
