package com.erep.elucs.cmd;

import com.erep.elucs.jpa.service.ErepUserService;
import com.erep.elucs.model.json.profile.Rank;
import com.erep.elucs.model.json.profile.UserProfile;
import com.erep.elucs.util.Util;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.pircbotx.PircBotX;
import org.pircbotx.hooks.events.MessageEvent;

/**
 * @author dragos
 */
public class FireCountCmd extends ErepNickProfileAbstractCmd {

    public static final String STRENGTH_OPT = "s";
    public static final String RANK_OPT = "r";
    public static final String FIGHTS_OPT = "f";
    public static final String NATURAL_ENEMY_OPT = "e";

    public FireCountCmd(PircBotX botX, ErepUserService erepUserService) {
        super(botX, erepUserService, "fc", "Calculates total damage give with different weapons qualities.");
        addExtraOptions();
    }

    private void addExtraOptions() {
        Options cmdOptions = getCmdOptions();

        Option strengthOpt = new Option(STRENGTH_OPT, "strength", true, "uses a custom strength");
        strengthOpt.setArgName("strength");
        strengthOpt.setType(Number.class);
        cmdOptions.addOption(strengthOpt);

        Option rankOpt = new Option(RANK_OPT, "rank", true, "uses a custom military rank");
        rankOpt.setArgName("rank");
        rankOpt.setType(Number.class);
        cmdOptions.addOption(rankOpt);

        Option fightsOpt = new Option(FIGHTS_OPT, "fights", true, "specifies numbers of fights");
        fightsOpt.setArgName("fights");
        fightsOpt.setType(Number.class);
        cmdOptions.addOption(fightsOpt);

        Option neOpt = new Option(NATURAL_ENEMY_OPT, "natural_enemy", false, "adds 10% natural enemy bonus to damage");
        cmdOptions.addOption(neOpt);
    }


    @Override
    public void displayInfoByProfile(MessageEvent event, String profileValue, CommandLine commandLine) {
        UserProfile profileInfo = getErepublikDataExtractor().getUserProfile(profileValue);
        if (profileInfo != null) {
            StringBuilder builder = new StringBuilder();

            Rank rank = profileInfo.getRank();
            String name = profileInfo.getName();

            Double strength = profileInfo.getStrength();
            if (commandLine.hasOption(STRENGTH_OPT)) {
                Object optionObject = commandLine.getOptionObject(STRENGTH_OPT);
                if (optionObject instanceof Number) {
                    strength = ((Number) optionObject).doubleValue();
                }
            }


            Integer fights = 1;
            if (commandLine.hasOption(FIGHTS_OPT)) {
                Object optionObject = commandLine.getOptionObject(FIGHTS_OPT);
                if (optionObject instanceof Number) {
                    fights = ((Number) optionObject).intValue();
                }
            }

            boolean isNe = false;
            if (commandLine.hasOption(NATURAL_ENEMY_OPT)) {
                isNe = true;
            }

            Integer rankLevel = rank.getLevel();
            if (commandLine.hasOption(RANK_OPT)) {
                Object optionObject = commandLine.getOptionObject(RANK_OPT);
                if (optionObject instanceof Number) {
                    rankLevel = ((Number) optionObject).intValue();
                }
            }


            builder.append("(").append(name).append(" ").append(rank.getName()).append(" [").append(rankLevel).append("]");
            builder.append(", ").append(Util.formatDecimal(strength)).append(" strength)");
            builder.append(" influence :: ");
            builder.append(":: fights ").append(fights);

            builder.append(" [").append(Util.toBold("Q0: ")).append(Util.formatWithComma(Util.getHit(strength, rankLevel, 0, fights, isNe))).append("]");
            builder.append(" [").append(Util.toBold("Q1: ")).append(Util.formatWithComma(Util.getHit(strength, rankLevel, 20, fights, isNe))).append("]");
            builder.append(" [").append(Util.toBold("Q2: ")).append(Util.formatWithComma(Util.getHit(strength, rankLevel, 40, fights, isNe))).append("]");
            builder.append(" [").append(Util.toBold("Q3: ")).append(Util.formatWithComma(Util.getHit(strength, rankLevel, 60, fights, isNe))).append("]");
            builder.append(" [").append(Util.toBold("Q4: ")).append(Util.formatWithComma(Util.getHit(strength, rankLevel, 80, fights, isNe))).append("]");
            builder.append(" [").append(Util.toBold("Q5: ")).append(Util.formatWithComma(Util.getHit(strength, rankLevel, 100, fights, isNe))).append("]");
            builder.append(" [").append(Util.toBold("Q6: ")).append(Util.formatWithComma(Util.getHit(strength, rankLevel, 120, fights, isNe))).append("]");
            builder.append(" [").append(Util.toBold("Q7: ")).append(Util.formatWithComma(Util.getHit(strength, rankLevel, 200, fights, isNe))).append("]");
            builder.append("::");
            getBotX().sendMessage(event.getChannel(), builder.toString());
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
