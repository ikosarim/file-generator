package ru.generate.cdr.calls;

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
    public String createCdr(String code) {
        return getMobileFields(code).stream()
                .map(field -> field == null ? field = "" : field)
                .collect(Collectors.joining(";"));
    }

    @Override
    public String createMessageCdr() {
        return createCdr("65") +
                "\n" +
                createCdr("66") +
                "\n" +
                createCdr("68") +
                "\n" +
                createCdr("67");
    }

    protected List<String> getMobileFields(String code) {
        List<String> cdrFields = getBasicCdrFields();
        cdrFields.set(3, code);
        cdrFields.set(12, getPnASignCount());
        cdrFields.set(13, getCgpn());
        return cdrFields;
    }

    private String getPnASignCount() {
        return pnASignCount;
    }

    private String getCgpn() {
        return cgpn;
    }
}
