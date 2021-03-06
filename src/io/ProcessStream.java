package io;

import java.io.*;
import java.util.Arrays;

/**
 * Created by hp on 2016/5/15 0015.
 */
public class ProcessStream {
    public static void test(){
       // bufferdInputStream();
       // bufferedReader();
        //stringCode();
        //tranStream();
         //dataOutStream();
       // dataInputStream();
        objectOutputStream();
        objectInputStream();
    }

    /**
     * 反序列化
     */
    public static void objectInputStream(){
        File f = new File("F:/test.txt");
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(f)));
            System.out.println((Employee)objectInputStream.readObject());
            System.out.println(Arrays.toString((int[])objectInputStream.readObject()));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    /**
     * 序列化
     */
    public static void objectOutputStream(){
        File f = new File("F:/test.txt");
        if(f.exists()){
            f.delete();
        }
        ObjectOutputStream objectOutputStream = null;
        try {
            f.createNewFile();
            objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
            objectOutputStream.writeObject(new Employee("张三",100000));
            objectOutputStream.writeObject(new int[]{1,2,3});
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(objectOutputStream!=null){
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void dataInputStream(){
        DataInputStream dataInputStream = null;
        try {
            dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(new File("F:/test.txt"))));
            System.out.println(dataInputStream.readUTF());
            System.out.println(dataInputStream.readLong());
            System.out.println(dataInputStream.readDouble());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 数据输入流 ：保存数据类型（基本数据类型）和数据
     */
    public static void dataOutStream(){
        String str = "测试";
        long num = 100L;
        double d = 2.14;
        DataOutputStream dataOutputStream = null;
        File f = new File("F:/test.txt");
        try {
            if(f.exists()){
                f.delete();
            }
            f.createNewFile();
            dataOutputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
            dataOutputStream.writeUTF(str);
            dataOutputStream.writeLong(num);
            dataOutputStream.writeDouble(d);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(dataOutputStream!=null){
                try {
                    dataOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
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

class Employee implements Serializable {
    private transient String name;
    private double salary;

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
}
