package security;

import javax.crypto.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * 对称密码体制
 */
public class SymmetricCipher {

    public static final String DES = "DES";
    public static final String DESEDE = "DESede";
    public static final String AES = "AES";

    // 密钥生成器
    private KeyGenerator keyGenerator;
    // 负责保存密钥
    private SecretKey secretKey;
    // 负责加密
    private Cipher cipher;

    public SymmetricCipher() throws Exception {
        this(DES);
    }

    public SymmetricCipher(String arithmetic) throws Exception {
        if(!DES.equals(arithmetic) && !DESEDE.equals(arithmetic) && !AES.equals(arithmetic)){
            throw new Exception("no such arithmetic exception");
        }
        try {
            keyGenerator = KeyGenerator.getInstance(arithmetic);
            secretKey = keyGenerator.generateKey();
            cipher = Cipher.getInstance(arithmetic);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        }
    }

    /**
     * 加密.
     *
     * @param plaintext 明文字节数组
     * @return
     */
    public byte[] enCrytor(byte[] plaintext) {
        try {
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return cipher.doFinal(plaintext);
        } catch (InvalidKeyException e) {
            e.printStackTrace();
            return null;
        } catch (BadPaddingException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 解密.
     *
     * @param ciphertext 密文字节数组
     * @return
     */
    public byte[] deCrytor(byte[] ciphertext) {
        try {
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return cipher.doFinal(ciphertext);
        } catch (InvalidKeyException e) {
            e.printStackTrace();
            return null;
        } catch (BadPaddingException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
            return null;
        }
    }

}
