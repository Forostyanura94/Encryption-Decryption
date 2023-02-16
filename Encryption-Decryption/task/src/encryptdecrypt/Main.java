package encryptdecrypt;

import encryptdecrypt.input.InputToEncryptDecrypt;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        InputToEncryptDecrypt input = new InputToEncryptDecrypt();
        input.defineInputData(args);
    }
}
