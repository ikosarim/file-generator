package ru.generate.cdr.sms;

import ru.generate.cdr.BasicCdrFields;

import java.util.Base64;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by kosarim on 5/3/17.
 */
public class SmsCdr extends BasicCdrFields implements Cloneable {

    //    4S
    private String smsCode = "65";
    //    6SSP
    private String messageNumber = "1";
    //    7SSP
    private String messagesTotal = "3";
    //    10S
    public String pnType = "1";
    //    11SSP
    private String objectPnQuantity = "1";
    //    12SSP
    private String objectPn = "1";
    //    13S
    private String sendParams = "255";
    //    14S
    private String undeliveryCode = "255";
    //    19SSP
    private String recvPnType = "1";
    //    20SSP
    private String recvObjectPnQuantity = "1";
    //    21SSP
    private String recvObjectPn = "1";
    //    22SSP
    private List<String> smsMessage = Collections.singletonList("Привет");

    private List<String> getSmsCdrFields() {
        List<String> cdrFields = getBasicCdrFields();
        cdrFields.set(4, getSmsCode());
        cdrFields.set(6, getMessageNumber());
        cdrFields.set(7, getMessagesTotal());
        cdrFields.set(10, getPnType());
        cdrFields.set(11, getObjectPnQuantity());
        cdrFields.set(12, getObjectPn());
        cdrFields.set(13, getSendParams());
        cdrFields.set(14, getUndeliveryCode());
        cdrFields.set(19, getRecvPnType());
        cdrFields.set(20, getRecvObjectPnQuantity());
        cdrFields.set(21, getRecvObjectPn());
        cdrFields.set(22, getSmsMessage(0));
        return cdrFields;
    }

    @Override
    public String createCdr(List<String> cdrFields, String messageNumber) {
        cdrFields.set(6, messageNumber);
        cdrFields.set(22, getSmsMessage(Integer.parseInt(messageNumber) - 1));
        return cdrFields.stream()
                .map(field -> field == null ? field = "" : field)
                .collect(Collectors.joining(";"));
    }

    @Override
    public String createMessageCdr() {
        StringBuilder messageBuilder = new StringBuilder();
        List<String> cdrFields = getSmsCdrFields();
        for (int i = 0; i < Integer.parseInt(getMessagesTotal()); i++) {
            messageBuilder.append(createCdr(cdrFields, String.valueOf(i + 1)));
            if (i != Integer.parseInt(getMessagesTotal()) - 1) {
                messageBuilder.append("\n");
            }
        }
        return messageBuilder.toString();
    }

    private String getSmsCode() {
        return generateCdrField("sms_code", smsCode);
    }

    private String getMessageNumber() {
        return generateCdrField("message_number", messageNumber);
    }

    private String getMessagesTotal() {
        return generateCdrField("messages_total", messagesTotal);
    }

    private String getPnType() {
        return generateCdrField("pn_type", pnType);
    }

    private String getObjectPnQuantity() {
        return generateCdrField("object_pn_quantity", objectPnQuantity);
    }

    private String getObjectPn() {
        return generateCdrField("object_pn", objectPn);
    }

    private String getSendParams() {
        return generateCdrField("send_params", sendParams);
    }

    private String getUndeliveryCode() {
        return generateCdrField("undelivery_code", undeliveryCode);
    }

    private String getRecvPnType() {
        return generateCdrField("recv_pn_type", recvPnType);
    }

    private String getRecvObjectPnQuantity() {
        return generateCdrField("recv_object_pn_quantity", recvObjectPnQuantity);
    }

    private String getRecvObjectPn() {
        return generateCdrField("recv_object_pn", recvObjectPn);
    }

    private String getSmsMessage(int messageNumber) {
        return Base64.getEncoder()
                .encodeToString(properties.getProperty("sms_message", smsMessage.get(messageNumber)).getBytes());
    }
}
