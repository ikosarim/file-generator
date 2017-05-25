package ru.generate;

import ru.generate.cdr.calls.FixedCallCdr;

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
        int cdrNumber = Integer.parseInt(cdrProperties.getProperty("cdrNumber"));
        List<String> cdrs = new ArrayList<>();
        for (int i = 0; i < cdrNumber; i++) {
            cdrs.add(new FixedCallCdr(cdrProperties).createCdr());
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
}