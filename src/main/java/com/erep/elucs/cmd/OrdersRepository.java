package com.erep.elucs.cmd;

/**
 * @author dragos
 */
public interface OrdersRepository {
    public void setOrder(String channel, String order);

    public String getOrder(String channel);
}
