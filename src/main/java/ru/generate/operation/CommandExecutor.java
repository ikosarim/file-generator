package ru.generate.operation;

import ru.generate.command.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kosarim
 */
public class CommandExecutor {
    private static final Map<Operation, Command> allKnownCommandMap = new HashMap<>();

    static {
        allKnownCommandMap.put(Operation.FIXED_CDR, new GenerateFixCdrCommand());
        allKnownCommandMap.put(Operation.MOBILE_CDR, new GenerateMobileCdrCommand());
        allKnownCommandMap.put(Operation.SMS_CDR, new GenerateSmsCdrCommand());
        allKnownCommandMap.put(Operation.LOCATION_CDR, new GenerateLocationCdrCommand());
        allKnownCommandMap.put(Operation.EXIT, new ExitCommand());
    }

    private CommandExecutor(){
    }

    public static void execute(Operation operation, int callsNumber) throws Exception{
        allKnownCommandMap.get(operation).execute(callsNumber);
    }
}
