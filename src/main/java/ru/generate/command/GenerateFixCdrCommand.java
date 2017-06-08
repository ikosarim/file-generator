package ru.generate.command;

import ru.generate.cdr.calls.FixedCallCdr;
import ru.generate.operation.ConsoleHelper;

import java.util.ArrayList;

import static ru.generate.WorkWithFileAndConsole.getCorrectProperties;
import static ru.generate.WorkWithFileAndConsole.writeCdrsToFile;

/**
 * @author kosarim
 */
public class GenerateFixCdrCommand implements Command {
    @Override
    public void execute(int callsNumber) throws Exception {
        ConsoleHelper.writeMessage("Генерация cdr фиксированной связи");
        FixedCallCdr fixedCallCdr = new FixedCallCdr(getCorrectProperties());
        String fileName = "fixed_calls__" + fixedCallCdr.timeYear + fixedCallCdr.timeMonth + fixedCallCdr.timeDay +
                fixedCallCdr.timeHour + fixedCallCdr.timeMinute + "_t" + fixedCallCdr.timeMinute + ".cdr";
        ArrayList<String> cdrs = new ArrayList<>();
        for (int callNumber = 0; callNumber < callsNumber; callNumber++) {
            cdrs.add(new FixedCallCdr(getCorrectProperties()).createMessageCdr());
        }
        writeCdrsToFile(getCorrectProperties().getProperty("path"), fileName, cdrs);
    }
}
