package ru.generate.cdr;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import static org.apache.commons.lang.math.NumberUtils.toInt;

/**
 * Created by kosarim on 5/3/17.
 */
public abstract class BasicCdrFields implements ICdr {

    protected Properties properties;
    //    0F    1M      1S
    private String timestamp = "1497206217502-1497206248502";
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
    //    ***
    private String timeYear = "2017";
    //    ***
    private String timeMonth = "2313";
    //    19F   20M     15S
    private String timeDay = "1444";
    //    20F   21M     16S
    private String timeHour = "1233";
    //    21F   22M     17S
    private String timeMinute = "44343";
    //    22F   23M     18S
    private String timeSecond = "1111";

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

    protected String generateCdrField(String propertyName, String fieldValue) {
        String cdrField = properties.getProperty(propertyName, fieldValue);
        return createRandomValue(cdrField);
    }

    private String generateDataSrcField(String propertyName, String fieldValue) {
        String cdrField = properties.getProperty(propertyName, fieldValue)
                .replaceAll("\\(", "")
                .replaceAll("\\)", "");

        return createRandomValue(cdrField);
    }

    private String createRandomValue(String possibleFieldValues) {
        String[] boundaryValues = possibleFieldValues.split("-");

        if (boundaryValues.length > 1) {
            int max = toInt(boundaryValues[1]);
            int min = toInt(boundaryValues[0]);
            return generateRandomValue(min, max);
        }
        return possibleFieldValues;
    }

    private String generateRandomValue(int min, int max) {
        int randomFromRange = new Random().nextInt((max - min) + 1) + min;
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
