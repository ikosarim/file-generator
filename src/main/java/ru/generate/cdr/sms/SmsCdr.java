package ru.generate.cdr.sms;

import ru.generate.cdr.BasicCdrFields;

import java.util.Arrays;
import java.util.Properties;
import java.util.stream.Collectors;

/**
 * Created by kosarim on 5/3/17.
 */
public class SmsCdr extends BasicCdrFields {

    //    4S
    private String code = "65";
    //    6SSP
    private String messageNumber;
    //    7SSP
    private String messagesTotal;
    //    10S
    private String pNType = "1";
    //    11SSP
    private String objectPNQuantity;
    //    12SSP
    private String objectPN;
    //    13S
    private String sendParams = "255";
    //    14S
    private String undeliveryCode = "255";
    //    19SSP
    private String recvPNType;
    //    20SSP
    private String recvObjectPNQuantity;
    //    21SSP
    private String recvObjectPN;
    //    22SSP
    private String smsMessage;

    public SmsCdr(Properties properties) {
        this.properties = properties;
    }

    private String[] getSmsCdrFields() {
        String[] cdrFields = getBasicCdrFields();
        cdrFields[4] = getCode();
        cdrFields[6] = getMessageNumber();
        cdrFields[7] = getMessagesTotal();
        cdrFields[10] = getpNType();
        cdrFields[11] = getObjectPNQuantity();
        cdrFields[12] = getObjectPN();
        cdrFields[13] = getSendParams();
        cdrFields[14] = getUndeliveryCode();
        cdrFields[19] = getRecvPNType();
        cdrFields[20] = getRecvObjectPNQuantity();
        cdrFields[21] = getRecvObjectPN();
        cdrFields[22] = getSmsMessage();
        return cdrFields;
    }

    @Override
    public String createCdr() {

        return Arrays.stream(getSmsCdrFields())
                .map(field -> field == null ? field = "" : field)
                .collect(Collectors.joining(";"));
    }

    private String getCode() {
        return code;
    }

    private String getMessageNumber() {
        return messageNumber;
    }

    private String getMessagesTotal() {
        return messagesTotal;
    }

    private String getpNType() {
        return pNType;
    }

    private String getObjectPNQuantity() {
        return objectPNQuantity;
    }

    private String getObjectPN() {
        return objectPN;
    }

    private String getSendParams() {
        return sendParams;
    }

    private String getUndeliveryCode() {
        return undeliveryCode;
    }

    private String getRecvPNType() {
        return recvPNType;
    }

    private String getRecvObjectPNQuantity() {
        return recvObjectPNQuantity;
    }

    private String getRecvObjectPN() {
        return recvObjectPN;
    }

    private String getSmsMessage() {
        return smsMessage;
    }
}
