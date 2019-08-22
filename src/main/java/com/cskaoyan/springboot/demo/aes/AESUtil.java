package com.cskaoyan.springboot.demo.aes;

//import org.apache.commons.codec.binary.Base64;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AESUtil {
    private static final String KEY_ALGORITHM = "AES";
    //密码模式(算法/模式/填充)
    private static final String DEFAULT_CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";//默认的加密算法

    /**
     * AES 加密操作
     *
     * @param content 待加密内容
     * @param password 加密密码
     * @return 返回Base64转码后的加密数据
     */
    public static String encrypt(String content, String password) {
        try {
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);// 创建密码器
            cipher.init(Cipher.ENCRYPT_MODE, getSecretKey(password));// 初始化为加密模式的密码器
            //byte[] byteContent = content.getBytes();
            byte[] byteContent = content.getBytes("utf-8");

            byte[] result = cipher.doFinal(byteContent);// 加密
            //String encode = new BASE64Encoder().encode(result);
            //String encode = Base64Util.encode(result);
            String encode = Base64.encodeBase64String(result);
            return encode;//通过Base64转码返回
        } catch (Exception ex) {
            Logger.getLogger(AESUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    /**
     * AES 解密操作
     *
     * @param content 密文
     * @param password 秘钥
     * @return
     */
    public static String decrypt(String content, String password) {

        try {
            //实例化
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);

            //使用密钥初始化，设置为解密模式
            cipher.init(Cipher.DECRYPT_MODE, getSecretKey(password));

            //执行操作
            byte[] bytes = Base64.decodeBase64(content);
            //byte[] bytes = Base64Util.decode(content);
            //byte[] bytes = new BASE64Decoder().decodeBuffer(content);
            System.out.println("bytes 数组长度：" + bytes.length);
            byte[] result = cipher.doFinal(bytes);


            return new String(result, "utf-8");
        } catch (Exception ex) {
            Logger.getLogger(AESUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }


    /**
     * 生成加密秘钥
     *
     * @return
     */
    private static SecretKeySpec getSecretKey(final String password) {
        //返回生成指定算法密钥生成器的 KeyGenerator 对象
        KeyGenerator kg = null;

        try {
            kg = KeyGenerator.getInstance(KEY_ALGORITHM);

            //AES 要求密钥长度为 128
            kg.init(128, new SecureRandom(password.getBytes()));

            //生成一个密钥
            SecretKey secretKey = kg.generateKey();

            return new SecretKeySpec(secretKey.getEncoded(), KEY_ALGORITHM);// 转换为AES专用密钥
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AESUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public static void main(String[] args) {
        String s = "admin123";

        System.out.println("s:" + s);

        String s1 = AESUtil.encrypt(s, "admin123");
        System.out.println("s1:" + s1);

        System.out.println("s2:"+AESUtil.decrypt(s1, "admin123"));


    }
}
