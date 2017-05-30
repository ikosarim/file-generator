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
        String[] cdrFields66 = cdrFields.clone();
        cdrFields66[3] = "66";
        String[] cdrFields68 = cdrFields.clone();
        cdrFields68[3] = "68";
        String[] cdrFields67 = cdrFields.clone();
        cdrFields67[3] = "67";
        String[] finalCdrFields = new String[cdrFields.length + 1 + cdrFields66.length + 1 + cdrFields68.length + 1
                + cdrFields67.length + 1];
        for (int i = 0; i < finalCdrFields.length; i++) {
            finalCdrFields[i] = cdrFields[i];
            finalCdrFields[cdrFields.length + 1 + i] = cdrFields66[i];
            finalCdrFields[cdrFields.length + 1 + cdrFields66.length + 1 + i] = cdrFields68[i];
            finalCdrFields[cdrFields.length + 1 + cdrFields66.length + 1 + cdrFields68.length + 1 + i] = cdrFields67[i];
        }
        finalCdrFields[cdrFields.length + 1] = finalCdrFields[cdrFields.length + 1 + cdrFields66.length + 1] =
                finalCdrFields[cdrFields.length + 1 + cdrFields66.length + 1 + cdrFields68.length + 1] =
                        finalCdrFields[cdrFields.length + 1 + cdrFields66.length + 1 + cdrFields68.length + 1 + cdrFields67.length + 1] =
                                "\n";
        return Arrays.stream(finalCdrFields)
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
