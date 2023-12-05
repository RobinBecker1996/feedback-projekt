package samples;

import org.bouncycastle.crypto.generators.Argon2BytesGenerator;
import org.bouncycastle.crypto.params.Argon2Parameters;
import org.dwcj.App;

import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Base64;

public class HashingClass {
    byte[] salt = generateSalt16Byte();
    String password = "passwort";
    
    public void getPassword(){
        String encryptionKeyArgon2id = base64Encoding(generateArgon2id(password, salt));
        App.consoleLog("encryptionKeyArgon2id (Base64) moderate:    " + encryptionKeyArgon2id);
    }


    public byte[] generateArgon2id(String password, byte[] salt) {
        int opsLimit = 3;
        int memLimit = 262144;
        int outputLength = 32;
        int parallelism = 1;
        Argon2Parameters.Builder builder = new Argon2Parameters.Builder(Argon2Parameters.ARGON2_id)
                .withVersion(Argon2Parameters.ARGON2_VERSION_13)
                .withIterations(opsLimit)
                .withMemoryAsKB(memLimit)
                .withParallelism(parallelism)
                .withSalt(salt);
        Argon2BytesGenerator gen = new Argon2BytesGenerator();
        gen.init(builder.build());
        byte[] result = new byte[outputLength];
        gen.generateBytes(password.getBytes(StandardCharsets.UTF_8), result, 0, result.length);
        return result;
    }

    public  byte[] generateSalt16Byte() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] salt = new byte[16];
        secureRandom.nextBytes(salt);
        return salt;
    }

    public String base64Encoding(byte[] input) {
        return Base64.getEncoder().encodeToString(input);
    }

}
