package ru.generate.cdr.calls;

import java.util.Arrays;
import java.util.Properties;
import java.util.stream.Collectors;

/**
 * Created by kosarim on 5/3/17.
 */
public class MobileCallCdr extends BasicCallCdrFields {

    //    12MSP
    private String pnASignCount = "4";
    //    13MSP
    private String cgpn;

    public MobileCallCdr(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String createCdr() {
        return Arrays.stream(getMobileFields())
                .map(field -> field == null ? field = "" : field)
                .collect(Collectors.joining(";"));
    }

    protected String[] getMobileFields() {
        String[] cdrFields = getBasicCallCdrFields();
        cdrFields[12] = getPnASignCount();
        cdrFields[13] = getCgpn();
        return cdrFields;
    }

    private String getPnASignCount() {
        return pnASignCount;
    }

    private String getCgpn() {
        return cgpn;
    }
}
