package io;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 文件的切割与组合
 */
public class RandomAccess {
    public static void test(){
        new SplitFile("C:\\Users\\Administrator\\Desktop\\新建文件夹\\dubbo源码解析2.0.pdf").splitFile();
    }
}


class SplitFile {
    private File file;
    private long fileSize;

    public SplitFile(String filePath) {
        this(new File(filePath));
    }

    public SplitFile(File file) {
        this(file, 512);
    }

    public SplitFile(File file, long fileSize) {
        if (file == null) {
            throw new NullPointerException("文件不允许为空");
        }
        this.file = file;
        this.fileSize = fileSize;
    }

    public void splitFile() {
        try {
            RandomAccessFile in = new RandomAccessFile(file, "r");
            Map<String, Long> childFileDetail = childFileDetail();
            long seekLength = 0;
            byte[] bytes;
            for (Iterator<Map.Entry<String, Long>> it = childFileDetail.entrySet().iterator(); it.hasNext(); ) {
                Map.Entry<String, Long> entry = it.next();
                String fileName = entry.getKey();
                Long fileSize = entry.getValue();
                File f = new File(fileName);
                if (f.exists()) {
                    f.delete();
                }
                f.createNewFile();
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(f));
                in.seek(seekLength);
                bytes = new byte[((int) fileSize.longValue())];
                in.read(bytes);
                bos.write(bytes);
                bos.flush();
                bos.close();
                seekLength += fileSize;
            }
            in.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Map<String, Long> childFileDetail() throws Exception {
        Map<String, Long> rs = new LinkedHashMap<>();
        if (file.length() == 0) {
            throw new Exception();
        }
        int fileCount = (int) (file.length() / fileSize) + 1;
        if (fileCount == 1) {
            rs.put(file.getAbsolutePath() + 1, file.length());
        } else {
            for (int i = 0; i <= fileCount - 1; i++) {
                rs.put(file.getAbsolutePath() + (i + 1), fileSize);
            }
            rs.put(file.getAbsolutePath() + fileCount, file.length() - fileSize * (fileCount - 1));
        }
        return rs;
    }

}
