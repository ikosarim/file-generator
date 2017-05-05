package ru.generate.sorm1;

/**
 * Created by kosarim on 5/3/17.
 */
public abstract class AbstractCall extends AllCommunications {

    //    4FSP    4MSP
    public String code;
    //    8F    8M
    public String criteriaType = "24";
    //    9F    9M
    public String callType = "0";
    //    10F   10M
    public String suppServicePhase = "";
    //    11FSP  11MSP
    public String cgpnType = "";
    //    14FSP   14MSP
    public String cdpnType = "";
    //    15FSP   15MSP
    public String pnBsignCount;
    //    16FSP   16MSP
    public String cdpn;
    //    17F   17M
    public String trunkNum = "50";
    //    18F   18M
    public String tslA = "1";
    //    19F   19M
    public String tslB = "1";
    //    24F   24M
    public String priority = "2";
    //    25F   25M
    public String operationCode = "5";
    //    26F   26M
    public String serviceCode = "4294967295";
    //    27F   27M
    public String serviceDescr = "4294967295";
    //    28F   28M
    public String serviceAddCode = "4294967295";
    //    29F   29M
    public String addCode = "-1";


}
