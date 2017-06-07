package ru.generate.cdr.calls;

import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

/**
 * Created by kosarim on 5/3/17.
 */
public class FixedCallCdr extends BasicCallCdrFields {

    //    11FSP
    private String fixPnASignCount = "11";
    //    12FSP
    private String fixCgpn;

    public FixedCallCdr(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String createMessageCdr(){
        List<String> cdrFields = getFixedFields();
        return createCdr(cdrFields, "65") +
                "\n" +
                createCdr(cdrFields, "66") +
                "\n" +
                createCdr(cdrFields, "68") +
                "\n" +
                createCdr(cdrFields, "67");
    }

    @Override
    public String createCdr(List<String> cdrFields, String code) {
        cdrFields.set(3, code);
            return cdrFields.stream()
                    .map(field -> field == null ? field = "" : field)
                    .collect(Collectors.joining(";"));
    }

    private List<String> getFixedFields() {
        List<String> cdrFields = getCallCdrFields();
        cdrFields.set(3, getCode());
        cdrFields.set(11, getFixPnASignCount());
        cdrFields.set(12, getFixCgpn());
        return cdrFields;
    }

    private String getFixPnASignCount() {
        return generateCdrField("fix_pn_a_sign_count", fixPnASignCount);
    }

    private String getFixCgpn() {
        return generateCdrField("fix_cgpn", fixCgpn);
    }
}
