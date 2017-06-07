package ru.generate;

import ru.generate.cdr.calls.FixedCallCdr;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by rocky-po on 04.05.17.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Properties cdrProperties = new Properties();
        cdrProperties.load(Files.newInputStream(Paths.get("src/resources/cdr.properties")));
        String path = cdrProperties.getProperty("path");
        List<String> cdrs = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            cdrs.add(new FixedCallCdr(cdrProperties).createMessageCdr());
        }
        writeCdrsToFile(path, cdrs);
    }

    private static void writeCdrsToFile(String path, List<String> cdrs) {
        try {
            Files.write(Paths.get(path), cdrs,
                    StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Sorry can't write to file " + path);
        }
    }
    private Properties getCorrectProperties() {
        Properties properties = new Properties();
        try (FileInputStream propertyFile = new FileInputStream("./src/resources/cdr.properties")){
            properties.load(propertyFile);
        } catch (IOException e){
            throw new RuntimeException("Нет проперти файла, стек - " + e);
        }
        return properties;
    }
}