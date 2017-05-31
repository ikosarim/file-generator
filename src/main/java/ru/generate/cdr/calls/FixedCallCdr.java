package ru.generate.cdr.calls;

import java.util.Arrays;
import java.util.List;
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
        return getAllCdrFields(getFixedFields()).stream()
                .map(field -> field == null ? field = "" : field)
                .collect(Collectors.joining(";"));
    }

    private List<String> getFixedFields() {
        List<String> cdrFields = getBasicCdrFields();
        cdrFields.set(11, getPnASignCount());
        cdrFields.set(12, getCgpn());
        return getAllCdrFields(cdrFields);
    }

    private String getPnASignCount() {
        return pnASignCount;
    }

    private String getCgpn() {
        return cgpn;
    }
}
