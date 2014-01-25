package com.erep.elucs.cmd;

import com.erep.elucs.extractor.ErepublikDataExtractor;
import com.erep.elucs.extractor.ErpkErepublikDataExtractor;
import com.erep.elucs.model.json.country.CountryInfo;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;
import org.pircbotx.PircBotX;
import org.pircbotx.hooks.events.MessageEvent;

import java.util.List;

/**
 * @author dragos
 */
public class CountryCmd extends AbstractCmd {

    private final ErepublikDataExtractor erepublikDataExtractor;

    public CountryCmd(PircBotX botX) {
        super(botX, "country", "<country_code> Displays information about specific country given as <country_code> parameter");
        erepublikDataExtractor = new ErpkErepublikDataExtractor();
    }

    @Override
    public void doLogic(CommandLine commandLine, MessageEvent event) {
        List argList = commandLine.getArgList();
        if (argList != null && argList.size() == 2) {
            Object arg = argList.get(1);
            if (arg instanceof String) {
                String countryCode = (String) arg;
                CountryInfo info = erepublikDataExtractor.getCountryInfo(countryCode);
                if (info != null) {
                    sendMessage(event, info.toBasicInfo());
                } else {
                    sendError(event, "No data received. Please retry again latter.");
                }

            } else {
                sendUsage(event);
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
