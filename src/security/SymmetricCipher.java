package security;

import javax.crypto.*;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

/**
 * 加密工具类（基于JDK）
 * 支持对称加密算法(DES、DESEDE、AES)和非对称加密算法(RSA)
 */
public class SymmetricCipher {

    public static final String DES = "DES";
    public static final String DESEDE = "DESede";
    public static final String AES = "AES";
    public static final String RSA = "RSA";
    // 负责加密
    private Cipher cipher;

    public SymmetricCipher() throws Exception {
        this(DES);
    }

    public SymmetricCipher(String arithmetic) throws Exception {
        if (!DES.equals(arithmetic) && !DESEDE.equals(arithmetic) && !AES.equals(arithmetic) && !arithmetic.equals(RSA)) {
            throw new Exception("no such arithmetic exception");
        }
        try {
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
    public byte[] enCrytor(byte[] plaintext, Key secretKey) {
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
    public byte[] deCrytor(byte[] ciphertext, Key secretKey) {
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
