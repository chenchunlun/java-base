package loader;

import java.io.*;

/**
 * Created by hp on 2016/6/18 0018.
 */
public class FileSystemClassLoader extends ClassLoader {
    private String root;

    public FileSystemClassLoader(String root) {
        this.root = root;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        // 1、是否被加载
        Class<?> c = findLoadedClass(name);
        if (c == null) {
            try {
                c = getParent().loadClass(name);
            } catch (ClassNotFoundException e) {
            }

            if (c == null) {
                byte[] bytes = null;
                String classPath = root + "/" + name.replaceAll("\\.", "/")+".class";
                FileInputStream fis = null;
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                try {
                    byte[] buffer = new byte[1024];
                    int temp = -1;
                    fis = new FileInputStream(classPath);
                    while (-1 != (temp = fis.read(buffer))) {
                        bos.write(buffer, 0, temp);
                    }
                    bytes = bos.toByteArray();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (bos != null) {
                        try {
                            bos.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                if (bytes == null)
                    throw new ClassNotFoundException();
                else
                    c = defineClass(name, bytes, 0, bytes.length);
            }
        }
        return c;
    }
}
