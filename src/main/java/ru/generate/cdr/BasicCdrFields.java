package ru.generate.cdr;

import java.util.*;

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
    private String callId = "1";
    //    5F    6M      8S
    private String objectType = "1";
    //    6FSP    7MSP      9SSP
    private String dataSrcObjNum = "(1)";
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
        System.out.println(cdrFields);
        return cdrFields;
    }

    protected String generateCdrField(String propertyName, String fieldValue){
        String cdrField = properties.getProperty(propertyName, fieldValue);
        String[] boundaryValues = cdrField.split("-");
        if (boundaryValues.length > 1){
            return getRandomValue(boundaryValues);
        }
        return cdrField;
    }

    protected String generateDataSrcField(String propertyName, String fieldValue){
        String cdrField = properties.getProperty(propertyName, fieldValue)
                .replaceAll("\\(", "")
                .replaceAll("\\)", "");
        String[] boundaryValues = cdrField.split("-");
        if (boundaryValues.length > 1){
            return "(" + getRandomValue(boundaryValues) + ")";
        }
        return "(" + cdrField + ")";
    }

    private String getRandomValue(String[] values){
        Random random = new Random();
        int max = Integer.parseInt(values[1]);
        int min = Integer.parseInt(values[0]);
        int randomFromRange = random.nextInt((max - min) + 1) + min;
        return String.valueOf(randomFromRange);
    }

    private String getTimestamp() {
        return generateCdrField("timestamp", timestamp);
    }

    private String getSystemId() {
        return generateCdrField("system_id", systemId);
    }

    private String getLiId() {
        return generateCdrField("li_id", liId);
    }

    private String getCallId() {
        return generateCdrField("call_id", callId);
    }

    private String getObjectType() {
        return generateCdrField("object_type", objectType);
    }

    private String getDataSrcObjNum() {
        return generateDataSrcField("data_src_obj_num", dataSrcObjNum);
    }

    private String getTimeDay() {
        return generateCdrField("time_day", timeDay);
    }

    private String getTimeHour() {
        return generateCdrField("time_hour", timeHour);
    }

    private String getTimeMinute() {
        return generateCdrField("time_minute", timeMinute);
    }

    private String getTimeSecond() {
        return generateCdrField("time_second", timeSecond);
    }
}
