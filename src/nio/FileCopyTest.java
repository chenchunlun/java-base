package nio;

import java.io.*;

/**
 * Created by Administrator on 2016-6-22.
 */
public class FileCopyTest {
    public static void test() {
        String srcPath = "C:\\Users\\Administrator\\Desktop\\安徽广德研发部出游人员名单.xlsx";
        String orgPath = "d:\\";

        copyIoStyle(new File(srcPath), orgPath);

    }

    public static void copyIoStyle(File srcFile, String orgPath) {
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
                copyIoStyle(f, absoluteName);
            }
        } else {
            // 文件 拷贝
            FileInputStream fis = null;
            FileOutputStream fos = null;
            try {
                fis = new FileInputStream(srcFile);
                fos = new FileOutputStream(absoluteName);
                byte[] buffer = new byte[1024];
                int len = -1;
                while (-1 != (len = fis.read(buffer))) {
                    fos.write(buffer, 0, len);
                }
                fos.flush();
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
            }
        }
    }
}
