package com.erep.elucs.cmd;

import com.erep.elucs.extractor.ErepublikDataExtractor;
import com.erep.elucs.extractor.ErpkErepublikDataExtractor;
import com.erep.elucs.extractor.UserProfileExtractor;
import com.erep.elucs.jpa.domain.ErepUser;
import com.erep.elucs.jpa.service.ErepUserService;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.pircbotx.PircBotX;
import org.pircbotx.hooks.events.MessageEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author dragos
 */
public abstract class ErepNickProfileAbstractCmd extends AbstractCmd {

    public static final String PROFILE_OPT = "i";
    public static final String NICK_OPT = "n";
    private static final Logger LOG = LoggerFactory.getLogger(ErepNickProfileAbstractCmd.class);

    private final ErepUserService erepUserService;
    private Options commandOptions;
    private final ErepublikDataExtractor erepublikDataExtractor;

    public ErepNickProfileAbstractCmd(PircBotX botX, ErepUserService erepUserService, String cmdPrefix, String cmdDesc) {
        super(botX, cmdPrefix, cmdDesc);
        this.erepUserService = erepUserService;
        erepublikDataExtractor = new ErpkErepublikDataExtractor();
        initOptions();
    }

    public UserProfileExtractor getErepublikDataExtractor() {
        return erepublikDataExtractor;
    }

    public void doLogic(CommandLine commandLine, MessageEvent event) {
        if (commandLine != null) {
            if (commandLine.hasOption(NICK_OPT)) {
                String nickValue = commandLine.getOptionValue(NICK_OPT);
                if (nickValue != null) {
                    displayInfoByNick(event, nickValue, commandLine);
                    return;
                } else {
                    sendUsage(event);
                }
            }

            if (commandLine.hasOption(PROFILE_OPT)) {
                String profileValue = commandLine.getOptionValue(PROFILE_OPT);
                if (profileValue != null) {
                    displayInfoByProfile(event, profileValue, commandLine);
                    return;
                } else {
                    sendUsage(event);
                }
            }

            String nick = event.getUser().getNick();
            List argList = commandLine.getArgList();
            if (argList != null && argList.size() > 1) {
                LOG.debug("Arg list = " + argList);
                Object argument = argList.get(1);
                if (argument instanceof String) {
                    nick = (String) argument;
                }
            }

            displayInfoByNick(event, nick, commandLine);
        }
    }

    public abstract void displayInfoByProfile(MessageEvent event, String profileValue, CommandLine commandLine);


    public abstract void displayInfoByNick(MessageEvent event, String nickValue, CommandLine commandLine);

    public String resolveProfileValue(String nick) {
        ErepUser byNick = erepUserService.findByNick(nick);
        if (byNick != null) {
            return byNick.getProfileId();
        } else {
            return null;
        }
    }

    private void initOptions() {
        commandOptions = new Options();

        Option profileCmd = new Option(PROFILE_OPT, "id", true, "Uses eRepublik profile_id as parameter");
        profileCmd.setArgName("profile_id");
        profileCmd.setType(Number.class);
        commandOptions.addOption(profileCmd);

        Option nickCmd = new Option(NICK_OPT, "nick", true, "Uses registered irc nick as parameter");
        nickCmd.setArgName("nick");
        commandOptions.addOption(nickCmd);
    }

    @Override
    protected Options getCmdOptions() {
        return commandOptions;
    }
}
