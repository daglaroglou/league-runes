package LCU;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class GetAuth {
    public static String GetAuthKey() {
        String leaguePath = GetLeaguePath.GetPath();
        if (leaguePath == null) {
            return null;
        }
        try {
            String lockfilePath = leaguePath + "/lockfile";
            String lockfileContent = new String(Files.readAllBytes(Paths.get(lockfilePath)));
            String password = lockfileContent.split(":")[3];
            String combination = "riot:" + password;
            String encodedAuth = Base64.getEncoder().encodeToString(combination.getBytes(StandardCharsets.US_ASCII));
            return "Basic " + encodedAuth;
        } catch (IOException e) {
            return null;
        }
    }
}
