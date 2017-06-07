package ru.generate.cdr.command;

import ru.generate.cdr.ConsoleHelper;

/**
 * @author kosarim
 */
public class ExitCommand implements Command {
    @Override
    public void execute() throws Exception {
        ConsoleHelper.writeMessage("До встречи!");
    }
}
