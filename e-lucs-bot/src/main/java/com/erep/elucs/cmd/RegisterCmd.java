package com.erep.elucs.cmd;

import com.erep.elucs.jpa.domain.ErepUser;
import com.erep.elucs.jpa.service.ErepUserService;
import com.erep.elucs.util.Util;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;
import org.pircbotx.PircBotX;
import org.pircbotx.hooks.events.MessageEvent;

import java.util.List;

/**
 * @author dragos
 */
public class RegisterCmd extends AbstractCmd {

    private final ErepUserService erepUserService;

    public RegisterCmd(PircBotX botX, ErepUserService erepUserService) {
        super(botX, "reg", "<profile_id> Registers eRepublik user and links him to irc nickname.");
        this.erepUserService = erepUserService;
    }

    @Override
    public void doLogic(CommandLine commandLine, MessageEvent event) {
        List argList = commandLine.getArgList();
        if (argList != null && argList.size() > 1) {
            Object arg = argList.get(1);
            if (arg instanceof String) {
                String stringProfile = (String) arg;
                Integer integer = Util.toInt(stringProfile);
                if (integer != null) {
                    ErepUser erepUser = new ErepUser();
                    String nick = event.getUser().getNick();
                    erepUser.setNick(nick);
                    erepUser.setProfileId(stringProfile);
                    erepUserService.addUser(erepUser);
                    sendMessage(event, nick + " you are now registerd to link : " + Util.getErepLink(stringProfile));
                } else {
                    sendError(event, "Invalid profile_id given as parameter.");
                }
            }
        } else {
            sendUsage(event);
        }
    }

    @Override
    protected Options getCmdOptions() {
        return new Options();
    }
}
