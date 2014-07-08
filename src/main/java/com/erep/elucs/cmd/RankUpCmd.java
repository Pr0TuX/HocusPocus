package com.erep.elucs.cmd;

import com.erep.elucs.jpa.service.ErepUserService;
import com.erep.elucs.model.json.profile.Rank;
import com.erep.elucs.model.json.profile.RanksLevel;
import com.erep.elucs.model.json.profile.UserProfile;
import com.erep.elucs.util.Util;
import org.apache.commons.cli.CommandLine;
import org.pircbotx.PircBotX;
import org.pircbotx.hooks.events.MessageEvent;

/**
 * @author dragos
 */
public class RankUpCmd extends ErepNickProfileAbstractCmd {


    public RankUpCmd(PircBotX botX, ErepUserService erepUserService) {
        super(botX, erepUserService, "rankup", "Calculates total damage give with different weapons qualities.");
    }

    @Override
    public void displayInfoByProfile(MessageEvent event, String profileValue, CommandLine commandLine) {
        UserProfile userProfile = getErepublikDataExtractor().getUserProfile(profileValue);
//        :: elbandido [4685406] :: (World Class Force [54], 8702.7 strength) fights required to rank up - 2.315.320 :: [Q0: 862] [Q1: 719] [Q2: 616] [Q3: 539] [Q4: 479] [Q5: 431] [Q6: 392] [Q7: 287]
        if (userProfile != null) {
            StringBuilder builder = new StringBuilder();
            Rank rank = userProfile.getRank();
            Double strength = userProfile.getStrength();
            Integer level = rank.getLevel();

            builder.append(":: ").append(Util.toBold(userProfile.getName())).append(" [").append(rank.getPoints()).append("]");
            builder.append(" :: ").append("(").append(rank.getName()).append(" [").append(level).append("]");
            builder.append(", ").append(strength).append(" strength)");
            long until = RanksLevel.getUntil(rank.getPoints(), level);
            long q0Hit = until / Util.getHit(strength, level, 0);
            long q1Hit = until / Util.getHit(strength, level, 20);
            long q2Hit = until / Util.getHit(strength, level, 40);
            long q3Hit = until / Util.getHit(strength, level, 60);
            long q4Hit = until / Util.getHit(strength, level, 80);
            long q5Hit = until / Util.getHit(strength, level, 100);
            long q6Hit = until / Util.getHit(strength, level, 120);
            long q7Hit = until / Util.getHit(strength, level, 200);

            builder.append(" influence needed : ").append(Util.formatWithThousands(until));
            builder.append(" fights required to rank up : ");

            builder.append(" [").append(Util.toBold("Q0: ")).append(q0Hit).append("]");
            builder.append(" [").append(Util.toBold("Q1: ")).append(q1Hit).append("]");
            builder.append(" [").append(Util.toBold("Q2: ")).append(q2Hit).append("]");
            builder.append(" [").append(Util.toBold("Q3: ")).append(q3Hit).append("]");
            builder.append(" [").append(Util.toBold("Q4: ")).append(q4Hit).append("]");
            builder.append(" [").append(Util.toBold("Q5: ")).append(q5Hit).append("]");
            builder.append(" [").append(Util.toBold("Q6: ")).append(q6Hit).append("]");
            builder.append(" [").append(Util.toBold("Q7: ")).append(q7Hit).append("]");
            builder.append("::");

            sendMessage(event, builder.toString());
        } else {
            sendError(event, "Could not retrieve user information for profileId = " + profileValue);
        }
    }

    @Override
    public void displayInfoByNick(MessageEvent event, String nickValue, CommandLine commandLine) {
        String profileId = resolveProfileValue(nickValue);
        displayInfoByProfile(event, profileId, commandLine);
    }


}
