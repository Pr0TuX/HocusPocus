package com.erep.elucs.cmd;

import com.erep.elucs.jpa.service.ErepUserService;
import com.erep.elucs.model.json.profile.UserProfile;
import org.pircbotx.PircBotX;

/**
 * @author dragos
 */
public class MuInfoCmd extends ProfileInfoCmd {
    public MuInfoCmd(PircBotX botX, ErepUserService erepUserService) {
        super(botX, erepUserService, "mu", "Displays information about military unit that user is part of.");
    }

    @Override
    public String createProfileMessage(UserProfile userProfile) {
        return userProfile.toMUInfo();
    }
}
