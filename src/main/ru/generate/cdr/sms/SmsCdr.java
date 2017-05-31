package ru.generate.cdr.sms;

import ru.generate.cdr.BasicCdrFields;
import java.util.List;
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

    private List<String> getSmsCdrFields(String messageNumber) {
        List<String> cdrFields = getBasicCdrFields();
        cdrFields.add(4, getCode());
        cdrFields.add(6, messageNumber);
        cdrFields.add(7, getMessagesTotal());
        cdrFields.add(10, getpNType());
        cdrFields.add(11, getObjectPNQuantity());
        cdrFields.add(12, getObjectPN());
        cdrFields.add(13, getSendParams());
        cdrFields.add(14, getUndeliveryCode());
        cdrFields.add(19, getRecvPNType());
        cdrFields.add(20, getRecvObjectPNQuantity());
        cdrFields.add(21, getRecvObjectPN());
        cdrFields.add(22, getSmsMessage());
        return cdrFields;
    }

    @Override
    public String createCdr(String messageNumber) {
        return getSmsCdrFields(messageNumber).stream()
                .map(field -> field == null ? field = "" : field)
                .collect(Collectors.joining(";"));
    }

    @Override
    public String createMessageCdr() {
        StringBuilder messageBuilder = new StringBuilder();
        for (int i = 0; i < Integer.parseInt(getMessagesTotal()); i++) {
            messageBuilder.append(createCdr(String.valueOf(i + 1))).append("\n");
        }
        return messageBuilder.toString();
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
