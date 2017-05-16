package ru.generate.sorm1;

/**
 * Created by kosarim on 5/3/17.
 */
public class FixedCalls extends AbstractCall {

    //    11FSP
    public String pnASignCount = "11";
    //    12FSP
    public String cgpn;
    
    @Override
    public String toString() {
        return timestamp + systemId + liId + code + objectType + dataSrcObjNum + criteriaType + callType +
                suppServicePhase + cgpnType + pnASignCount + cgpn + cdpnType + pnBsignCount + cdpn +
                trunkNum + tslA + tslB + timeDay + timeHour + timeMinute + timeSecond + priority +
                operationCode + serviceCode + serviceDescr + serviceAddCode + addCode;
    }

}
