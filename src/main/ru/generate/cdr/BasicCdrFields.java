package ru.generate.cdr;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;

/**
 * Created by kosarim on 5/3/17.
 */
public abstract class BasicCdrFields implements ICdr {

    protected Properties properties;
    //    0F    1M      1S
    private String timestamp = Long.toString(System.currentTimeMillis());
    //    1F    2M      2S
    private String systemId = "3";
    //    2F    3M      3S
    private String liId = "1";
    //    4FSP    5MSP      5SSp
    private String callId;
    //    5F    6M      8S
    private String objectType = "1";
    //    6FSP    7MSP      9SSP
    private String dataSrcObjNum;
    //    19F   20M     15S
    private String timeDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH) >= 10 ?
            Integer.toString(Calendar.getInstance().get(Calendar.DAY_OF_MONTH))
            : "0" + Integer.toString(Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
    //    20F   21M     16S
    private String timeHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY) >= 10 ?
            Integer.toString(Calendar.getInstance().get(Calendar.HOUR_OF_DAY))
            : "0" + Integer.toString(Calendar.getInstance().get(Calendar.HOUR_OF_DAY));
    //    21F   22M     17S
    private String timeMinute = Calendar.getInstance().get(Calendar.MINUTE) >= 10 ?
            Integer.toString(Calendar.getInstance().get(Calendar.MINUTE))
            : "0" + Integer.toString(Calendar.getInstance().get(Calendar.MINUTE));
    //    22F   23M     18S
    private String timeSecond = Calendar.getInstance().get(Calendar.SECOND) >= 10 ?
            Integer.toString(Calendar.getInstance().get(Calendar.SECOND))
            : "0" + Integer.toString(Calendar.getInstance().get(Calendar.SECOND));

    protected List<String> getBasicCdrFields() {
        List<String> cdrFields = new ArrayList<>();
        cdrFields.add(0, getTimestamp());
        cdrFields.add(1, getSystemId());
        cdrFields.add(2, getLiId());
        cdrFields.add(3, "");
        cdrFields.add(4, getCallId());
        cdrFields.add(5, getObjectType());
        cdrFields.add(6, getDataSrcObjNum());
        cdrFields.add(7, "");
        cdrFields.add(8, "");
        cdrFields.add(9, "");
        cdrFields.add(10, "");
        cdrFields.add(11, "");
        cdrFields.add(12, "");
        cdrFields.add(13, "");
        cdrFields.add(14, "");
        cdrFields.add(15, "");
        cdrFields.add(16, "");
        cdrFields.add(17, "");
        cdrFields.add(18, "");
        cdrFields.add(19, getTimeDay());
        cdrFields.add(20, getTimeHour());
        cdrFields.add(21, getTimeMinute());
        cdrFields.add(22, getTimeSecond());
        return cdrFields;
    }

    public Properties getProperties() {
        return properties;
    }

    private String getTimestamp() {
        return timestamp;
    }

    private String getSystemId() {
        return systemId;
    }

    private String getLiId() {
        return liId;
    }

    private String getCallId() {
        return callId;
    }

    private String getObjectType() {
        return objectType;
    }

    private String getDataSrcObjNum() {
        return dataSrcObjNum;
    }

    private String getTimeDay() {
        return timeDay;
    }

    private String getTimeHour() {
        return timeHour;
    }

    private String getTimeMinute() {
        return timeMinute;
    }

    private String getTimeSecond() {
        return timeSecond;
    }
}
