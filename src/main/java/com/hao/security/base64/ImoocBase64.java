package com.hao.security.base64;

import org.apache.commons.codec.binary.Base64;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * <code>ImoocBase64</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2016/12/30
 * @version: 1.0
 */
public class ImoocBase64 {

    private static String src = "imooc security base64";

    public static void main(String[] args) throws Exception{
        jdkBase64();
        commonsCodeBase64();
        bouncyCastleBase64();
    }

    public static void jdkBase64() throws Exception{
        BASE64Encoder encoder = new BASE64Encoder();
        String encode = encoder.encode(src.getBytes());
        System.out.println("encode:"+encode);

        BASE64Decoder decoder = new BASE64Decoder();
        String decode = new String(decoder.decodeBuffer(encode),"UTF-8");
        System.out.println("decode:" + decode);
    }

    public static void commonsCodeBase64(){
        byte[] encodeBytes = Base64.encodeBase64(src.getBytes());
        System.out.println("encode:" + new String(encodeBytes));

        byte[] decodeBytes = Base64.decodeBase64(encodeBytes);
        System.out.println("decode:"+ new String(decodeBytes));
    }

    public static void bouncyCastleBase64(){
        byte[] encodeBytes = org.bouncycastle.util.encoders.Base64.encode(src.getBytes());
        System.out.println("encode:" + new String(encodeBytes));

        byte[] decodeBytes = org.bouncycastle.util.encoders.Base64.decode(encodeBytes);
        System.out.println("decode:"+ new String(decodeBytes));

    }
}
