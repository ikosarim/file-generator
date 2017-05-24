package ru.generate.cdr.calls;

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
    public String createCdr() {
        String[] cdrFields = getBasicCallCdrFields();
        cdrFields[11] = getPnASignCount();
        cdrFields[12] = getCgpn();
        return Arrays.stream(cdrFields)
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
