package security;

/**
 * Created by Administrator on 2016-5-25.
 */
public class Test {
    public static void test(){
        SymmetricCipher symmetricCipher = null;
        try {
            symmetricCipher = new SymmetricCipher(SymmetricCipher.DESEDE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String plainStr = "测试DES加密算法";
        byte[] cipherByte = symmetricCipher.enCrytor(plainStr.getBytes());
        System.out.println(new String(cipherByte));
        System.out.println(new String(symmetricCipher.deCrytor(cipherByte)));

    }
}
