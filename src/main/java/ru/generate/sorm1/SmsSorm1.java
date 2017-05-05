package ru.generate.sorm1;

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

}
