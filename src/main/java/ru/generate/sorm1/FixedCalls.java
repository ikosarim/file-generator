package ru.generate.sorm1;

/**
 * Created by kosarim on 5/3/17.
 */
public class FixedCalls extends AbstractCall implements iCdr {

    //    11FSP
    public String pnASignCount = "11";
    //    12FSP
    public String cgpn;

    @Override
    public String toString() {
        return timestamp + ";" + systemId + ";" + liId + ";" + code + ";" + objectType + ";" +
                dataSrcObjNum + ";" + criteriaType + ";" + callType + ";" + suppServicePhase + ";" +
                cgpnType + ";" + pnASignCount + ";" + cgpn + ";" + cdpnType + ";" + pnBSignCount + ";" +
                cdpn + ";" + trunkNum + ";" + tslA + ";" + tslB + ";" + timeDay + ";" + timeHour + ";" +
                timeMinute + ";" + timeSecond + ";" + priority + ";" + operationCode + ";" +
                serviceCode + ";" + serviceDescr + ";" + serviceAddCode + ";" + addCode + ";" + "\n";
    }


    @Override
    public String createCallMessage() {
        StringBuilder fixCallMessage = new StringBuilder();
        for (int i = 0; i < Integer.parseInt(this.code); i++) {
            fixCallMessage.append(this.toString());
            if (Integer.parseInt(this.code) == 66){
                this.code = "70";
            } else if (Integer.parseInt(this.code) == 70){
                this.code = "67";
            } else {
                this.code = String.valueOf(Integer.parseInt(this.code) + 1);
            }
        }
        return fixCallMessage.toString();
    }
}
