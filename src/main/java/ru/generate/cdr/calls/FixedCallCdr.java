package ru.generate.cdr.calls;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.Random;

/**
 * Created by kosarim on 5/3/17.
 */
public class FixedCallCdr extends BasicCallCdrFields {

    //    11FSP
    private String pnASignCount = "11";
    //    12FSP
    private String cgpn;

    public FixedCallCdr(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String createCdr() throws IOException {
        Properties properties = new Properties();
        properties.load(Files.newInputStream(Paths.get("src/resources/cdr.properties")));
        int perc = Integer.parseInt(properties.getProperty("percent"));
        Random random = new Random();
        boolean msgCode70 = false;
        if (random.nextInt(100) > perc){
            msgCode70 = true;
        }
        String[] cdrFields;
        for (int i = 0; i < 4; i++) {
            cdrFields = createCdrLine();
            if (i == 1){
                cdrFields[3] = "66";
            } else if (i == 2 && msgCode70){
                cdrFields[3] = "70";
            } else if (i == 3 && msgCode70){
                cdrFields[3] = "67";
            } else if (i == 3 && !msgCode70){
                break;
            }

        }

        return null;
    }

    @Override
    public String[] createCdrLine() throws IOException {
        String[] cdrFields = getBasicCallCdrFields();
        cdrFields[11] = getPnASignCount();
        cdrFields[12] = getCgpn();
        cdrFields[cdrFields.length + 1] = "\n";
        return cdrFields;
//        return Arrays.stream(cdrFields)
//                .map(field -> field == null ? field = "" : field)
//                .collect(Collectors.joining(";"));
    }

    private String getPnASignCount() {
        return pnASignCount;
    }

    private String getCgpn() {
        return cgpn;
    }
}
