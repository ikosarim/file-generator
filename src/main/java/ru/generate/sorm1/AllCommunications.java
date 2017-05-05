package ru.generate.sorm1;

import java.util.Calendar;

/**
 * Created by kosarim on 5/3/17.
 */
public abstract class AllCommunications {

    public String timestamp = Long.toString(System.currentTimeMillis());
    public String systemId = "3";
    public String liId = "1";
    public String objectType = "1";

    public String timeDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH) >= 10 ?
            Integer.toString(Calendar.getInstance().get(Calendar.DAY_OF_MONTH))
            : "0" + Integer.toString(Calendar.getInstance().get(Calendar.DAY_OF_MONTH));

    public String timeHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY) >= 10 ?
            Integer.toString(Calendar.getInstance().get(Calendar.HOUR_OF_DAY))
            : "0" + Integer.toString(Calendar.getInstance().get(Calendar.HOUR_OF_DAY));

    public String timeMinute = Calendar.getInstance().get(Calendar.MINUTE) >= 10 ?
            Integer.toString(Calendar.getInstance().get(Calendar.MINUTE))
            : "0" + Integer.toString(Calendar.getInstance().get(Calendar.MINUTE));

    public String timeSecond = Calendar.getInstance().get(Calendar.SECOND) >= 10 ?
            Integer.toString(Calendar.getInstance().get(Calendar.SECOND))
            : "0" + Integer.toString(Calendar.getInstance().get(Calendar.SECOND));

    public String callId;
    public String dataSrcObjNum;

}
