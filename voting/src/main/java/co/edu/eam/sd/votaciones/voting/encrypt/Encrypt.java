package co.edu.eam.sd.votaciones.voting.encrypt;

import org.springframework.stereotype.Component;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.util.Base64;

@Component
public class Encrypt {

    public String encritar(String msg,String key) throws GeneralSecurityException,UnsupportedEncodingException {
        //encriptar.......
        Cipher cipherEncript = Cipher.getInstance("AES/ECB/PKCS5PADDING");
        cipherEncript.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key.getBytes(), "AES"));
        byte[] encripted = cipherEncript.doFinal(msg.getBytes("UTF-8"));
        String encriptedStr =  Base64.getEncoder().encodeToString(encripted);


        return encriptedStr;
    }

}
