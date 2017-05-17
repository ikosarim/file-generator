package ru.generate.sorm1;

import java.util.Calendar;

/**
 * Created by kosarim on 5/3/17.
 */
public abstract class AllCommunications {

    //    0F    1M      1S
    public String timestamp = Long.toString(System.currentTimeMillis());
    //    1F    2M      2S
    public String systemId = "3";
    //    2F    3M      3S
    public String liId = "1";
    //    4FSP    5MSP      5SSp
    public String callId;
    //    5F    6M      8S
    public String objectType = "1";
    //    6FSP    7MSP      9SSP
    public String dataSrcObjNum;
    //    19F   20M     15S
    public String timeDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH) >= 10 ?
            Integer.toString(Calendar.getInstance().get(Calendar.DAY_OF_MONTH)) :
            "0" + Integer.toString(Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
    //    20F   21M     16S
    public String timeHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY) >= 10 ?
            Integer.toString(Calendar.getInstance().get(Calendar.HOUR_OF_DAY)) :
            "0" + Integer.toString(Calendar.getInstance().get(Calendar.HOUR_OF_DAY));
    //    21F   22M     17S
    public String timeMinute = Calendar.getInstance().get(Calendar.MINUTE) >= 10 ?
            Integer.toString(Calendar.getInstance().get(Calendar.MINUTE)) :
            "0" + Integer.toString(Calendar.getInstance().get(Calendar.MINUTE));
    //    22F   23M     18S
    public String timeSecond = Calendar.getInstance().get(Calendar.SECOND) >= 10 ?
            Integer.toString(Calendar.getInstance().get(Calendar.SECOND)) :
            "0" + Integer.toString(Calendar.getInstance().get(Calendar.SECOND));
}
