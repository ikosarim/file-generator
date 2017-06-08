package ru.generate.command;

import ru.generate.cdr.sms.SmsCdr;
import ru.generate.operation.ConsoleHelper;

import java.util.ArrayList;

import static ru.generate.Generate.getCorrectProperties;
import static ru.generate.Generate.writeCdrsToFile;

/**
 * @author kosarim
 */
public class GenerateSmsCdrCommand implements Command {
    @Override
    public void execute(int callsNumber) throws Exception {
        ConsoleHelper.writeMessage("Генерация cdr фиксированной связи");
        SmsCdr smsCdr = new SmsCdr(getCorrectProperties());
        String fileName = "mobile_calls__" + smsCdr.timeYear + smsCdr.timeMonth + smsCdr.timeDay +
                smsCdr.timeHour + smsCdr.timeMinute + "_t" + smsCdr.timeMinute + ".cdr";
        ArrayList<String> cdrs = new ArrayList<>();
        for (int callNumber = 0; callNumber < callsNumber; callNumber++) {
            cdrs.add(new SmsCdr(getCorrectProperties()).createMessageCdr());
        }
        writeCdrsToFile(getCorrectProperties().getProperty("path"), fileName, cdrs);
    }
}
