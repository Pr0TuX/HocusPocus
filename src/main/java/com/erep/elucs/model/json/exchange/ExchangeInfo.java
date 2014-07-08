package com.erep.elucs.model.json.exchange;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * @author dragos
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExchangeInfo {
    private Integer id;
    private Double amount;
    private Double rate;
    private Seller seller;

    public ExchangeInfo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }
}
