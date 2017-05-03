package ru.generate.gen;

import ru.generate.sorm1.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Calendar;

/**
 * Created by rocky-po on 04.05.17.
 */
public class MainGen {

    public static void main(String[] args) throws IOException {
        FixedCalls fixedCalls = new FixedCalls();
        MainGen gen = new MainGen();
        String dirPath = gen.createDir();
        String fileName = gen.createFileName(fixedCalls, "cdr");
        gen.createFile(dirPath, fileName);
        gen.addInFile(fixedCalls, fileName, dirPath);
    }

    private String createDir() {
        String dirPath = "/home/rocky-po/cdrArchive";
        File pathToDir = new File(dirPath);
        pathToDir.mkdirs();
        return dirPath;
    }

    private String createFileName(Object obj, String format) {
        Calendar calendar = Calendar.getInstance();
        StringBuilder fileName = new StringBuilder();
        String year = Integer.toString(calendar.get(Calendar.YEAR));
        String month = (calendar.get(Calendar.MONTH) + 1 >= 10) ?
                Integer.toString(calendar.get(Calendar.MONTH))
                : "0" + Integer.toString(calendar.get(Calendar.MONTH));
        String day = ((AllCommunications) obj).timeDay;
        String hour = ((AllCommunications) obj).timeHour;
        String minute = ((AllCommunications) obj).timeMinute;
        if (obj instanceof FixedCalls) {
            fileName.append("fixed_calls_");
        } else if (obj instanceof MobileCalls) {
            fileName.append("mobile_calls");
        } else if (obj instanceof SmsSorm1) {
            fileName.append("sms_sorm1_");
        }
        return fileName.append(year)
                .append(month)
                .append(day)
                .append("_")
                .append(hour)
                .append(minute)
                .append("_")
                .append(minute)
                .append(".")
                .append(format)
                .toString();
    }

    private void createFile(String dirPath, String fileName) throws IOException {
        File file = new File(dirPath + fileName);
        if (!file.exists()) {
            file.createNewFile();
        }
    }

    private void addInFile(Object obj, String fileName, String dirPath) {
        Class clazz = obj.getClass().getSuperclass();
        if (obj instanceof FixedCalls
                || obj instanceof MobileCalls) {
            for (int i = 0; i < 4; i++) {
                ((AbstractCall) obj).code = "65";
                writeLine(clazz, dirPath, fileName, obj, i);
                if (Integer.parseInt(((AbstractCall) obj).code) == 66) {
                    ((AbstractCall) obj).code = "70";
                } else if (Integer.parseInt(((AbstractCall) obj).code) == 70) {
                    ((AbstractCall) obj).code = "67";
                } else {
                    ((AbstractCall) obj).code =
                            Integer.toString(Integer.parseInt(((AbstractCall) obj).code) + 1);
                }
            }
        } else if (obj instanceof SmsSorm1) {
            ((SmsSorm1) obj).messageNumber = "1";
            for (int i = 0; i < Integer.parseInt(((SmsSorm1) obj).messagesTotal); i++) {
                writeLine(clazz, dirPath, fileName, obj, i);
                Integer.toString(Integer.parseInt(((SmsSorm1) obj).messageNumber) + 1 );
            }
        }
    }

    private void writeLine(Class clazz, String dirPath, String fileName, Object obj, int i){
        Field[] fields = clazz.getDeclaredFields();
        try (FileOutputStream fos = new FileOutputStream(dirPath + fileName)) {
            for ( Field field : fields ) {
                field.setAccessible(true);
                String text = field.get(obj) + ";";
                byte[] buffer = text.getBytes();
                fos.write(buffer);
            }
            fos.write("\n".getBytes());
        } catch (IOException | IllegalAccessException e) {
            i--;
        }
    }
}
