/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 *
 * @author Acer Black Bou
 */
public interface ICryptoConfig {
    public static String algo="AES";
    public static int keysize = 128;
    public static String trans = "AES/CBC/PKCS5Padding";
    public static String iv = "bunftredfnjiklom";
    
    public static String skftransform="PBEWithHmacSHA256AndAES_128";
    public static String kdf="PBKDF2WithHmacSHA1";
    public static int ieration=1000;
    public static byte [] salt="MO5-°HG3YEH255367gdsjhgd".getBytes();
    
}
