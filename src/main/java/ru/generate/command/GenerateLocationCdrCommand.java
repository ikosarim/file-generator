package ru.generate.command;

import ru.generate.cdr.location.LocationCdr;
import ru.generate.cdr.sms.SmsCdr;
import ru.generate.operation.ConsoleHelper;

import java.util.ArrayList;

import static ru.generate.Generate.getCorrectProperties;
import static ru.generate.Generate.writeCdrsToFile;

/**
 * @author kosarim
 */
public class GenerateLocationCdrCommand implements Command {
    @Override
    public void execute(int callsNumber) throws Exception {
        ConsoleHelper.writeMessage("Генерация cdr фиксированной связи");
        LocationCdr locationCdr = new LocationCdr(getCorrectProperties());
        String fileName = "mobile_calls__" + locationCdr.timeYear + locationCdr.timeMonth + locationCdr.timeDay +
                locationCdr.timeHour + locationCdr.timeMinute + "_t" + locationCdr.timeMinute + ".cdr";
        ArrayList<String> cdrs = new ArrayList<>();
        for (int callNumber = 0; callNumber < callsNumber; callNumber++) {
            cdrs.add(new SmsCdr(getCorrectProperties()).createMessageCdr());
        }
        writeCdrsToFile(getCorrectProperties().getProperty("path"), fileName, cdrs);
    }
}
