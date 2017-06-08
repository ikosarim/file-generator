package ru.generate.cdr.calls;

import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

/**
 * Created by kosarim on 5/3/17.
 */
public class MobileCallCdr extends BasicCallCdrFields {

    //    12MSP
    private String mobilePnASignCount = "4";
    //    13MSP
    private String mobileCgpn = "1";

    public MobileCallCdr(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String createCdr(List<String> cdrFields, String code) {
        cdrFields.set(3, code);
        return cdrFields.stream()
                .map(field -> field == null ? field = "" : field)
                .collect(Collectors.joining(";"));
    }

    @Override
    public String createMessageCdr() {
        List<String> cdrFields= getMobileFields();
        return createCdr(cdrFields, "65") +
                "\n" +
                createCdr(cdrFields, "66") +
                "\n" +
                createCdr(cdrFields, "68") +
                "\n" +
                createCdr(cdrFields, "67");
    }

    protected List<String> getMobileFields() {
        List<String> cdrFields = getCallCdrFields();
        cdrFields.add(29, "");
        cdrFields.add(30, "");
        cdrFields.add(31, "");
        cdrFields.add(32, "");
        cdrFields.add(33, "");
        cdrFields.add(34, "");
        cdrFields.add(35, "");
        cdrFields.set(3, getCode());
        cdrFields.set(12, getMobilePnASignCount());
        cdrFields.set(13, getMobileCgpn());
        return cdrFields;
    }

    private String getMobilePnASignCount() {
        return generateCdrField("mobile_pn_a_sign_count", mobilePnASignCount);
    }

    private String getMobileCgpn() {
        return generateCdrField("mobile_cgpn", mobileCgpn);
    }
}
