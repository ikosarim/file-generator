package ru.generate.sorm1;

/**
 * Created by kosarim on 5/3/17.
 */
public abstract class AbstractCall extends AllCommunications {

    //    3FSP    4MSP
    public String code;
    //    7F    8M
    public String criteriaType = "24";
    //    8F    9M
    public String callType = "0";
    //    9F   10M
    public String suppServicePhase = "";
    //    10FSP  11MSP
    public String cgpnType = "";
    //    11FSP   14MSP
    public String cdpnType = "";
    //    14FSP   15MSP
    public String pnBSignCount;
    //    15FSP   16MSP
    public String cdpn;
    //    16F   17M
    public String trunkNum = "50";
    //    17F   18M
    public String tslA = "1";
    //    18F   19M
    public String tslB = "1";
    //    23F   24M
    public String priority = "2";
    //    24F   25M
    public String operationCode = "5";
    //    25F   26M
    public String serviceCode = "4294967295";
    //    26F   27M
    public String serviceDescr = "4294967295";
    //    27F   28M
    public String serviceAddCode = "4294967295";
    //    28F   29M
    public String addCode = "-1";


}
