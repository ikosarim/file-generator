package ru.generate.cdr;

import java.util.List;

/**
 * Created by kosarim on 5/16/17.
 */
public interface ICdr {

    String createCdr(List<String> cdrFields, String code);

    String createMessageCdr();

    String generateCdrField(String propertyName, String fieldValue);
}
