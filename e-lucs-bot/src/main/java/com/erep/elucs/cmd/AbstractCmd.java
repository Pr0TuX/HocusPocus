package com.erep.elucs.cmd;

import com.erep.elucs.util.Util;
import org.apache.commons.cli.*;
import org.pircbotx.PircBotX;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

/**
 * @author dragos
 */
public abstract class AbstractCmd {

    private static final String LINE_SEPARATOR = System.getProperty("line.separator");
    public static final int FORMAT_WIDTH = 150;
    private static final Logger LOG = LoggerFactory.getLogger(AbstractCmd.class);

    private final HelpFormatter formatter;
    private String[] helpLines;
    private String helpMessage;
    private String simpleUsage;
    private final String cmdDesc;
    private final String cmdName;
    private final PircBotX botX;
    private String cmdPrefix;


    protected AbstractCmd(PircBotX botX, String cmdName, String cmdDesc) {
        this.botX = botX;
        this.cmdName = cmdName;
        this.cmdDesc = cmdDesc;
        this.formatter = new HelpFormatter();
        this.cmdPrefix = "!";
        initListeners();
    }

    protected void initListeners() {
        botX.getListenerManager().addListener(new ListenerAdapter() {
            @Override
            public void onMessage(MessageEvent event) throws Exception {
                doEventLogic(event);
            }
        });
    }

    public CommandLine parseCommand(MessageEvent event, String cmd) {
        CommandLineParser parser = new PosixParser();
        try {
            return parser.parse(getCmdOptions(), cmd.split(" "));
        } catch (ParseException e) {
            LOG.warn("Some error occurred when parsing command : " + cmd, e);
            sendError(event, e.getMessage());
        }
        return null;
    }

    public void sendUsage(MessageEvent event) {
        botX.sendMessage(event.getChannel(), getUsage());
    }

    public void sendError(MessageEvent event, String error) {
        botX.sendMessage(event.getChannel(), error);
    }

    public void sendMessage(MessageEvent event, String message) {
        botX.sendMessage(event.getChannel(), message);
    }

    public void doEventLogic(MessageEvent event) {
        String cmd = event.getMessage();
        String cmdInput = getCmdInput();
        if (cmd.startsWith(cmdInput)) {
            CommandLine commandLine = parseCommand(event, cmd);
            List argList = commandLine.getArgList();
            if (argList != null && argList.size() >= 1) {
                Object cmdName = argList.get(0);
                if (cmdInput.equals(cmdName)) {
                    doLogic(commandLine, event);
                }
            }
        }
    }

    public String getCmdInput() {
        return cmdPrefix + cmdName;
    }

    public void doLogic(CommandLine commandLine, MessageEvent event) {
        // do nothing
    }


    private void initHelpInfo() {
        StringWriter out = new StringWriter();
        PrintWriter printWriter = new PrintWriter(out);
        formatter.printHelp(printWriter, FORMAT_WIDTH, getCmdName(), getCmdDescription(), getCmdOptions(), 2, 2, null, true);
        helpMessage = out.toString();
        helpLines = helpMessage.split(LINE_SEPARATOR);

        StringWriter simpleWriter = new StringWriter();
        PrintWriter simplePw = new PrintWriter(simpleWriter);
        formatter.printUsage(simplePw, FORMAT_WIDTH, Util.toBold(getCmdInput()), getCmdOptions());
        String simpleMessage = simpleWriter.toString();
        simpleMessage = simpleMessage.replaceAll(LINE_SEPARATOR, "");
        simpleUsage = simpleMessage + " " + getCmdDescription();
    }

    public String[] getHelpLines() {
        if (helpLines == null) {
            initHelpInfo();
        }
        return helpLines;
    }

    public String getHelpMessage() {
        if (helpMessage == null) {
            initHelpInfo();
        }
        return helpMessage;
    }

    public String getUsage() {
        if (simpleUsage == null) {
            initHelpInfo();
        }
        return simpleUsage;
    }

    protected abstract Options getCmdOptions();

    protected String getCmdDescription() {
        return cmdDesc;
    }

    protected String getCmdName() {
        return cmdName;
    }


    public PircBotX getBotX() {
        return botX;
    }

    public String getCmdPrefix() {
        return cmdPrefix;
    }

    public void setCmdPrefix(String cmdPrefix) {
        this.cmdPrefix = cmdPrefix;
    }
}


