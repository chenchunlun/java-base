package io;

import java.io.*;

/**
 *测试输入流
 */
public class StreamTest {
    public static void test(){
        //inputStream();
        outStream();
    }
    public static void outStream(){
        // 建立文件连接
        File file = new File("F:/outtest.txt");
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // 创建节点流
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file,true);// true 表示追加 false 表示覆盖 默认false
            String  str = "这是一个测试";
            byte[] bytes = str.getBytes();
            outputStream.write(bytes,0,bytes.length);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(outputStream!=null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
    public static void inputStream(){
        // 建立与文件的联系
        File file = new File("F:/ideaProjects/java-base/src/io/StreamTest.java");
        InputStream inputStream = null;
        try {
            // 创建节点流
            inputStream = new FileInputStream(file);
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
        } finally {
            if(inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

        System.out.println(file.getAbsoluteFile());
    }
}
