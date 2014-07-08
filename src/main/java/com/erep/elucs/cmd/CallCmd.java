package com.erep.elucs.cmd;

import org.apache.commons.cli.Options;
import org.pircbotx.Channel;
import org.pircbotx.Colors;
import org.pircbotx.PircBotX;
import org.pircbotx.User;
import org.pircbotx.hooks.events.MessageEvent;

import java.util.Set;

/**
 * @author dragos
 */
public class CallCmd extends AbstractCmd {
    public CallCmd(PircBotX botX) {
        super(botX, "call", "<message> Sends a mass message to all users from channel.");
    }

    @Override
    public void doEventLogic(MessageEvent event) {
        String message = event.getMessage();
        if (message.startsWith(getCmdInput())) {
            if (hasAdminRights(event)) {
                int firstSpace = message.indexOf(' ');
                if (firstSpace > 0) {
                    Channel channel = event.getChannel();
                    Set<User> allUsers = channel.getUsers();
                    StringBuilder builder = new StringBuilder();
                    for (User user : allUsers) {
                        builder.append(user.getNick());
                        builder.append(" ");
//                    if (builder.length() > 400) {
//                        sendMessage(channel, builder.toString());
//                        builder = new StringBuilder();
//                    }
                    }
                    sendMessage(event, builder.toString());
                    String actualMessage = message.substring(firstSpace + 1);
                    sendMessage(event, Colors.BOLD + Colors.RED + actualMessage);
                } else {
                    sendUsage(event);
                }
            } else {
                sendError(event, "You don't have access to call this command.");
            }
        }


    }

    private boolean hasAdminRights(MessageEvent event) {
        Channel channel = event.getChannel();
        User user = event.getUser();
        return channel.isOp(user) || channel.isOwner(user) || channel.isSuperOp(user) || channel.isHalfOp(user);
    }

    @Override
    protected Options getCmdOptions() {
        return new Options();
    }
}
