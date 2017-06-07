package ru.generate.cdr;

import java.util.List;

/**
 * Created by kosarim on 5/16/17.
 */
public interface ICdr {

    int CDR_LENGTH = 37 + 1;

    String createCdr(List<String> cdrFields, String code);

    String createMessageCdr();
}
