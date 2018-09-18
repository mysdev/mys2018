package com.jing.utils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * <pre>
 * Title: 	CustomizedDES.java
 * Author:	YanPing.Wu
 * Create:	January 6, 2011 16:39:09 PM
 * Copyright: 	Copyright (c) 2011
 * Company:		
 * <pre>
 */
public class CustomizedDES {
    /**
     * 定义一个内部类进行处理
     * 
     * @author WUYANPING
     */
    public static String KEY = "pywooden_PYHM&Spring*Aop";

    static class DES {
        private SecretKey p_Key;
        private String p_Algorithm = "DESede";
        private Cipher p_Cipher = Cipher.getInstance(this.p_Algorithm);

        public DES() throws Exception {
        //    Security.addProvider(new com.sun.crypto.provider.SunJCE());
            this.p_Cipher = Cipher.getInstance(this.p_Algorithm);
        }

        public byte[] getKey() {
            return this.checkKey().getEncoded();
        }

        /**
         * 
         * @return
         */
        private SecretKey checkKey() {
            try {
                if (this.p_Key == null) {
                    KeyGenerator keygen = KeyGenerator.getInstance(this.p_Algorithm);
                    this.p_Key = keygen.generateKey();
                }
            } catch (Exception nsae) {
            }
            return this.p_Key;
        }

        /**
         * @param enckey
         */
        public void setKey(byte[] enckey) {
            this.p_Key = new SecretKeySpec(enckey, this.p_Algorithm);
        }

        /**
         * @param data
         * @return
         * @throws Exception
         */
        public byte[] encode(byte[] data) throws Exception {
            this.p_Cipher.init(Cipher.ENCRYPT_MODE, this.checkKey());
            return this.p_Cipher.doFinal(data);
        }

        /**
         * 
         * @param encdata
         * @param enckey
         * @return
         * @throws Exception
         */
        public byte[] decode(byte[] encdata, byte[] enckey) throws Exception {
            this.setKey(enckey);
            this.p_Cipher.init(Cipher.DECRYPT_MODE, this.p_Key);
            return this.p_Cipher.doFinal(encdata);
        }

        /**
         * @param b
         * @return
         */
        public String byte2hex(byte[] b) {
            String hs = "";
            String stmp = "";
            for (int i = 0; i < b.length; i++) {
                stmp = Integer.toHexString(b[i] & 0xFF);
                if (stmp.length() == 1) {
                    hs += "0" + stmp;
                } else {
                    hs += stmp;
                }
            }
            return hs.toUpperCase();
        }

        /**
         * @param hex
         * @return
         * @throws IllegalArgumentException
         */
        public byte[] hex2byte(String hex) throws IllegalArgumentException {
            if (hex.length() % 2 != 0) {
                throw new IllegalArgumentException();
            }
            char[] arr = hex.toCharArray();
            byte[] b = new byte[hex.length() / 2];
            for (int i = 0, j = 0, l = hex.length(); i < l; i++, j++) {
                String swap = "" + arr[i++] + arr[i];
                int byteint = Integer.parseInt(swap, 16) & 0xFF;
                b[j] = new Integer(byteint).byteValue();
            }
            return b;
        }

        /**
         * this is DES algorithm, the string will be encode become hex
         * 
         * @param info
         * @return
         * @throws Exception
         */
        public String encode(String info, byte[] key) {
            setKey(key);
            try {
                return byte2hex(encode(info.getBytes()));
            } catch (Exception e) {
                return info;
            }
        }

        /**
         * this is DES algorithm, the string will be decode from hex text
         * 
         * @param info
         * @return
         * @throws Exception
         */
        public String decode(String info, byte[] key) {
            try {
                return new String(decode(hex2byte(info), key));
            } catch (Exception e) {
                return info;
            }
        }

        public String decode(String info, String hexkey) throws IllegalArgumentException, Exception {
            return new String(decode(hex2byte(info), hex2byte(hexkey)));
        }

    }

    /**
     * 对明文进行加密
     * 
     * @param password
     * @param key 必须为长度是24位的字符串
     * @return
     */
    public static String getEncodeText(String password, String key) {
        try {
            DES des = new DES();
            return des.encode(password, key.getBytes());
        } catch (Exception e) {
        }
        return "";

    }

    public static String getEncodeText(String password) {
        return getEncodeText(password, KEY);
    }

    /**
     * 对密文进行解密
     * 
     * @param enpassword
     * @param key
     * @return
     */
    public static String getDecodeText(String enpassword, String key) {
        try {
            DES des = new DES();
            return des.decode(enpassword, key.getBytes());

        } catch (Exception e) {
        }
        return "";
    }

    public static String getDecodeText(String enpassword) {
        return getDecodeText(enpassword, KEY);
    }
    
    public static void main(String[] args) {
    	System.out.println(CustomizedDES.getEncodeText("123456"));
	}
}