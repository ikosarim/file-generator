package ru.generate.cdr.calls;

import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;
import java.util.stream.Collectors;

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
        String[] cdrFields = getBasicCallCdrFields();
        cdrFields[11] = getPnASignCount();
        cdrFields[12] = getCgpn();
        String[] cdrFields66 = cdrFields.clone();
        cdrFields66[3] = "66";
        String[] cdrFields68 = cdrFields.clone();
        cdrFields68[3] = "68";
        String[] cdrFields67 = cdrFields.clone();
        cdrFields67[3] = "67";
        String[] finalCdrFields = new String[cdrFields.length + 1 + cdrFields66.length + 1 + cdrFields68.length + 1
                + cdrFields67.length + 1];
        for (int i = 0; i < finalCdrFields.length; i++) {
            finalCdrFields[i] = cdrFields[i];
            finalCdrFields[cdrFields.length + 1 + i] = cdrFields66[i];
            finalCdrFields[cdrFields.length + 1 + cdrFields66.length + 1 + i] = cdrFields68[i];
            finalCdrFields[cdrFields.length + 1 + cdrFields66.length + 1 + cdrFields68.length + 1 + i] = cdrFields67[i];
        }
        finalCdrFields[cdrFields.length + 1] = finalCdrFields[cdrFields.length + 1 + cdrFields66.length + 1] =
                finalCdrFields[cdrFields.length + 1 + cdrFields66.length + 1 + cdrFields68.length + 1] =
                        finalCdrFields[cdrFields.length + 1 + cdrFields66.length + 1 + cdrFields68.length + 1 + cdrFields67.length + 1] =
                                "\n";
        return Arrays.stream(finalCdrFields)
                .map(field -> field == null ? field = "" : field)
                .collect(Collectors.joining(";"));
    }

    private String getPnASignCount() {
        return pnASignCount;
    }

    private String getCgpn() {
        return cgpn;
    }
}
