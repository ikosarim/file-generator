package ru.generate.sorm1;

/**
 * Created by kosarim on 5/3/17.
 */
public class LocationCalls extends MobileCalls implements iCdr{

    //    Здесь все заполнять из Spring
//    30M
    public String mcc;
    //    31M
    public String mnc;
    //    32M
    public String lac;
    //    33M
    public String cl;
    //    34M
    public String mobileIdType;
    //    35M
    public String mobileTypeSignCount;
    //    36M
    public String mobileId;

    @Override
    public String toString() {
        return timestamp + systemId + liId + code + objectType + dataSrcObjNum + criteriaType + callType +
                suppServicePhase + cgpnType + pnASignCount + cgpn + cdpnType + pnBsignCount + cdpn +
                trunkNum + tslA + tslB + timeDay + timeHour + timeMinute + timeSecond + priority +
                operationCode + serviceCode + serviceDescr + serviceAddCode + addCode +
                mcc + mnc + lac + cl + mobileIdType + mobileTypeSignCount + mobileId;
    }
}
