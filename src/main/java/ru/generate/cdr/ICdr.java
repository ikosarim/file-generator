package ru.generate.cdr;

import java.io.IOException;

/**
 * Created by kosarim on 5/16/17.
 */
public interface ICdr {

    int CDR_LENGTH = 37;

    String createCdr() throws IOException;

}
