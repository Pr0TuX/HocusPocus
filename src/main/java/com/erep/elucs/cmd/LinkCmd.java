package com.erep.elucs.cmd;

import com.erep.elucs.jpa.service.ErepUserService;
import com.erep.elucs.model.json.profile.UserProfile;
import com.erep.elucs.util.Util;
import org.apache.commons.cli.CommandLine;
import org.pircbotx.PircBotX;
import org.pircbotx.hooks.events.MessageEvent;

/**
 * @author dragos
 */
public class LinkCmd extends ProfileInfoCmd {


    public LinkCmd(PircBotX botX, ErepUserService erepUserService) {
        super(botX, erepUserService, "link", "Displays users profile link.");
    }

    @Override
    public void displayInfoByProfile(MessageEvent event, String profileId, CommandLine commandLine) {
        if (commandLine.hasOption(PROFILE_OPT)) {
            UserProfile userProfile = getErepublikDataExtractor().getUserProfile(profileId);
            sendMessage(event, createProfileMessage(userProfile));
        } else {
            super.displayInfoByProfile(event, profileId, commandLine);
        }
    }

    @Override
    public String createProfileMessage(UserProfile userProfile) {
        return Util.toBold(userProfile.getName()) + " :: " + Util.getErepLink(userProfile.getId());
    }
}
