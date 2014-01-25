package com.erep.elucs.model.json.econ;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * @author dragos
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Bonuses {
    private Double food;
    private Double frm;
    private Double weapons;
    private Double wrm;

    public Bonuses() {
    }

    public Double getFood() {
        return food;
    }

    public void setFood(Double food) {
        this.food = food;
    }

    public Double getFrm() {
        return frm;
    }

    public void setFrm(Double frm) {
        this.frm = frm;
    }

    public Double getWeapons() {
        return weapons;
    }

    public void setWeapons(Double weapons) {
        this.weapons = weapons;
    }

    public Double getWrm() {
        return wrm;
    }

    public void setWrm(Double wrm) {
        this.wrm = wrm;
    }
}
