package cz.osu;

import java.io.File;
import java.util.List;
import java.nio.file.Files;
import java.io.IOException;

public class FileManager {

    private static File getFile(String location){
        return new File(location);
    }

    public static List<String> convertFileToLines(String path) {
        try {
            return Files.readAllLines(getFile(path).toPath());
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
