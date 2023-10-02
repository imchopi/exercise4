package com.adrian.exercise4;

import java.io.IOException;

public class Exercise4 {
    public static void main( String[] args ){
        if (args.length < 1) {
            System.out.println("Debes proporcionar un argumento para el comando.");
            System.exit(2);
        }
        
        String arg = "";

        try {
            // We could use too this method
            // ProcessBuilder path = new ProcessBuilder("pwd");

            arg = args[0];
            // Default path
            String userDirCommand =  System.getProperty("user.dir");

            // Block where execute the command ls in our default path
            ProcessBuilder lsCommand = new ProcessBuilder("ls");
            lsCommand.directory(new java.io.File(userDirCommand));
            lsCommand.inheritIO();
            Process lsProcess = lsCommand.start();
            int exitCodeLsProcess = lsProcess.waitFor();
            System.out.println("Exit code from use ls on user.dir: " + exitCodeLsProcess);

            // Block where execute the command ls now in the arg
            lsCommand.directory(new java.io.File(arg));
            lsCommand.inheritIO();
            lsCommand.start();
            System.out.println("Exit code from use ls on other path: " + exitCodeLsProcess);
            

        } catch (IOException e) {
            System.out.println("Command error: " + e.getMessage());

        } catch (InterruptedException e) {
            System.out.println("WaitFor error: " + e.getMessage());
        }

    }
}
