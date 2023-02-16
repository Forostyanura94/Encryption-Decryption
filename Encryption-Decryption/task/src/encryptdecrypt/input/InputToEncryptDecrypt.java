package encryptdecrypt.input;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class InputToEncryptDecrypt extends InputParameters {
    public static Map<String, String> encryptionDataMap = new HashMap<>();
    public void defineInputData(String[] inputData) throws IOException {
        for (int i = 0; i < inputData.length - 1; i++) {
                encryptionDataMap.put(inputData[i], inputData[i + 1]);
        }
        parseParameters(Arrays.asList(inputData), encryptionDataMap);
        defineEncryptionMethod(encryptionDataMap);
    }
}


