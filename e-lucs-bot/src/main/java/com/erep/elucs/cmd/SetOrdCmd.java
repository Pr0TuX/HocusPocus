package com.erep.elucs.cmd;

import org.apache.commons.cli.Options;
import org.pircbotx.PircBotX;
import org.pircbotx.hooks.events.MessageEvent;

import java.util.HashMap;

/**
 * @author dragos
 */
public class SetOrdCmd extends AbstractCmd implements OrdersRepository {

    private final HashMap<String, String> ordersForChan;

    public SetOrdCmd(PircBotX botX) {
        super(botX, "setorder", "<order> Set order for current channel. Only operators can use this command.");
        ordersForChan = new HashMap<String, String>();
    }


    @Override
    public void doEventLogic(MessageEvent event) {
        String cmd = event.getMessage();
        if (cmd.startsWith(getCmdInput())) {
            if (isOperator(event)) {
                int firstSpaceIndex = cmd.indexOf(' ');
                if (firstSpaceIndex > 0) {
                    String order = cmd.substring(firstSpaceIndex);
                    setOrder(event.getChannel().getName(), order);
                    sendMessage(event, "Order set to : " + order);
                } else {
                    sendUsage(event);
                }
            } else {
                sendError(event, event.getUser().getNick() + " you don't have access to use this command.");
            }
        }
    }

    private boolean isOperator(MessageEvent event) {
        return event.getChannel().isOp(event.getUser());
    }

    @Override
    protected Options getCmdOptions() {
        return new Options();
    }

    @Override
    public void setOrder(String channel, String order) {
        ordersForChan.put(channel, order);
    }

    @Override
    public String getOrder(String channel) {
        return ordersForChan.get(channel);
    }
}
