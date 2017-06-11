package ru.generate.command;

import ru.generate.cdr.calls.FixedCallCdr;
import ru.generate.operation.ConsoleHelper;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Properties;

import static ru.generate.operation.ConsoleHelper.*;

/**
 * @author kosarim
 */
public class GenerateFixCdrCommand implements Command {

    @Override
    public void execute(Properties properties) throws Exception {
        int count = askCount();
        if (count == 0) {
            System.out.println("Выходим в меню");
            return;
        }
        long startTime = System.currentTimeMillis();
        ConsoleHelper.writeMessage("Генерация cdr фиксированной связи");

        System.out.println("\n-------------------------");

        LocalDateTime now = LocalDateTime.now();

        String filePath = properties.getProperty("path","../")
                + "fixed_calls__" + now.format(formatter) + ".cdr";

        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath, true))) {
            for (int i = 0; i < count; i++) {
                writer.write(new FixedCallCdr(properties).createMessageCdr());
                if (i % (count / 25) == 0) {
                    System.out.print(ANSI_BLUE + "#" + ANSI_RESET);
                }
            }
        }
        System.out.println("\n-------------------------");
        long stopTime = System.currentTimeMillis();
        System.out.println("Total time spent: " + (stopTime - startTime) + " ms");
    }
}
