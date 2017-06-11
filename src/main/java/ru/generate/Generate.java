package ru.generate;

import ru.generate.operation.CommandExecutor;
import ru.generate.operation.ConsoleHelper;
import ru.generate.operation.Operation;

import java.io.IOException;
import java.util.Properties;

import static ru.generate.operation.ConsoleHelper.readInt;

/**
 * Created by rocky-po on 04.05.17.
 */
public class Generate {

    public static void main(String[] args) throws IOException {
        Properties properties = ConsoleHelper.getCorrectProperties();
        Operation operation = null;
        do {
            try {
                operation = askOperation();
                CommandExecutor.execute(operation, properties);
            } catch (Exception e) {
                ConsoleHelper.writeMessage("Неудачка " + e);
            }
        } while (operation != Operation.EXIT);
    }

    private static Operation askOperation() throws IOException {
        ConsoleHelper.writeMessage("");
        ConsoleHelper.writeMessage("Выберите операцию:");
        ConsoleHelper.writeMessage(String.format("\t %d - сгенерить фиксу", Operation.FIXED_CDR.ordinal()));
        ConsoleHelper.writeMessage(String.format("\t %d - сгенерить мобилу", Operation.MOBILE_CDR.ordinal()));
        ConsoleHelper.writeMessage(String.format("\t %d - сгенерить смс", Operation.SMS_CDR.ordinal()));
        ConsoleHelper.writeMessage(String.format("\t %d - сгенерить местоположение", Operation.LOCATION_CDR.ordinal()));
        ConsoleHelper.writeMessage(String.format("\t %d - выход", Operation.EXIT.ordinal()));
        int operationNumber = readInt();
        if (operationNumber <= 0 || operationNumber >= Operation.values().length) {
            System.out.println("Нет такой команды!");
            askOperation();
        }
        return Operation.values()[operationNumber];
    }

}