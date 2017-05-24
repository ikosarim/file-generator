package ru.generate.cdr.location;

import ru.generate.cdr.calls.MobileCallCdr;

import java.util.Arrays;
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
    public String createCdr() {
     String[] cdrFields = getMobileFields();
     cdrFields[30] = getMcc();
     cdrFields[31] = getMnc();
     cdrFields[32] = getLac();
     cdrFields[33] = getCl();
     cdrFields[34] = getMobileIdType();
     cdrFields[35] = getMobileTypeSignCount();
     cdrFields[36] = getMobileId();
     return Arrays.stream(cdrFields)
             .map(field -> field == null ? field = "" : field)
             .collect(Collectors.joining(";"));
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
