package io;

import java.io.*;

/**
 * 字节流(节点流File为例)
 */
public class ByteStream {
    public static void test(){
        //inputStream();
        //outStream();
        //copyFile();
        //copyDir();
       // arrayInputStream();
        arrayOutputStream();
    }

    public static  void arrayOutputStream(){
        byte[] dest = null;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] info = "这是一个测试".getBytes();
        outputStream.write(info,0,info.length);
        dest = outputStream.toByteArray();
        if(outputStream!=null){
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(new String(dest));

    }
    public static void arrayInputStream(){
        String src = "这是一个测试";
        InputStream inputStream = new BufferedInputStream(new ByteArrayInputStream(src.getBytes()));
        byte[] flu = new byte[1024];
        int len = -1;
        try {
            while(-1!=(len= inputStream.read(flu))){
                System.out.print(new String(flu,0,len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }



    /**
     *文件夹拷贝
     */
    public static void copyDir(){
        copyTool(new File("F:\\ideaProjects\\java-base"),"F:");
    }

    private static void copyTool(File src,String basePath){
        if(src==null || !src.exists()){
            return;
        }
        File dest = new File(basePath+File.separator+src.getName());
        if(src.isDirectory()){
            if(dest.exists()){
                dest.delete();
            }
            dest.mkdirs();
            File[] childFiles = src.listFiles();
            for(File child : childFiles){
                copyTool(child,dest.getAbsolutePath());
            }
        } else {
            if(dest.exists()){
                dest.delete();
            }
            InputStream inputStream= null;
            OutputStream outputStream= null;
            try {
                dest.createNewFile();
                if(dest.isFile()) {
                    inputStream = new FileInputStream(src);
                    outputStream = new FileOutputStream(dest);
                    byte[] bytes = new byte[1024];
                    int len = -1;
                    while (-1 != (len = inputStream.read(bytes))) {
                        outputStream.write(bytes, 0, len);
                    }
                    outputStream.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if(outputStream != null){
                    try {
                        outputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if(inputStream != null){
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     * 文件拷贝
     */
    public static void copyFile(){
        File src = new File("F:/ideaProjects/java-base/src/io/ByteStream.java");
        File dest = new File("F:/ByteStream.java");
        if(dest.exists()){
            dest.delete();
        }

        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            dest.createNewFile();
            inputStream = new FileInputStream(src);
            outputStream = new FileOutputStream(dest,true);
            byte[] bytes = new byte[1024];
            int len = -1;
            while(-1!=(len=inputStream.read(bytes))){
                outputStream.write(bytes,0,len);
            }
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(outputStream != null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /**
     * 文件输出流
     */
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
            outputStream.flush();
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

    /**
     * 文件输入流
     */
    public static void inputStream(){
        // 建立与文件的联系
        File file = new File("F:/ideaProjects/java-base/src/io/ByteStream.java");
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
    }
}
