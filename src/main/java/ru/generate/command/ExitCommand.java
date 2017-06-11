package ru.generate.command;

import ru.generate.operation.ConsoleHelper;

import java.util.Properties;

/**
 * @author kosarim
 */
public class ExitCommand implements Command {

    @Override
    public void execute(Properties properties) throws Exception {
        ConsoleHelper.writeMessage("До встречи!");
    }

}
