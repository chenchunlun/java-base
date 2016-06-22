package nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by Administrator on 2016-6-22.
 */
public class FileCopyTest {
    public static void test() {
        String srcPath = "D:\\IdeaProjects\\java-base";
        String orgPath = "d:\\";

        copy(new File(srcPath), orgPath);

    }

    public static void copy(File srcFile, String orgPath) {
        String name = srcFile.getName();
        String absoluteName = orgPath + File.separator + name;
        if (srcFile.exists()) {
            File orgFile = new File(absoluteName);
            // 覆盖
            if (orgFile.exists()) {
                orgFile.delete();
            }

            // 创建目标文件、目录
            if (srcFile.isDirectory()) {
                orgFile.mkdir();
            } else {
                try {
                    orgFile.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            return;
        }
        if (srcFile.isDirectory()) {
            // 目录 递归
            File[] files = srcFile.listFiles();
            for (File f : files) {
                copy(f, absoluteName);
            }
        } else {
            // 文件 拷贝
            FileInputStream fis = null;
            FileOutputStream fos = null;
            FileChannel fic = null;
            FileChannel foc = null;
            try {
                fis = new FileInputStream(srcFile);
                fos = new FileOutputStream(absoluteName);
                /*byte[] buffer = new byte[1024];
                int len = -1;
                while (-1 != (len = fis.read(buffer))) {
                    fos.write(buffer, 0, len);
                }
                fos.flush();*/
                fic = fis.getChannel();
                foc = fos.getChannel();
                ByteBuffer buff = ByteBuffer.allocate(1024);
                while (fic.read(buff) > 0) {
                    buff.flip();
                    // 判断是不是最后一段数据
                    if (fic.position() == fic.size()) {
                        int lastRead = (int) (fic.size() % 1024);
                        byte[] bytes = new byte[lastRead];
                        buff.get(bytes, 0, lastRead);
                        foc.write(ByteBuffer.wrap(bytes));
                        buff.clear();
                    } else {
                        foc.write(buff);
                        buff.clear();
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (fos != null) {
                    try {
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                if(fic != null){
                    try {
                        fic.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if(foc!=null){
                    try {
                        foc.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
