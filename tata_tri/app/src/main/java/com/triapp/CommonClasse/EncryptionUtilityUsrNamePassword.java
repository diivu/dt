package com.triapp.CommonClasse;

import android.util.Log;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by Svep Developer on 29-03-2018.
 */

public class EncryptionUtilityUsrNamePassword {

    static String result = "";
    private static final String ALGO = "AES";
    // please check that key length must be 16
    private static final byte[] ENCRYPTION_KEY = "0123456789ABCDEF".getBytes();   //"1234567890123456".getBytes();
//	private static final SecretKey secKey = new SecretKeySpec(ENCRYPTION_KEY, ALGO);

    public static String encrypt(String plainText){

        try{
            if(! (plainText.equals(""))){
                SecretKey secKey = new SecretKeySpec(ENCRYPTION_KEY, ALGO);
                Cipher aesCipher = Cipher.getInstance(ALGO);
                aesCipher.init(Cipher.ENCRYPT_MODE, secKey);
                byte[] byteCipherText = aesCipher.doFinal(plainText.getBytes());

                result = bytesToHex(byteCipherText);
            }
        }catch(Exception e){
            Log.e("Error","Exception1: " + e.getMessage());
        }
        return result;
    }

    public String decrypt(String byteCipherText){
        String result = "";
        try {
            if(! (byteCipherText == null || byteCipherText.equals(""))){
                Cipher aesCipher = Cipher.getInstance(ALGO);
                SecretKey secKey = new SecretKeySpec(ENCRYPTION_KEY, ALGO);
                aesCipher.init(Cipher.DECRYPT_MODE, secKey);
                byte[] decordedValue =  hexStringToByteArray(byteCipherText); //byteCipherText.getBytes();
                byte[] bytePlainText = aesCipher.doFinal(decordedValue);
                result =  new String(bytePlainText);
            }
        } catch (Exception e) {
            Log.e("Error","Exception2: " + e.getMessage());
        }
        return result;
    }


    public static SecretKey getSecretEncryptionKey() throws Exception {
        KeyGenerator generator = KeyGenerator.getInstance(ALGO);
        generator.init(128); // The AES key size in number of bits
        SecretKey secKey = generator.generateKey();
        return secKey;
    }

    private static String bytesToHex(byte[] hash) {
        String result ="";
        try {
            if(hash != null && hash.length > 0){
                char[] hexCode = "0123456789ABCDEF".toCharArray();
                StringBuilder r = new StringBuilder(hash.length * 2);
                for (byte b : hash) {
                    r.append(hexCode[(b >> 4) & 0xF]);
                    r.append(hexCode[(b & 0xF)]);
                }
                result = r.toString();
                //result = DatatypeConverter.printHexBinary(hash);
                //result = new String(hash);
            }
        } catch (Exception e) {
            Log.e("Error","Exception3: " + e.getMessage());
        }
        return result;
    }

    public byte[] hexStringToByteArray(String s) {
        byte[] data = null;
        try{
            if(! s.equals("")){
                int len = s.length();
                data = new byte[len / 2];
                for (int i = 0; i < len; i += 2) {
                    data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                            + Character.digit(s.charAt(i+1), 16));
                }
            }
        }catch (Exception e) {
            Log.e("Error","Exceptio4: " + e.getMessage());
        }
        return data;
    }

}
