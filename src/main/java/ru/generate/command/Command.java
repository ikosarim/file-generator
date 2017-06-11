package ru.generate.command;

import java.util.Properties;

/**
 * @author kosarim
 */
public interface Command {

    void execute(Properties properties) throws Exception;

}
