package com.erep.elucs.cmd;

import com.erep.elucs.jpa.service.ErepUserService;
import com.erep.elucs.model.json.profile.UserProfile;
import org.pircbotx.PircBotX;

/**
 * @author dragos
 */
public class PartyInfoCmd extends ProfileInfoCmd {
    public PartyInfoCmd(PircBotX botX, ErepUserService erepUserService) {
        super(botX, erepUserService, "party", "Displays information of party that is user is part of.");
    }

    @Override
    public String createProfileMessage(UserProfile userProfile) {
        return userProfile.toPartyInfo();
    }
}
