package com.erep.elucs.cmd;

import com.erep.elucs.jpa.service.ErepUserService;
import com.erep.elucs.model.json.profile.UserProfile;
import org.apache.commons.cli.CommandLine;
import org.pircbotx.PircBotX;
import org.pircbotx.hooks.events.MessageEvent;

/**
 * @author dragos
 */
public class ProfileInfoCmd extends ErepNickProfileAbstractCmd {
    public static final String CMD_PREFIX = "lp";
    public static final String CMD_DESC = "Displays eRepublik basic profile information";

    public ProfileInfoCmd(PircBotX botX, ErepUserService erepUserService) {
        this(botX, erepUserService, CMD_PREFIX, CMD_DESC);
    }

    public ProfileInfoCmd(PircBotX botX, ErepUserService erepUserService, String cmdPrefix, String cmdDesc) {
        super(botX, erepUserService, cmdPrefix, cmdDesc);
    }


    public void displayInfoByNick(MessageEvent event, String nick, CommandLine commandLine) {
        String profileId = resolveProfileValue(nick);
        if (profileId != null) {
            displayInfoByProfile(event, profileId, commandLine);
        } else {
            sendError(event, nick + " is not registered, please use help to see how to register!");
        }
    }

    public void displayInfoByProfile(MessageEvent event, String profileId, CommandLine commandLine) {
        UserProfile userProfile = getErepublikDataExtractor().getUserProfile(profileId);
        if (userProfile != null) {
            sendMessage(event, createProfileMessage(userProfile));
        } else {
            sendError(event, "Could not retrieve user information for profileId = " + profileId);
        }
    }

    public String createProfileMessage(UserProfile userProfile) {
        return userProfile.toBasicInfo();
    }

}
