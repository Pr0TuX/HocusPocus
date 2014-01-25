package com.erep.elucs.cmd;

import com.erep.elucs.jpa.service.ErepUserService;
import com.erep.elucs.model.json.profile.UserProfile;
import org.pircbotx.PircBotX;

/**
 * @author dragos
 */
public class TopInfoCmd extends ProfileInfoCmd {
    public TopInfoCmd(PircBotX botX, ErepUserService erepUserService) {
        super(botX, erepUserService, "top", "Displays information about top damage given by selected user.");
    }

    @Override
    public String createProfileMessage(UserProfile userProfile) {
        return userProfile.toTopInfo();
    }
}
