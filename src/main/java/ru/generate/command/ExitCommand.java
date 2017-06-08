package ru.generate.command;

import ru.generate.operation.ConsoleHelper;

/**
 * @author kosarim
 */
public class ExitCommand implements Command {
    @Override
    public void execute(int callsNumber) throws Exception {
        ConsoleHelper.writeMessage("До встречи!");
    }
}
