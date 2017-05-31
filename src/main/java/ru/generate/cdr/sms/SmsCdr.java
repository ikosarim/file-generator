package ru.generate.cdr.sms;

import ru.generate.cdr.BasicCdrFields;

import java.util.ArrayList;
import java.util.Arrays;
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

    private List<String> getSmsCdrFields() {
        List<String> cdrFields = getBasicCdrFields();
        cdrFields.set(4, getCode());
        cdrFields.set(6, getMessageNumber());
        cdrFields.set(7, getMessagesTotal());
        cdrFields.set(10, getpNType());
        cdrFields.set(11, getObjectPNQuantity());
        cdrFields.set(12, getObjectPN());
        cdrFields.set(13, getSendParams());
        cdrFields.set(14, getUndeliveryCode());
        cdrFields.set(19, getRecvPNType());
        cdrFields.set(20, getRecvObjectPNQuantity());
        cdrFields.set(21, getRecvObjectPN());
        cdrFields.set(22, getSmsMessage());
        return getAllCdrFields(cdrFields);
    }

    @Override
    protected List<String> getAllCdrFields(List<String> cdrFields){
        List<String> finalCdrFields = new ArrayList<>();
        for (int i = 0; i < Integer.parseInt(cdrFields.get(7)); i++) {
            for (int j = 0; j < cdrFields.size() + 1; j++) {
                finalCdrFields.set(i*(cdrFields.size() + 1) + j, cdrFields.get(j));
            }
            finalCdrFields.set(i*(cdrFields.size() + 1) + 6, String.valueOf(i + 1));
            finalCdrFields.set((i + 1)*(cdrFields.size() + 1), "\n");
        }
        return finalCdrFields;
    }

    @Override
    public String createCdr() {
        return getSmsCdrFields().stream()
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
