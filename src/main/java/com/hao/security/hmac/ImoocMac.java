package com.hao.security.hmac;

import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.KeyParameter;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * <code>ImoocMac</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2016/12/30
 * @version: 1.0
 */
public class ImoocMac {
    private static String src = "imooc security hmac";

    public static void main(String[] args) {
        jdkHmacMD5();
        bcHmacMD5();
    }

    private static void jdkHmacMD5(){
        try {
            //初始化KeyGenerator
            KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacMD5");
            //产生秘钥
            SecretKey secretKey = keyGenerator.generateKey();
            //获取秘钥
//            byte[] key = secretKey.getEncoded();
            byte[] key = Hex.decodeHex(new char[]{'a','b','c','d','a','b','c','e'});

            //还原秘钥
            SecretKey restoreKey = new SecretKeySpec(key,"HmacMD5");
            //实例化Mac
            Mac mac = Mac.getInstance(restoreKey.getAlgorithm());
            //初始化Mac
            mac.init(restoreKey);
            //执行摘要
            byte[] hmacMD5Byte = mac.doFinal(src.getBytes());
            System.out.println("jdk HmacMD5:"+ new String(Hex.encodeHex(hmacMD5Byte)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void bcHmacMD5(){
        HMac hMac = new HMac(new MD5Digest());
        hMac.init(new KeyParameter(org.bouncycastle.util.encoders.Hex.decode("abcdabce")));
        hMac.update(src.getBytes(),0,src.getBytes().length);

        byte[] hmacMD5Bytes = new byte[hMac.getMacSize()];
        hMac.doFinal(hmacMD5Bytes,0);

        System.out.println("bc hmacMD5:"+ org.bouncycastle.util.encoders.Hex.toHexString(hmacMD5Bytes));
    }
}
