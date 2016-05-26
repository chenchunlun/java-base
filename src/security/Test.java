package security;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

/**
 * Created by Administrator on 2016-5-25.
 */
public class Test {
    public static void test() {
        String plainStr = "测试加密算法";
        try {
            System.out.println("**************************非对称加密算法(RSA)******************************");
            SymmetricCipher symmetricCipher = new SymmetricCipher(SymmetricCipher.RSA);
            // 创建公私密钥生成器
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(SymmetricCipher.RSA);
            // 指定密钥位数
            keyPairGenerator.initialize(1024);
            // 生成密钥对
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            // 获取RSA 私钥
            RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) keyPair.getPrivate();
            RSAPublicKey rsaPublicKey = (RSAPublicKey) keyPair.getPublic();
            byte[] cipherByte = symmetricCipher.enCrytor(plainStr.getBytes(), rsaPrivateKey);
            System.out.println(new String(cipherByte));
            System.out.println(new String(symmetricCipher.deCrytor(cipherByte, rsaPublicKey)));
            System.out.println("**************************对称加密算法**********************************");
            symmetricCipher = new SymmetricCipher(SymmetricCipher.AES);
            KeyGenerator keyGenerator = KeyGenerator.getInstance(SymmetricCipher.AES);
            SecretKey secretKey = keyGenerator.generateKey();
            cipherByte = symmetricCipher.enCrytor(plainStr.getBytes(), secretKey);
            System.out.println(new String(cipherByte));
            System.out.println(new String(symmetricCipher.deCrytor(cipherByte, secretKey)));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
