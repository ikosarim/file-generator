package ru.generate.gen;

import ru.generate.sorm1.AllCommunications;
import ru.generate.sorm1.FixedCalls;
import ru.generate.sorm1.MobileCalls;
import ru.generate.sorm1.SmsSorm1;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

/**
 * Created by rocky-po on 04.05.17.
 */
public class MainGen {

    public static void main(String[] args) throws IOException {
        SmsSorm1 fixedCalls = new SmsSorm1();
        MainGen gen = new MainGen();
        String dirPath = gen.createDir();
        String fileName = gen.createFileName(fixedCalls, "cdr");
        gen.createFile(dirPath, fileName);
    }

    private String createDir() {
        String dirPath = "/home/kosarim/cdrArchive/";
        File pathToDir = new File(dirPath);
        pathToDir.mkdirs();
        return dirPath;
    }

    private String createFileName(Object obj, String format) {
        Calendar calendar = Calendar.getInstance();
        StringBuilder fileName = new StringBuilder();
        String year = Integer.toString(calendar.get(Calendar.YEAR));
        String month = (calendar.get(Calendar.MONTH) + 1 >= 10)
                ? Integer.toString(calendar.get(Calendar.MONTH))
                : "0" + Integer.toString(calendar.get(Calendar.MONTH));
        String day = ((AllCommunications) obj).timeDay;
        String hour = ((AllCommunications) obj).timeHour;
        String minute = ((AllCommunications) obj).timeMinute;
        if (obj instanceof FixedCalls) {
            fileName.append("fixed_calls_");
        } else if (obj instanceof MobileCalls) {
            fileName.append("mobile_calls_");
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

    private void addInFile(){

    }
}
