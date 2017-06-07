package ru.generate.cdr.calls;

import ru.generate.cdr.BasicCdrFields;

import java.util.List;

/**
 * Created by kosarim on 5/3/17.
 */
public abstract class BasicCallCdrFields extends BasicCdrFields {

    //    3FSP    4MSP
    private String code = "65";
    //    7F    8M
    private String criteriaType = "24";
    //    8F    9M
    private String callType = "0";
    //    9F   10M
    private String suppServicePhase = "1";
    //    10FSP  11MSP
    private String cgpnType = "1";
    //    11FSP   14MSP
    private String cdpnType = "1";
    //    14FSP   15MSP
    private String pnBSignCount = "1";
    //    15FSP   16MSP
    private String cdpn = "1";
    //    16F   17M
    private String trunkNum = "50";
    //    17F   18M
    private String tslA = "1";
    //    18F   19M
    private String tslB = "1";
    //    23F   24M
    private String priority = "2";
    //    24F   25M
    private String operationCode = "5";
    //    25F   26M
    private String serviceCode = "4294967295";
    //    26F   27M
    private String serviceDescr = "4294967295";
    //    27F   28M
    private String serviceAddCode = "4294967295";
    //    28F   29M
    private String addCode = "0";

    private String callContentType = "1";

    List<String> getCallCdrFields(){
        List<String> cdrFields = getBasicCdrFields();
        cdrFields.set(3, getCode());
        cdrFields.set(7, getCriteriaType());
        cdrFields.set(8, getCallType());
        cdrFields.set(9, getSuppServicePhase());
        cdrFields.set(10, getCgpnType());
        cdrFields.set(11, getCdpnType());
        cdrFields.set(14, getPnBSignCount());
        cdrFields.set(15, getCdpn());
        cdrFields.set(16, getTrunkNum());
        cdrFields.set(17, getTslA());
        cdrFields.set(18, getTslB());
        cdrFields.add(23, getPriority());
        cdrFields.add(24, getOperationCode());
        cdrFields.add(25, getServiceCode());
        cdrFields.add(26, getServiceDescr());
        cdrFields.add(27, getServiceAddCode());
        cdrFields.add(28, getAddCode());
        cdrFields.add(29, getCallContentType());
        System.out.println(cdrFields);
        return cdrFields;
    }

    String getCode() {
        return generateCdrField("code", code);
    }

    private String getCriteriaType() {
        return generateCdrField("criteria_type", criteriaType);
    }

    private String getCallType() {
        return generateCdrField("call_type", callType);
    }

    private String getSuppServicePhase() {
        return generateCdrField("supp_service_phase", suppServicePhase);
    }

    private String getCgpnType() {
        return generateCdrField("cgpn_type", cgpnType);
    }

    private String getCdpnType() {
        return generateCdrField("cdpn_type", cdpnType);
    }

    private String getPnBSignCount() {
        return generateCdrField("pn_b_sign_count", pnBSignCount);
    }

    private String getCdpn() {
        return generateCdrField("cdpn", cdpn);
    }

    private String getTrunkNum() {
        return generateCdrField("trunk_num", trunkNum);
    }

    private String getTslA() {
        return generateCdrField("tsl_a", tslA);
    }

    private String getTslB() {
        return generateCdrField("tsl_b", tslB);
    }

    private String getPriority() {
        return generateCdrField("priority", priority);
    }

    private String getOperationCode() {
        return generateCdrField("operation_code", operationCode);
    }

    private String getServiceCode() {
        return generateCdrField("service_code", serviceCode);
    }

    private String getServiceDescr() {
        return generateCdrField("service_descr", serviceDescr);
    }

    private String getServiceAddCode() {
        return generateCdrField("service_add_code", serviceAddCode);
    }

    private String getAddCode() {
        return generateCdrField("add_code", addCode);
    }

    private String getCallContentType(){
        return generateCdrField("call_content_type", callContentType);
    }
}
