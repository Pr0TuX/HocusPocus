package com.erep.elucs.cmd;

import com.erep.elucs.jpa.service.ErepUserService;
import com.erep.elucs.model.json.profile.UserProfile;
import org.pircbotx.PircBotX;

/**
 * @author dragos
 */
public class MedalsInfoCmd extends ProfileInfoCmd {

    public static final String CMD_PREFIX = "medals";
    public static final String CMD_DESC = "Displays information about all medals.";

    public MedalsInfoCmd(PircBotX botX, ErepUserService erepUserService) {
        super(botX, erepUserService, CMD_PREFIX, CMD_DESC);
    }

    @Override
    public String createProfileMessage(UserProfile userProfile) {
        return userProfile.toMedalsInfo();
    }

}
