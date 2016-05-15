package io;

import java.io.*;

/**
 * Created by hp on 2016/5/15 0015.
 */
public class ProcessStream {
    public static void test(){
       // bufferdInputStream();
       // bufferedReader();
        //stringCode();
        tranStream();
    }

    /**
     * 转换流(字节流转字符流 解决乱码问题)
     */
    public static void tranStream(){
        File src = new File("F:/ideaProjects/java-base/src/io/ProcessStream.java");
        File dest = new File("F:/ProcessStream.java");
        InputStreamReader reader = null;
        OutputStreamWriter writer= null;

        try {
            reader = new InputStreamReader(new FileInputStream(src),"gbk");
            writer = new OutputStreamWriter(new FileOutputStream(dest),"utf-8");
            char[] buff = new char[1024];
            int len = -1;
            while (-1!=(len=reader.read(buff))){
                String str = new String(buff,0,len);
                writer.write(buff,0,len);
            }
            writer.flush();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(writer !=null){
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * 字符串编码
     */
    public static void stringCode(){
        try {
            String str = "中国";
            byte[] bytes = str.getBytes();
            System.out.println(new String(bytes));
            System.out.println(new String(str.getBytes("gbk")));

            System.out.println("*********************************");
            str = new String("中国".getBytes("gbk"));

            bytes = str.getBytes("gbk");
            System.out.println(new String(bytes));
            System.out.println(new String(str.getBytes("gbk")));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }


    public static void bufferedReader(){
        File src = new File("F:/ideaProjects/java-base/src/io/ProcessStream.java");
        File dest = new File("F:/ProcessStream.java");
        BufferedReader read = null;
        BufferedWriter writer = null;
        try {
            read = new BufferedReader(new FileReader(src));
            writer = new BufferedWriter(new FileWriter(dest));
            String str = null;
            while (null!=(str=read.readLine())){
                writer.write(str);
                writer.newLine();
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
     * 缓存字节流
     */
    public static void bufferdInputStream(){
        File src = new File("F:/ideaProjects/java-base/src/io/ProcessStream.java");
        File dest = new File("F:/ProcessStream.java");
        if(dest.exists()){
            dest.delete();
        }

        BufferedInputStream inputStream = null;
        BufferedOutputStream outputStream = null;
        try {
            dest.createNewFile();
            inputStream = new BufferedInputStream(new FileInputStream(src));
            outputStream =new BufferedOutputStream( new FileOutputStream(dest,true));
            byte[] bytes = new byte[1024];
            int len = -1;
            while(-1!=(len=inputStream.read(bytes))){
                outputStream.write(bytes,0,len);
            }
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
