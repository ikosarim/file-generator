package ru.generate;

import ru.generate.cdr.calls.FixedCallCdr;
import ru.generate.cdr.calls.MobileCallCdr;
import ru.generate.cdr.location.LocationCdr;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

/**
 * Created by rocky-po on 04.05.17.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        int cdrsNumber = getCdrsNumber();
        String path = getCorrectProperties().getProperty("path");
        List<String> cdrs = new ArrayList<>();
        List<String> secondCdrs = new ArrayList<>();
        List<String> thirdCdrs = new ArrayList<>();
        List<String> fourthCdrs = new ArrayList<>();
        switch (getMessageCode()){
            case 1:
                cdrs = createFixedCallsCdrs(cdrsNumber);
                break;
            case 2:
                cdrs = createMobileCallsCdrs(cdrsNumber);
                break;
            case 3:
                cdrs = createSmsCdrs(cdrsNumber);
                break;
            case 4:
                cdrs = createLocationCdrs(cdrsNumber);
                break;
            case 5:
                cdrs = createFixedCallsCdrs(cdrsNumber/2);
                secondCdrs = createMobileCallsCdrs(cdrsNumber/2);
                break;
            case 6:
                cdrs = createFixedCallsCdrs(cdrsNumber/2);
                secondCdrs = createSmsCdrs(cdrsNumber/2);
                break;
            case 7:
                cdrs = createFixedCallsCdrs(cdrsNumber/2);
                secondCdrs = createLocationCdrs(cdrsNumber/2);
                break;
            case 8:
                cdrs = createMobileCallsCdrs(cdrsNumber/2);
                secondCdrs = createSmsCdrs(cdrsNumber/2);
                break;
            case 9:
                cdrs = createMobileCallsCdrs(cdrsNumber/2);
                secondCdrs = createLocationCdrs(cdrsNumber/2);
                break;
            case 10:
                cdrs = createSmsCdrs(cdrsNumber/2);
                secondCdrs = createLocationCdrs(cdrsNumber/2);
                break;
            case 11:
                cdrs = createFixedCallsCdrs(cdrsNumber/3);
                secondCdrs = createMobileCallsCdrs(cdrsNumber/3);
                thirdCdrs = createSmsCdrs(cdrsNumber/3);
                break;
            case 12:
                cdrs = createFixedCallsCdrs(cdrsNumber/3);
                secondCdrs = createMobileCallsCdrs(cdrsNumber/3);
                thirdCdrs = createLocationCdrs(cdrsNumber/3);
                break;
            case 13:
                cdrs = createMobileCallsCdrs(cdrsNumber/3);
                secondCdrs = createSmsCdrs(cdrsNumber/3);
                thirdCdrs = createLocationCdrs(cdrsNumber/3);
                break;
            case 14:
                cdrs = createFixedCallsCdrs(cdrsNumber/4);
                secondCdrs = createMobileCallsCdrs(cdrsNumber/4);
                thirdCdrs = createSmsCdrs(cdrsNumber/4);
                fourthCdrs = createLocationCdrs(cdrsNumber/4);
                break;
            case 0:
                System.exit(-1);
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
    private static Properties getCorrectProperties() {
        Properties properties = new Properties();
        try (FileInputStream propertyFile = new FileInputStream("./src/resources/cdr.properties")){
            properties.load(propertyFile);
        } catch (IOException e){
            throw new RuntimeException("Нет проперти файла, стек - " + e);
        }
        return properties;
    }

    private static int getMessageCode(){
        System.out.println("Введите какого типа cdr-ы нужны, где");
        System.out.println("1 - только FixedCalls");
        System.out.println("2 - только MobileCalls");
        System.out.println("3 - только Sms");
        System.out.println("4 - только Location");
        System.out.println("5 - FixedCalls и MobileCalls");
        System.out.println("6 - FixedCalls и Sms");
        System.out.println("7 - FixedCalls и Location");
        System.out.println("8 - MobileCalls и Sms");
        System.out.println("9 - MobileCalls и Location");
        System.out.println("10 - Sms и Location");
        System.out.println("11 - FixedCalls, MobileCalls и Sms");
        System.out.println("12 - FixedCalls, MobileCalls и Location");
        System.out.println("13 - MobileCalls, Sms и Location");
        System.out.println("14 - Все типы вызовов");
        System.out.println("0 - Выход");
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    private static int getCdrsNumber(){
        System.out.println("Введите количество вызовов, генеримых каждым потоком");
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    private static List<String> createFixedCallsCdrs(int cdrsNumber){
        ArrayList<String> cdrs = new ArrayList<>();
        for (int i = 0; i < cdrsNumber; i++) {
            cdrs.add(new FixedCallCdr(getCorrectProperties()).createMessageCdr());
        }
        return cdrs;
    }

    private static List<String> createMobileCallsCdrs(int cdrsNumber){
        ArrayList<String> cdrs = new ArrayList<>();
        for (int i = 0; i < cdrsNumber; i++) {
            cdrs.add(new MobileCallCdr(getCorrectProperties()).createMessageCdr());
        }
        return cdrs;
    }

    private static List<String> createSmsCdrs(int cdrsNumber){
        ArrayList<String> cdrs = new ArrayList<>();
        for (int i = 0; i < cdrsNumber; i++) {
//            cdrs.add(new SmsCdr(getCorrectProperties()).createMessageCdr());
        }
        return cdrs;
    }

    private static List<String> createLocationCdrs(int cdrsNumber){
        ArrayList<String> cdrs = new ArrayList<>();
        for (int i = 0; i < cdrsNumber; i++) {
            cdrs.add(new LocationCdr(getCorrectProperties()).createMessageCdr());
        }
        return cdrs;
    }
}