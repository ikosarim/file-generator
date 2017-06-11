package ru.generate.operation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import static org.apache.commons.lang.math.NumberUtils.toInt;

/**
 * @author kosarim
 */
public class ConsoleHelper {

    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmm'_t'mm");

    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    private static String readString() throws IOException {
        return bis.readLine();
    }

    public static int readInt() throws IOException {
        String text = readString();
        return toInt(text);
    }

    public static int askCount() throws IOException {
        System.out.println("Сколько сгенерить? 0 -> возврат в меню!");
        int count = readInt();
        if (count < 0) {
            System.out.println("Не правильное число!");
            askCount();
        }
        return count;
    }

    public static Properties getCorrectProperties() {
        Properties properties = new Properties();
        try (FileInputStream propertyFile = new FileInputStream("./src/resources/cdr.properties")) {
            properties.load(propertyFile);
        } catch (IOException e) {
            // throw new RuntimeException("Нет проперти файла, стек - " + e);
        }
        return properties;
    }
}
