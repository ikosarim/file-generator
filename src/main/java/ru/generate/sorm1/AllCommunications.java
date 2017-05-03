package ru.generate.sorm1;

import java.util.Calendar;

/**
 * Created by kosarim on 5/3/17.
 */
public abstract class AllCommunications {
    Calendar calendar = Calendar.getInstance();

    public Long timestamp = System.currentTimeMillis();
    public String systemId = "3";
    public String liId = "1";
    public String objectType = "1";
    public String timeDay = Integer.toString(calendar.get(Calendar.DAY_OF_MONTH));
    public String timeHour = Integer.toString(calendar.get(Calendar.HOUR_OF_DAY));
    public String timeMinute = Integer.toString(calendar.get(Calendar.MINUTE));
    public String timeSecond = Integer.toString(calendar.get(Calendar.SECOND));

    public String callId;
    public String dataSrcObjNum;

}
