package com.erep.elucs.cmd;

import com.erep.elucs.util.Util;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;
import org.pircbotx.PircBotX;
import org.pircbotx.hooks.events.MessageEvent;

import java.util.List;

/**
 * @author dragos
 */
public class HelpCmd extends AbstractCmd {

    private final List<AbstractCmd> availableCommands;

    public HelpCmd(PircBotX botX, List<AbstractCmd> availableCommands) {
        super(botX, "help", "<help_command>   Displays help about all commands");
        this.availableCommands = availableCommands;
    }

    @Override
    public void doLogic(CommandLine commandLine, MessageEvent event) {
        List argList = commandLine.getArgList();
        if (argList != null && argList.size() > 1) {
            Object arg = argList.get(1);
            if (arg != null) {
                AbstractCmd command = getCommand(availableCommands, arg);
                if (command != null) {
                    String[] helpLines = command.getHelpLines();
                    if (helpLines != null) {
                        for (String line : helpLines) {
                            getBotX().sendNotice(event.getUser(), line);
                        }
                    } else {
                        getBotX().sendNotice(event.getUser(), command.getUsage());
                    }
                } else {
                    getBotX().sendNotice(event.getUser(), "No help available for command : " + arg);
                }
            }
        } else {
            for (AbstractCmd cmd : availableCommands) {
                getBotX().sendNotice(event.getUser(), Util.toBold(":: Command ") + cmd.getUsage());
            }
        }
    }

    private AbstractCmd getCommand(List<AbstractCmd> availableCommands, Object arg) {
        if (arg instanceof String) {
            for (AbstractCmd cmd : availableCommands) {
                if (cmd.getCmdName().equals(arg)) {
                    return cmd;
                }
            }
        }
        return null;
    }

    @Override
    protected Options getCmdOptions() {
        return new Options();
    }
}
