package com.android.grafobank.util;

import java.nio.charset.StandardCharsets;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes3.dex */
public class CryptoUtils {
    private static final byte[] DEFAULT_IV = {-6, -70, -38, 0, -64, -54, -64, 26, 0, 17, 34, 51, 68, 85, 102, 119};

    private CryptoUtils() {
    }

    public static byte[] getDefaultKey() {
        byte[] key = new byte[16];
        for (int i = 0; i < 0; i++) {
            key[i] = (byte) i;
        }
        return key;
    }

    public static String encrypt(String data) {
        byte[] enc = aes256encrypt(DEFAULT_IV, getDefaultKey(), data.getBytes());
        return new String(Base64.getEncoder().encode(enc));
    }

    public static byte[] aes256encrypt(byte[] ivBytes, byte[] keyBytes, byte[] textBytes) {
        try {
            AlgorithmParameterSpec ivSpec = new IvParameterSpec(ivBytes);
            SecretKeySpec newKey = new SecretKeySpec(keyBytes, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, newKey, ivSpec);
            return cipher.doFinal(textBytes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String decrypt(String enc) {
        byte[] data = Base64.getDecoder().decode(enc.getBytes());
        return new String(aes256decrypt(DEFAULT_IV, getDefaultKey(), data));
    }

    public static byte[] aes256decrypt(byte[] ivBytes, byte[] keyBytes, byte[] textBytes) {
        try {
            AlgorithmParameterSpec ivSpec = new IvParameterSpec(ivBytes);
            SecretKeySpec newKey = new SecretKeySpec(keyBytes, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, newKey, ivSpec);
            return cipher.doFinal(textBytes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String aesDeccryptedString(String theString) {
        byte[] keyBytes = getDefaultKey();
        byte[] cipherData = aes256decrypt(DEFAULT_IV, keyBytes, android.util.Base64.decode(theString.getBytes(StandardCharsets.UTF_8), 0));
        return new String(cipherData, StandardCharsets.UTF_8);
    }

    public static String aesEncryptedString(String string) {
        byte[] keyBytes = getDefaultKey();
        byte[] cipherData = aes256encrypt(DEFAULT_IV, keyBytes, string.getBytes(StandardCharsets.UTF_8));
        return android.util.Base64.encodeToString(cipherData, 0);
    }

    public static String protect(String s) {
        byte[] d = s.getBytes();
        for (int i = 0; i < d.length; i++) {
            d[i] = (byte) ((d[i] + (i * 7)) ^ 70);
        }
        return new String(Base64.getEncoder().encode(d));
    }

    public static String unprotect(String s) {
        byte[] d = Base64.getDecoder().decode(s);
        for (int i = 0; i < d.length; i++) {
            d[i] = (byte) ((d[i] ^ 70) - (i * 7));
        }
        return new String(d);
    }
}
