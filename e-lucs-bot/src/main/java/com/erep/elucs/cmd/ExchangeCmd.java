package com.erep.elucs.cmd;

import com.erep.elucs.extractor.ErepublikDataExtractor;
import com.erep.elucs.extractor.ErpkErepublikDataExtractor;
import com.erep.elucs.model.json.exchange.ExchangeInfo;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;
import org.pircbotx.PircBotX;
import org.pircbotx.hooks.events.MessageEvent;

import java.util.List;

/**
 * @author dragos
 */
public class ExchangeCmd extends AbstractCmd {

    private final ErepublikDataExtractor erepublikDataExtractor;

    public ExchangeCmd(PircBotX botX) {
        super(botX, "mm", "<gold|cc> Displays first 10 offers af selling <gold|cc>.");
        erepublikDataExtractor = new ErpkErepublikDataExtractor();
    }

    @Override
    public void doLogic(CommandLine commandLine, MessageEvent event) {
        List argList = commandLine.getArgList();
        if (argList != null && argList.size() == 2) {
            Object arg = argList.get(1);
            if (arg instanceof String) {
                String param = (String) arg;
                int type = "gold".equals(param) ? 1 : ("cc".equals(param) ? 0 : -1);
                if (type >= 0) {
                    List<ExchangeInfo> exchangeInfos = erepublikDataExtractor.getExchangeInfo(type);
                    if (exchangeInfos != null && exchangeInfos.size() != 0) {
                        StringBuilder builder = new StringBuilder();
                        builder.append("Buy 1 ").append(param).append(" for : ");
                        for (ExchangeInfo info : exchangeInfos) {
                            builder.append(info.getRate()).append(" CC, ");
                        }
                        builder.delete(builder.length() - 1, builder.length());
                        sendMessage(event, builder.toString());
                    } else {
                        sendMessage(event, "No exchange offer received.");
                    }
                } else {
                    sendError(event, "Please use  gold or cc as parameter");
                }
            } else {
                sendError(event, "Please use  gold or cc as parameter");
            }
        } else {
            sendError(event, "Please use  gold or cc as parameter");
        }

    }

    @Override
    protected Options getCmdOptions() {
        return new Options();
    }
}
