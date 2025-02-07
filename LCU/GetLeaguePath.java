package LCU;

import java.io.File;

public class GetLeaguePath {
    public static String GetPath() {
        return ProcessHandle.allProcesses()
            .filter(process -> process.info().command().isPresent())
            .map(process -> process.info().command().get())
            .filter(command -> command.contains("LeagueClient"))
            .map(command -> {
                File file = new File(command);
                return file.getParent();
            })
            .findFirst()
            .orElse(null);
    }
}