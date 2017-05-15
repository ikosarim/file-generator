package ru.generate.sorm1;

import org.junit.Test;

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
        Field[] fields = this.getClass().getDeclaredFields();
        Field[] superFields = this.getClass().getSuperclass().getDeclaredFields();
        StringBuilder textBuilder = new StringBuilder();
        addStringFragment(textBuilder, 0, 3, superFields, this);
        addStringFragment(textBuilder, 0, 1, fields, this);
        addStringFragment(textBuilder, 3, 4, superFields, this);
        addStringFragment(textBuilder, 1, 3, fields, this);
        addStringFragment(textBuilder, 4, 6, superFields, this);
        addStringFragment(textBuilder, 3, 8, fields, this);
        addStringFragment(textBuilder, 6, 100, superFields, this);
        addStringFragment(textBuilder, 8, 100, fields, this);
        return textBuilder.toString();
    }

    private StringBuilder addStringFragment(StringBuilder textBuilder, int startCount, int stopCount, Field[] fields, Object obj) throws IllegalAccessException {
        int count = 0;
        for (Field field : fields) {
            ++count;
            if (count > startCount) {
                field.setAccessible(true);
                textBuilder.append(field.get((SmsSorm1) obj)).append(";");
            } else if (count > stopCount) {
                break;
            }
        }
        return textBuilder;
    }

    @Test
    public void test(){
        
    }


}
