package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class ConfigUtils {
    private static Properties properties;

    static {
        try {
            properties = new Properties();
            FileInputStream input = new FileInputStream("src/test/resources/config.properties");
            properties.load(input);
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Path getFileToUploadPath() {
        String relativeFilePath = properties.getProperty("upload.file.path");
        Path filePath = Paths.get(System.getProperty("user.dir"), relativeFilePath);
        System.out.println("Full file path: " + filePath.toAbsolutePath());
        return filePath.toAbsolutePath();
    }
}

