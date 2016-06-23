package nio;

import java.io.BufferedReader;
import java.nio.Buffer;
import java.nio.ByteBuffer;

/**
 * Created by Administrator on 2016-6-22.
 */
public class Test {
    public static void test(){
        //ReadTest.test();
        //WriteTest.test();
        //FileCopyTest.test();

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        System.out.println(buffer.capacity());
        System.out.println(buffer.limit());
        System.out.println(buffer.position());
        System.out.println(buffer.isReadOnly());
    }
}
