package com.hao.security.md;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.MD4Digest;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

/**
 * <code>ImoocMD</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2016/12/30
 * @version: 1.0
 */
public class ImoocMD {
    private static String src = "abc";

    public static void main(String[] args) {
        jdkMD5();
        jdkMD2();
        bcMD4();
        bcMD5();
        provider_bcMD4();
        provider_bcMD5();
        ccMD5();
    }

    private static void jdkMD5(){
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] md5Bytes = md5.digest(src.getBytes());
            System.out.println("jdkMD5 info:"+md5.getProvider().getInfo());
            System.out.println("JDK MD5:"+ new String(Hex.encodeHex(md5Bytes)));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    private static void jdkMD2(){
        try {
            MessageDigest md2 = MessageDigest.getInstance("MD2");
            byte[] md2Bytes = md2.digest(src.getBytes());
            System.out.println("JDK MD2:"+ new String(Hex.encodeHex(md2Bytes)));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    private static void bcMD4(){
        Digest digest = new MD4Digest();
        digest.update(src.getBytes(), 0, src.getBytes().length);
        byte[] md4Bytes = new byte[digest.getDigestSize()];
        digest.doFinal(md4Bytes,0);
        System.out.println("BC  MD4:"+org.bouncycastle.util.encoders.Hex.toHexString(md4Bytes));
    }

    private static void bcMD5(){
        Digest digest = new MD5Digest();
        digest.update(src.getBytes(), 0, src.getBytes().length);
        byte[] md5Bytes = new byte[digest.getDigestSize()];
        digest.doFinal(md5Bytes,0);
        System.out.println("BC  MD5:" + org.bouncycastle.util.encoders.Hex.toHexString(md5Bytes));
    }

    private static void provider_bcMD4(){
        Security.addProvider(new BouncyCastleProvider());
        try {
            MessageDigest md = MessageDigest.getInstance("MD4");
            byte[] md4Bytes = md.digest(src.getBytes());
            System.out.println("Provider_BC MD4:"+ org.bouncycastle.util.encoders.Hex.toHexString(md4Bytes));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    private static void provider_bcMD5(){
        Security.addProvider(new BouncyCastleProvider());
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] md5Bytes = md.digest(src.getBytes());
            System.out.println("provider_bcMD5 info:"+md.getProvider().getInfo());
            System.out.println("Provider_BC MD5:"+ org.bouncycastle.util.encoders.Hex.toHexString(md5Bytes));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    private static void ccMD5(){
        System.out.println("ccMD5:" + DigestUtils.md5Hex(src));
    }

}
