package ru.generate.cdr.location;

import ru.generate.cdr.calls.MobileCallCdr;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

/**
 * Created by kosarim on 5/3/17.
 */
public class LocationCdr extends MobileCallCdr {

    //    30M
    private String mcc;
    //    31M
    private String mnc;
    //    32M
    private String lac;
    //    33M
    private String cl;
    //    34M
    private String mobileIdType;
    //    35M
    private String mobileTypeSignCount;
    //    36M
    private String mobileId;

    public LocationCdr(Properties properties) {
        super(properties);
    }

    @Override
    public String createCdr(List<String> cdrFields, String code) {
        cdrFields.set(3, code);
        return cdrFields.stream()
                .map(field -> field == null ? field = "" : field)
                .collect(Collectors.joining(";"));
    }

    private List<String> getLocationFields() {
        List<String> cdrFields = getMobileFields();
        cdrFields.set(29, getMcc());
        cdrFields.set(30, getMnc());
        cdrFields.set(31, getLac());
        cdrFields.set(32, getCl());
        cdrFields.set(33, getMobileIdType());
        cdrFields.set(34, getMobileTypeSignCount());
        cdrFields.set(35, getMobileId());
        return cdrFields;
    }

    @Override
    public String createMessageCdr() {
        List<String> cdrFields = getLocationFields();
        return createCdr(cdrFields, "65") +
                "\n" +
                createCdr(cdrFields, "66") +
                "\n" +
                createCdr(cdrFields, "68") +
                "\n" +
                createCdr(cdrFields, "67");
    }

    private String getMcc() {
        return generateCdrField("mcc", mcc);
    }

    private String getMnc() {
        return generateCdrField("mnc", mnc);
    }

    private String getLac() {
        return generateCdrField("lac", lac);
    }

    private String getCl() {
        return generateCdrField("cl", cl);
    }

    private String getMobileIdType() {
        return generateCdrField("mobile_id_type", mobileIdType);
    }

    private String getMobileTypeSignCount() {
        return generateCdrField("mobile_type_sign_count", mobileTypeSignCount);
    }

    private String getMobileId() {
        return generateCdrField("mobile_id", mobileId);
    }
}
