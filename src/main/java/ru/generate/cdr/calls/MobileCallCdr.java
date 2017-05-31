package ru.generate.cdr.calls;

import java.util.Arrays;
import java.util.List;
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
        return getMobileFields().stream()
                .map(field -> field == null ? field = "" : field)
                .collect(Collectors.joining(";"));
    }

    protected List<String> getMobileFields() {
        List<String> cdrFields = getBasicCdrFields();
        cdrFields.set(12, getPnASignCount());
        cdrFields.set(13, getCgpn());
        return getAllCdrFields(cdrFields);
    }

    private String getPnASignCount() {
        return pnASignCount;
    }

    private String getCgpn() {
        return cgpn;
    }
}
