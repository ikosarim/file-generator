package ru.generate.sorm1;

import java.util.Calendar;

/**
 * Created by kosarim on 5/3/17.
 */
public abstract class AllCommunications {
    Calendar calendar = Calendar.getInstance();

    public String timestamp = Long.toString(System.currentTimeMillis());
    public String systemId = "3";
    public String liId = "1";
    public String objectType = "1";

    public String timeDay =  calendar.get(Calendar.DAY_OF_MONTH) >= 10 ?
            Integer.toString(calendar.get(Calendar.DAY_OF_MONTH))
            : "0" + Integer.toString(calendar.get(Calendar.DAY_OF_MONTH));

    public String timeHour = calendar.get(Calendar.HOUR_OF_DAY) >= 10 ?
            Integer.toString(calendar.get(Calendar.HOUR_OF_DAY))
            : "0" + Integer.toString(calendar.get(Calendar.HOUR_OF_DAY));

    public String timeMinute = calendar.get(Calendar.MINUTE) >= 10 ?
            Integer.toString(calendar.get(Calendar.MINUTE))
            : "0" + Integer.toString(calendar.get(Calendar.MINUTE));

    public String timeSecond = calendar.get(Calendar.SECOND) >= 10 ?
            Integer.toString(calendar.get(Calendar.SECOND))
            : "0" + Integer.toString(calendar.get(Calendar.SECOND));

    public String callId;
    public String dataSrcObjNum;

}
