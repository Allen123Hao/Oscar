package com.hao.security.sha;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.digests.SHA224Digest;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * <code>ImoocSHA</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2016/12/30
 * @version: 1.0
 */
public class ImoocSHA {

    private static String src = "imooc.security.sha";

    public static void main(String[] args) {
        jdkSHA();
        bcSHA1();
        bcSHA224();
    }

    public static void jdkSHA(){
        try {
            MessageDigest md = MessageDigest.getInstance("SHA");
            md.update(src.getBytes());
            System.out.println("jdkSHA:"+new String(Hex.encodeHex(md.digest())));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public static void bcSHA1(){
        Digest digest = new SHA1Digest();
        digest.update(src.getBytes(),0,src.getBytes().length);
        byte[] sha1Bytes = new byte[digest.getDigestSize()];
        digest.doFinal(sha1Bytes,0);
        System.out.println("bc sha1:"+ org.bouncycastle.util.encoders.Hex.toHexString(sha1Bytes));
    }

    public static void bcSHA224(){
        Digest digest = new SHA224Digest();
        digest.update(src.getBytes(),0,src.getBytes().length);
        byte[] sha224Bytes = new byte[digest.getDigestSize()];
        digest.doFinal(sha224Bytes,0);
        System.out.println("bc sha224:"+ org.bouncycastle.util.encoders.Hex.toHexString(sha224Bytes));
    }

    public static void ccSHA1(){
        System.out.println("cc SHA1:"+DigestUtils.sha(src));
    }
}
