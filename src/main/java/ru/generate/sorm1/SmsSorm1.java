package ru.generate.sorm1;

import java.lang.reflect.Field;

/**
 * Created by kosarim on 5/3/17.
 */
public class SmsSorm1 extends AllCommunications {

    //    4S
    public String code = "65";
    //    6SSP
    public String messageNumber;
    //    7SSP
    public String messagesTotal;
    //    10S
    public String pNType = "1";
    //    11SSP
    public String objectPNQuantity;
    //    12SSP
    public String objectPN;
    //    13S
    public String sendParams = "255";
    //    14S
    public String undeliveryCode = "255";
    //    19SSP
    public String recvPNType;
    //    20SSP
    public String recvObjectPNQuantity;
    //    21SSP
    public String recvObjectPN;
    //    22SSP
    public String smsMessage;

    public String printString() throws IllegalAccessException {
        SmsSorm1 sms = new SmsSorm1();
        Field[] fields = sms.getClass().getDeclaredFields();
        Field[] superFields = sms.getClass().getSuperclass().getDeclaredFields();
        StringBuilder textBuilder = new StringBuilder();
        for (int j = 0; j <= 7; ++j) {
            if (j < 4 || j == 5 || (j > 7 && j < 10) || (j > 14 && j < 19)) {
                int count = 0;
                for (Field superField : superFields) {
                    ++count;
                    if (count > 5) {
                        superField.setAccessible(true);
                        textBuilder.append(superField.get(sms)).append(";");
                    } else if (count > 10) {
                        break;
                    }
                }
            } else if (j == 4) {
                int count = 0;
                for (Field field : fields) {
                    ++count;
                    if (count > 0) {
                        field.setAccessible(true);
                        textBuilder.append(field.get(sms)).append(";");
                    } else if (count > 1) {
                        break;
                    }
                }
            } else if (j == 6 || j == 7) {
                int count = 0;
                for (Field field : fields) {
                    ++count;
                    if (count > 1) {
                        field.setAccessible(true);
                        textBuilder.append(field.get(sms)).append(";");
                    } else if (count > 3) {
                        break;
                    }
                }
            } else if (j >= 10 && j <= 14) {
                int count = 0;
                for (Field field : fields) {
                    ++count;
                    if (count > 3) {
                        field.setAccessible(true);
                        textBuilder.append(field.get(sms)).append(";");
                    } else if (count > 8) {
                        break;
                    }
                }
            } else if (j >= 19 && j <= 22) {
                int count = 0;
                for (Field field : fields) {
                    ++count;
                    if (count > 8) {
                        field.setAccessible(true);
                        textBuilder.append(field.get(sms)).append(";");
                    }
                }
            }
        }
        return textBuilder.toString();
    }

    private StringBuilder addStringFragment(StringBuilder textBuilder, int startCount, int stopCount, Field[] fields, Object obj) throws IllegalAccessException {
        int count = 0;
        for (Field field:fields) {
            ++count;
            if (count > startCount){
                field.setAccessible(true);
                textBuilder.append(field.get((SmsSorm1) obj)).append(";");
            } else if (count > stopCount){
                break;
            }
        }
        return textBuilder;
    }


}
