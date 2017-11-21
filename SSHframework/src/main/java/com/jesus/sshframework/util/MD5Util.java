package com.jesus.sshframework.util;
import java.security.MessageDigest;  
import java.security.NoSuchAlgorithmException;  
  
import org.apache.commons.codec.digest.DigestUtils;import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//开发的jar包 使用更方便
public class MD5Util {
    private static final Logger LOG = LoggerFactory.getLogger(MD5Util.class);
    public static String encrypByMd5(String context) {  
        StringBuffer buf = new StringBuffer("");  
        try {  
            MessageDigest md = MessageDigest.getInstance("MD5");  
            md.update(context.getBytes());//update处理  
            byte [] encryContext = md.digest();//调用该方法完成计算  
  
            int i;  
            for (int offset = 0; offset < encryContext.length; offset++) {//做相应的转化（十六进制）  
                i = encryContext[offset];  
                if (i < 0) i += 256;  
                if (i < 16) buf.append("0");  
                buf.append(Integer.toHexString(i));  
           }  
            LOG.debug("32result: " + buf.toString());// 32位的加密  
            LOG.debug("16result: " + buf.toString().substring(8, 24));// 16位的加密  
        } catch (NoSuchAlgorithmException e) {  
           
            e.printStackTrace();  
        }  
        return buf.toString();
    }  
}
