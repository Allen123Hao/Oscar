package com.hao.security.des;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;

/**
 * <code>DES</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2017/6/19
 * @version: 1.0
 */
public class DES {

    /**
     * 加密
     * @param datasource
     * @param password
     * @return
     */
    public static byte[] encrypt(byte[] datasource,String password){
        SecureRandom random = new SecureRandom();
        try {
            DESKeySpec desKey = new DESKeySpec(password.getBytes());
            //创建一个密匙工厂，然后用它把DESKeySpec转换成
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey secretKey = keyFactory.generateSecret(desKey);
            //Cipher对象实际完成加密操作
            Cipher cipher = Cipher.getInstance("DES");
            //用密匙初始化Cipher对象
            cipher.init(Cipher.ENCRYPT_MODE,secretKey,random);
            return cipher.doFinal(datasource);
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static byte[] decrypt(byte[] src,String password){
        // DES算法要求有一个可信任的随机数源
        SecureRandom random = new SecureRandom();
        // 创建一个DESKeySpec对象
        try {
            DESKeySpec desKey = new DESKeySpec(password.getBytes());
            // 创建一个密匙工厂
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            // 将DESKeySpec对象转换成SecretKey对象
            SecretKey secretKey = keyFactory.generateSecret(desKey);
            // Cipher对象实际完成解密操作
            Cipher cipher = Cipher.getInstance("DES");
            // 用密匙初始化Cipher对象
            cipher.init(Cipher.DECRYPT_MODE,secretKey,random);
            return cipher.doFinal(src);
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }  catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        //待加密内容
        String str = "测试内容";
        //密码，长度要是8的倍数
//        String password = "9588028820109132570743325311898426347857298773549468758875018579537757772163084478873699447306034466200616411960574122434059469100235892702736860872901247123456";
        String password = "95880288201091325707";
        System.out.println("password's length:"+password.length());

        byte[] result = DES.encrypt(str.getBytes(),password);
        System.out.println("加密后："+new String(result));
        System.out.println(Arrays.toString(result));

        //直接将如上内容解密
        try {
            byte[] decryResult = DES.decrypt(result, password);
            System.out.println("解密后："+new String(decryResult));
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}
