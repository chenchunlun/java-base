package security;

/**
 * Created by Administrator on 2016-5-25.
 */
public class Test {
    public static void test(){
        DES des = new DES();
        String plainStr = "测试DES加密算法";
        byte[] cipherByte = des.enCrytor(plainStr.getBytes());
        System.out.println(new String(cipherByte));
        System.out.println(new String(des.deCrytor(cipherByte)));

    }
}
