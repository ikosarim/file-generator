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
    public String createCdr(String code) {
        return getLocationFields(code).stream()
                .map(field -> field == null ? field = "" : field)
                .collect(Collectors.joining(";"));
    }

    private List<String> getLocationFields(String code) {
        List<String> cdrFields = getMobileFields(code);
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
        return createCdr("65") +
                "\n" +
                createCdr("66") +
                "\n" +
                createCdr("68") +
                "\n" +
                createCdr("67");
    }

    private String getMcc() {
        return mcc;
    }

    private String getMnc() {
        return mnc;
    }

    private String getLac() {
        return lac;
    }

    private String getCl() {
        return cl;
    }

    private String getMobileIdType() {
        return mobileIdType;
    }

    private String getMobileTypeSignCount() {
        return mobileTypeSignCount;
    }

    private String getMobileId() {
        return mobileId;
    }
}
