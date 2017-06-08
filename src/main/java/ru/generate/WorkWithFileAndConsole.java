package ru.generate;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

/**
 * @author kosarim
 */
public class WorkWithFileAndConsole {

    public static void writeCdrsToFile(String path, String fileName, List<String> cdrs) {
        try {
            Files.write(Paths.get(path + fileName), cdrs,
                    StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Sorry can't write to file " + path + fileName);
        }
    }
    public static Properties getCorrectProperties() {
        Properties properties = new Properties();
        try (FileInputStream propertyFile = new FileInputStream("./src/resources/cdr.properties")){
            properties.load(propertyFile);
        } catch (IOException e){
            throw new RuntimeException("Нет проперти файла, стек - " + e);
        }
        return properties;
    }

    static int getCdrsNumber(){
        System.out.println("Введите количество вызовов, генеримых каждым потоком");
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }
}
