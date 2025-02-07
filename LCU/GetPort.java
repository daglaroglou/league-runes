package LCU;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GetPort {
    public static String findPort() {
        String lockfilePath = GetLeaguePath.GetPath() + "/lockfile";
        try (BufferedReader reader = new BufferedReader(new FileReader(lockfilePath))) {
            String line = reader.readLine();
            if (line != null) {
                return line.split(":")[2];
            }
        } catch (IOException e) {}
        return null;
    }
}
