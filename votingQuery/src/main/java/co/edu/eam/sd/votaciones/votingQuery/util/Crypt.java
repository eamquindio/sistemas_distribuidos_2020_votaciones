package co.edu.eam.sd.votaciones.votingQuery.util;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Base64;

public class Crypt {

    public static String encriptar(String msj, String key) throws GeneralSecurityException, UnsupportedEncodingException {
        Cipher cipherEncript = Cipher.getInstance("AES/ECB/PKCS5PADDING");
        cipherEncript.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key.getBytes(), "AES"));
        byte[] encripted = cipherEncript.doFinal(msj.getBytes("UTF-8"));
        String encriptedStr = Base64.getEncoder().encodeToString(encripted);
        return encriptedStr;
    }

    public static String desencriptar(String msj, String key) throws GeneralSecurityException {
        //desencriptar......
        Cipher cipherDecript = Cipher.getInstance("AES/ECB/PKCS5PADDING");
        cipherDecript.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key.getBytes(), "AES"));
        String decripted = new String(cipherDecript.doFinal(Base64.getDecoder().decode(msj)));
        return decripted;
    }
}
