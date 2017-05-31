package java.ru.generate.cdr;

/**
 * Created by kosarim on 5/16/17.
 */
public interface ICdr {

    int CDR_LENGTH = 37 + 1;

    String createCdr(String code);

    String createMessageCdr();
}
