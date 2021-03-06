package com.erep.elucs.cmd;

import com.erep.elucs.jpa.service.ErepUserService;
import com.erep.elucs.model.json.profile.UserProfile;
import org.pircbotx.PircBotX;

/**
 * @author dragos
 */
public class AvatarInfoCmd extends ProfileInfoCmd {
    public AvatarInfoCmd(PircBotX botX, ErepUserService erepUserService) {
        super(botX, erepUserService, "avatar", "Displays avatar for user.");
    }

    @Override
    public String createProfileMessage(UserProfile userProfile) {
        return userProfile.toAvatarInfo();
    }
}
