package ru.generate.cdr;

import java.util.Calendar;
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

    protected String[] getBasicCdrFields() {
        String[] cdrFields = new String[CDR_LENGTH];
        cdrFields[0] = getTimestamp();
        cdrFields[1] = getSystemId();
        cdrFields[2] = getLiId();
        cdrFields[4] = getCallId();
        cdrFields[5] = getObjectType();
        cdrFields[6] = getDataSrcObjNum();
        cdrFields[19] = getTimeDay();
        cdrFields[20] = getTimeHour();
        cdrFields[21] = getTimeMinute();
        cdrFields[22] = getTimeSecond();
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
