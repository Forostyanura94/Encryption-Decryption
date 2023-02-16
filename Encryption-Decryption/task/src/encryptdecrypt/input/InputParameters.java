package encryptdecrypt.input;

import encryptdecrypt.encryption_decription_methods.EncryptDecryptMessage;
import encryptdecrypt.encryption_decription_methods.EncryptionDecryption;
import encryptdecrypt.util.Constants;
import encryptdecrypt.util.Utils;

import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;

public class InputParameters extends EncryptDecryptMessage implements EncryptionDecryption {

    public static String data;
    public static String path;

    public void parseParameters(List<?> inputData, Map<String, String> encryptionDataMap) throws IOException {
        if ((inputData).contains(Constants.DATA) && inputData.contains(Constants.IN)) {
            data = encryptionDataMap.get(Constants.DATA);
        } else if (!inputData.contains(Constants.DATA) && inputData.contains(Constants.IN)) {
            File file = new File(encryptionDataMap.get(Constants.IN));
            data = Utils.readFileAsString(file.toString());
        } else {
            data = encryptionDataMap.get(Constants.DATA);
        }
        if (inputData.contains(Constants.OUT)) {
            File fileOut = new File(encryptionDataMap.get(Constants.OUT));
            path = fileOut.getCanonicalPath();
        }
    }

    public void defineEncryptionMethod(Map<String, String> encryptionDataMap) {
        try {
            if (encryptionDataMap.get(Constants.ALG).equals("unicode")) {
                encryptDecryptText(data.toCharArray(), Integer.parseInt(encryptionDataMap.get(Constants.KEY)), path);
            } else {
                shiftEncryptOrDecrypt(data.toCharArray(), Integer.parseInt(encryptionDataMap.get(Constants.KEY)), path);
            }
        } catch (InputMismatchException e) {
            System.out.println("Values only for encryption and decryption");
        }
    }
}











