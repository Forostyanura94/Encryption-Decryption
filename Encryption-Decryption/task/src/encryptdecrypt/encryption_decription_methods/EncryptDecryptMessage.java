package encryptdecrypt.encryption_decription_methods;

import encryptdecrypt.input.InputToEncryptDecrypt;
import encryptdecrypt.util.Constants;

import java.io.FileWriter;

public abstract class EncryptDecryptMessage implements EncryptionDecryption {
    public static final int LAST_NUMBER = 127;

    @Override
    public void encryptDecryptText(char[] values, int key, String path) {
        StringBuilder encryptedMessage = new StringBuilder();
        if (InputToEncryptDecrypt.encryptionDataMap.get(Constants.MODE).equals("enc")) {
            for (char letter : values) {
                char position = (char) (letter + key);
                char diff = (char) (position - LAST_NUMBER);
                encryptedMessage = position > LAST_NUMBER
                        ? encryptedMessage.append(diff) : encryptedMessage.append(position);
            }
        } else {
            for (char letter : values) {
                char position = (char) (letter - key);
                encryptedMessage.append(position);
            }
        }
        System.out.println(encryptedMessage);
        if (path != null) {
            try (FileWriter fileWriter = new FileWriter(path)) {
                for (char letter : values) {
                    char position = InputToEncryptDecrypt.encryptionDataMap.get(Constants.MODE).equals("enc")
                            ? (char) (letter + key) : (char) (letter - key);
                    fileWriter.write(position);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void shiftEncryptOrDecrypt(char[] values, int key, String path) {
        if (InputToEncryptDecrypt.encryptionDataMap.get(Constants.MODE).equals("enc")) {
            for (int i = 0; i < values.length; ++i) {
                if (values[i] >= 'a' && values[i] <= 'z') {
                    values[i] += key;
                    if (values[i] > 'z') {
                        values[i] -= 26;
                    }
                }
                if (Character.isUpperCase(values[i])) {
                    if (values[i] >= 'A' && values[i] <= 'Z') {
                        values[i] += key;
                    }
                    if (values[i] >= 'Z') {
                        values[i] -= 26;
                    }
                }
            }
        } else {
            for (int i = 0; i < values.length; ++i) {
                if (values[i] >= 'a' && values[i] <= 'z') {
                    values[i] -= key;
                    if (values[i] < 'a') {
                        values[i] += 26;
                    }
                }

                if (Character.isUpperCase(values[i])) {
                    if (values[i] >= 'A' && values[i] <= 'Z') {
                        values[i] -= key;
                        if (values[i] <= 'Z') {
                            values[i] += 26;
                        }
                    }
                }
            }
        }

        if (path != null) {
            try (FileWriter fileWriter = new FileWriter(path)) {
                for (char letter : values) {
                    fileWriter.write(letter);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}




