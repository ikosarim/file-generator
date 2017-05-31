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
        cdrFields.add(30, getMcc());
        cdrFields.add(31, getMnc());
        cdrFields.add(32, getLac());
        cdrFields.add(33, getCl());
        cdrFields.add(34, getMobileIdType());
        cdrFields.add(35, getMobileTypeSignCount());
        cdrFields.add(36, getMobileId());
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
