package java.ru.generate.cdr.location;

import java.ru.generate.cdr.calls.MobileCallCdr;
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
     return getLocationFields().stream()
             .map(field -> field == null ? field = "" : field)
             .collect(Collectors.joining(";"));
    }

    private List<String> getLocationFields(){
        List<String> cdrFields = getMobileFields();
        cdrFields.set(30, getMcc());
        cdrFields.set(31, getMnc());
        cdrFields.set(32, getLac());
        cdrFields.set(33, getCl());
        cdrFields.set(34, getMobileIdType());
        cdrFields.set(35, getMobileTypeSignCount());
        cdrFields.set(36, getMobileId());
        return cdrFields;
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
