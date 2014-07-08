package com.erep.elucs.cmd;

import com.erep.elucs.extractor.EconExtractor;
import com.erep.elucs.extractor.ErpkErepublikDataExtractor;
import com.erep.elucs.model.json.econ.EconInfo;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;
import org.pircbotx.PircBotX;
import org.pircbotx.hooks.events.MessageEvent;

import java.util.List;

/**
 * @author dragos
 */
public class EconCmd extends AbstractCmd {

    private final EconExtractor economyExtractor;

    public EconCmd(PircBotX botX) {
        super(botX, "econ", "<country_code> Displays information about economy of some country. Example : RO, US, FR, HU etc.");
        economyExtractor = new ErpkErepublikDataExtractor();
    }

    @Override
    public void doLogic(CommandLine commandLine, MessageEvent event) {
        List argList = commandLine.getArgList();
        if (argList != null && argList.size() > 1) {
            Object arg = argList.get(1);
            if (arg instanceof String) {
                String countryCode = (String) arg;
                EconInfo econInfo = economyExtractor.getEconInfo(countryCode);
                if (econInfo != null) {
                    sendMessage(event, econInfo.toBasicInfo());
                } else {
                    sendMessage(event, "Could not retrieve info for country_code = " + countryCode);
                }
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
