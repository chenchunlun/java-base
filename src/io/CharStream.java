package io;

import java.io.*;

/**
 * 字符流(节点流File为例)
 */
public class CharStream {
    public static void test(){
        // reader();
       //writer();
        copy();
    }

    public static void copy(){
        File src = new File("F:/ideaProjects/java-base/src/io/CharStream.java");
        File dest = new File("F:/CharStream.java");
        Reader read = null;
        Writer writer = null;
        try {
            read = new FileReader(src);
            writer = new FileWriter(dest);
            char[] buff = new char[1024];
            int len = -1;
            while (-1!=(len=read.read(buff))){
                writer.write(buff,0,len);
            }
            writer.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(writer!=null){
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(read!=null){
          }
        }
    }

    /**
     * 写入文件
     */
    public static void writer(){
        File file = new File("F:/test.txt");
        Writer writer = null;
        try {
            writer = new FileWriter(file,true);
            String str = "这是一个测试";
            char[] chars = str.toCharArray();
            // 字符串的操作
            writer.write(chars,0,chars.length);
            writer.append("嘿嘿");
            writer.write("hheh ");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(writer != null){
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    /**
     * 读取文件
     */
    public static void reader(){
        File file = new File("F:/ideaProjects/java-base/src/io/CharStream.java");
        Reader read =null;
        try {
            read = new FileReader(file);
            char[] chars = new char[1024];
            int len = -1;
            while(-1!=(len=read.read(chars))){
                String str = new String(chars,0,len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(read != null){
                try {
                    read.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
