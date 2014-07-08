package com.erep.elucs.cmd;

import com.erep.elucs.util.Util;
import org.apache.commons.cli.Options;
import org.pircbotx.Channel;
import org.pircbotx.PircBotX;
import org.pircbotx.hooks.events.MessageEvent;

/**
 * @author dragos
 */
public class OrdersCmd extends AbstractCmd {

    private final OrdersRepository ordersRepository;

    public OrdersCmd(PircBotX botX, OrdersRepository ordersRepository) {
        super(botX, "orders", "Prints oder for this channel.");
        this.ordersRepository = ordersRepository;
    }

    @Override
    public void doEventLogic(MessageEvent event) {
        String message = event.getMessage();
        if (message.startsWith(getCmdInput())) {
            Channel channel = event.getChannel();
            String order = ordersRepository.getOrder(channel.getName());
            if (Util.isEmpty(order)) {
                sendMessage(event, "Orders for " + channel.getName() + " : " + order);
            } else {
                sendMessage(event, "No orders for channel : " + channel.getName());
            }
        }
    }

    @Override
    protected Options getCmdOptions() {
        return new Options();
    }
}
