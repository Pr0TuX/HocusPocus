package com.erep.elucs.cmd;

import com.erep.elucs.jpa.service.ErepUserService;
import com.erep.elucs.model.json.profile.UserProfile;
import org.pircbotx.PircBotX;

/**
 * @author dragos
 */
public class PaperInfoCmd extends ProfileInfoCmd {

    public PaperInfoCmd(PircBotX botX, ErepUserService erepUserService) {
        super(botX, erepUserService, "paper", "Displays information about newspaper.");
    }

    @Override
    public String createProfileMessage(UserProfile userProfile) {
        return userProfile.toPaperInfo();
    }
}
