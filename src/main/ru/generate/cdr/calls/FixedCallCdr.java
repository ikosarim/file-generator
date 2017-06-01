package ru.generate.cdr.calls;

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
    public String createMessageCdr(){
        return createCdr("65") +
                "\n" +
                createCdr("66") +
                "\n" +
                createCdr("68") +
                "\n" +
                createCdr("67");
    }

    @Override
    public String createCdr(String code) {
        return getFixedFields(code).stream()
                .map(field -> field == null ? field = "" : field)
                .collect(Collectors.joining(";"));
    }

    private List<String> getFixedFields(String code) {
        List<String> cdrFields = getCallCdrFields();
        cdrFields.set(3, code);
        cdrFields.set(11, getPnASignCount());
        cdrFields.set(12, getCgpn());
        return cdrFields;
    }

    private String getPnASignCount() {
        return pnASignCount;
    }

    private String getCgpn() {
        return cgpn;
    }
}
