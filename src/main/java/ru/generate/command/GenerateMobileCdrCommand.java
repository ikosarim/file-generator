package ru.generate.command;

import ru.generate.cdr.calls.MobileCallCdr;
import ru.generate.operation.ConsoleHelper;

import java.util.ArrayList;

import static ru.generate.WorkWithFileAndConsole.getCorrectProperties;
import static ru.generate.WorkWithFileAndConsole.writeCdrsToFile;

/**
 * @author kosarim
 */
public class GenerateMobileCdrCommand implements Command {
    @Override
    public void execute(int callsNumber) throws Exception {
        ConsoleHelper.writeMessage("Генерация cdr фиксированной связи");
        MobileCallCdr mobileCallCdr = new MobileCallCdr(getCorrectProperties());
        String fileName = "mobile_calls__" + mobileCallCdr.timeYear + mobileCallCdr.timeMonth + mobileCallCdr.timeDay +
                mobileCallCdr.timeHour + mobileCallCdr.timeMinute + "_t" + mobileCallCdr.timeMinute + ".cdr";
        ArrayList<String> cdrs = new ArrayList<>();
        for (int callNumber = 0; callNumber < callsNumber; callNumber++) {
            cdrs.add(new MobileCallCdr(getCorrectProperties()).createMessageCdr());
        }
        writeCdrsToFile(getCorrectProperties().getProperty("path"), fileName, cdrs);
    }
}
