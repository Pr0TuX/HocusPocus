package com.erep.elucs.cmd;

import com.erep.elucs.extractor.ErepublikDataExtractor;
import com.erep.elucs.extractor.ErpkErepublikDataExtractor;
import com.erep.elucs.model.json.search.SearchedUser;
import com.erep.elucs.util.Util;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;
import org.pircbotx.PircBotX;
import org.pircbotx.hooks.events.MessageEvent;

import java.util.List;

/**
 * @author dragos
 */
public class SearchCmd extends AbstractCmd {

    private final ErepublikDataExtractor erepublikDataExtractor;

    public SearchCmd(PircBotX botX) {
        super(botX, "search", "Searches for a eRepublik user by its name.");
        erepublikDataExtractor = new ErpkErepublikDataExtractor();
    }

    @Override
    public void doLogic(CommandLine commandLine, MessageEvent event) {
        List argList = commandLine.getArgList();
        if (argList != null && argList.size() > 1) {
            String message = event.getMessage();
            String cmdInput = getCmdInput();
            String searchFor = message.substring(cmdInput.length() + 1);
            List<SearchedUser> users = erepublikDataExtractor.findUsers(searchFor);
            sendMessage(event, createMessage(users, searchFor));
        } else {
            sendUsage(event);
        }
    }

    private String createMessage(List<SearchedUser> users, String searchFor) {
        System.out.println(users);

        if (users != null && users.size() > 0) {
            StringBuilder builder = new StringBuilder();
            builder.append(":: ").append(Util.toBold("Results for :")).append(searchFor);
            for (SearchedUser user : users) {
                builder.append(" ::");
                builder.append(Util.toBold(" Id")).append(" : ").append(user.getId());
                builder.append(Util.toBold(" Name")).append(" : ").append(user.getName());
            }
            return builder.toString();
        } else {
            return "No citizen found for specified argument = " + searchFor;
        }
    }

    @Override
    protected Options getCmdOptions() {
        return new Options();
    }
}
