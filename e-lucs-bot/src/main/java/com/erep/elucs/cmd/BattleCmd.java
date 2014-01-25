package com.erep.elucs.cmd;

import com.erep.elucs.extractor.ErepublikDataExtractor;
import com.erep.elucs.extractor.ErpkErepublikDataExtractor;
import com.erep.elucs.model.json.battle.Battle;
import com.erep.elucs.util.Util;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;
import org.pircbotx.PircBotX;
import org.pircbotx.hooks.events.MessageEvent;

import java.util.List;

/**
 * @author dragos
 */
public class BattleCmd extends AbstractCmd {

    private final ErepublikDataExtractor erepublikDataExtractor;

    public BattleCmd(PircBotX botX) {
        super(botX, "battle", "<battle_id> Displays real time data about a specific eRepublik battle identified by <battle_id>");
        erepublikDataExtractor = new ErpkErepublikDataExtractor();
    }

    @Override
    public void doLogic(CommandLine commandLine, MessageEvent event) {
        List argList = commandLine.getArgList();
        if (argList != null && argList.size() > 1) {
            Object arg = argList.get(1);
            if ((arg instanceof String) && Util.toInt((String) arg) != null) {
                String battleId = (String) arg;
                Battle battle = erepublikDataExtractor.getBattleInfo(battleId);
                if (battle != null) {
                    sendMessage(event, battle.toBasicInfo());
                    sendMessage(event, battle.toDivInfo("1"));
                    sendMessage(event, battle.toDivInfo("2"));
                    sendMessage(event, battle.toDivInfo("3"));
                    sendMessage(event, battle.toDivInfo("4"));
                } else {
                    sendError(event, "Could not retrieve battle info for id = " + battleId + " please retry");
                }
            } else {
                sendError(event, event.getUser().getNick() + " :: <battle_id> parameter must be a valid battle id, see " + Util.toBold(getCmdName() + " help"));
            }
        } else {
            sendUsage(event);
        }
    }

    @Override
    protected Options getCmdOptions() {
        return new Options();
    }
}
