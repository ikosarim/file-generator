package ru.generate.command;

/**
 * @author kosarim
 */
public interface Command {
    void execute(int callsNumber) throws Exception;
}
