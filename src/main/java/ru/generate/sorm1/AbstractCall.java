package ru.generate.sorm1;

/**
 * Created by kosarim on 5/3/17.
 */
public abstract class AbstractCall extends AllCommunications{

    public String criteriaType = "24";
    public String callType = "0";
    public String suppServicePhase = "";
    public String cgpnType = "";
    public String cdpnType = "";
    public String trunkNum = "50";
    public String tslA = "1";
    public String tslB = "1";
    public String priority = "2";
    public String operationCode = "5";
    public String serviceCode = "4294967295";
    public String serviceDescr = "4294967295";
    public String serviceAddCode = "4294967295";
    public String addCode = "-1";

    public String code;
    public String pnBSignCount;
    public String cdpn;
}
