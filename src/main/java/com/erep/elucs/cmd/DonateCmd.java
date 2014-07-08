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
public class DonateCmd extends ProfileInfoCmd {


    public DonateCmd(PircBotX botX, ErepUserService erepUserService) {
        super(botX, erepUserService, "donate", "Donate money and donate items links. ");
    }

    @Override
    public void displayInfoByProfile(MessageEvent event, String profileId, CommandLine commandLine) {
        String nickName = event.getUser().getNick();
        if (commandLine.hasOption(PROFILE_OPT)) {
            UserProfile userProfile = getErepublikDataExtractor().getUserProfile(profileId);
            nickName = userProfile.getName();
        }
        sendMessage(event, nickName + " :: " + Util.toBold("Items ") + "http://www.erepublik.com/en/economy/donate-items/" + profileId + " :: "
                + Util.toBold("Money ") + " http://www.erepublik.com/en/economy/donate-money/" + profileId);
    }
}
