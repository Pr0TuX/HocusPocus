package com.erep.elucs.cmd;

import com.erep.elucs.jpa.service.ErepUserService;
import com.erep.elucs.model.json.profile.UserProfile;
import org.pircbotx.PircBotX;

/**
 * @author dragos
 * generic about info command
 */
public class AboutInfoCmd extends ProfileInfoCmd {
    public AboutInfoCmd(PircBotX botX, ErepUserService erepUserService) {
        super(botX, erepUserService, "about", "Displays information about user.");
    }

    @Override
    public String createProfileMessage(UserProfile userProfile) {
        return userProfile.toAboutInfo();
    }
}
