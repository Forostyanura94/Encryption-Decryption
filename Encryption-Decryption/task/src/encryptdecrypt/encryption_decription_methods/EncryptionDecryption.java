package encryptdecrypt.encryption_decription_methods;

public interface EncryptionDecryption {

    void encryptDecryptText(char[] values, int key, String path);

    void shiftEncryptOrDecrypt(char[] values, int key, String path);
}
