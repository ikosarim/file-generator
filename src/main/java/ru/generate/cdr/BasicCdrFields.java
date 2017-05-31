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
        cdrFields.set(0, getTimestamp());
        cdrFields.set(1, getSystemId());
        cdrFields.set(2, getLiId());
        cdrFields.set(4, getCallId());
        cdrFields.set(5, getObjectType());
        cdrFields.set(6, getDataSrcObjNum());
        cdrFields.set(19, getTimeDay());
        cdrFields.set(20, getTimeHour());
        cdrFields.set(21, getTimeMinute());
        cdrFields.set(22, getTimeSecond());
        return cdrFields;
    }

    protected List<String> getAllCdrFields(List<String> cdrFields){
        List<String> finalCdrFields = new ArrayList<>();
        for (int i = 0; i < (cdrFields.size() + 1); i++) {
            if (i != 3) {
                finalCdrFields.set(i, cdrFields.get(i));
                finalCdrFields.set(cdrFields.size() + 1 + i, cdrFields.get(i));
                finalCdrFields.set(2 * (cdrFields.size() + 1) + i, cdrFields.get(i));
                finalCdrFields.set(3 * (cdrFields.size() + 1) + i, cdrFields.get(i));
            } else {
                finalCdrFields.set(i, "65");
                finalCdrFields.set(cdrFields.size() + 1 + i, "66");
                finalCdrFields.set(2 * (cdrFields.size() + 1) + i, "68");
                finalCdrFields.set(3 * (cdrFields.size() + 1) + i, "67");
            }
        }
        finalCdrFields.set(cdrFields.size() + 1, "\n");
        finalCdrFields.set(2*(cdrFields.size() + 1), "\n");
        finalCdrFields.set(3*(cdrFields.size() + 1), "\n");
        finalCdrFields.set(4*(cdrFields.size() + 1), "\n");
        return finalCdrFields;
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
