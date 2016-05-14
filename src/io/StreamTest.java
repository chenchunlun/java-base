package io;

import java.io.*;

/**
 *测试输入流
 */
public class StreamTest {
    public static void test(){
        inputStream();
    }
    public static void inputStream(){
        // 建立与文件的联系
        File file = new File("F:/ideaProjects/java-base/src/io/StreamTest.java");
        try {
            // 创建节点流
            InputStream inputStream = new FileInputStream(file);
            // 字节缓存数组
            byte[] bytes = new byte[1024];
            // 实际读取长度
            int len = -1;
            while(-1!=(len=inputStream.read(bytes))){
                String str = new String(bytes,0,len);
                System.out.println(str);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(file.getAbsoluteFile());
    }
}
