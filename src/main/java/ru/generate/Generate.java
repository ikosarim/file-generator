package ru.generate;

import ru.generate.operation.CommandExecutor;
import ru.generate.operation.ConsoleHelper;
import ru.generate.operation.Operation;

import java.io.IOException;

import static ru.generate.WorkWithFileAndConsole.getCdrsNumber;
import static ru.generate.WorkWithFileAndConsole.getCorrectProperties;

/**
 * Created by rocky-po on 04.05.17.
 */
public class Generate {

    public static void main(String[] args) throws IOException {
        int callsNumber = getCdrsNumber();
        String path = getCorrectProperties().getProperty("path");

        Operation operation = null;
        do {
            try {
                operation = askOperation();
                CommandExecutor.execute(operation, callsNumber);
            } catch (Exception e) {
                ConsoleHelper.writeMessage("Файла по заданному пути нет - " + e);
            }
        } while (operation != Operation.EXIT);
    }

    public static Operation askOperation() throws IOException {
        ConsoleHelper.writeMessage("");
        ConsoleHelper.writeMessage("Выберите операцию:");
        ConsoleHelper.writeMessage(String.format("\t %d - упаковать файлы в архив", Operation.FIXED_CDR.ordinal()));
        ConsoleHelper.writeMessage(String.format("\t %d - добавить файл в архив", Operation.MOBILE_CDR.ordinal()));
        ConsoleHelper.writeMessage(String.format("\t %d - удалить файл из архива", Operation.SMS_CDR.ordinal()));
        ConsoleHelper.writeMessage(String.format("\t %d - распаковать архив", Operation.LOCATION_CDR.ordinal()));
        ConsoleHelper.writeMessage(String.format("\t %d - выход", Operation.EXIT.ordinal()));

        return Operation.values()[ConsoleHelper.readInt()];
    }

}