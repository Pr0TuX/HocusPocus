package com.erep.elucs.model.json.profile;

import com.erep.elucs.util.Util;

/**
 * @author dragos
 */
public class TopDamage {
    private Integer damage;
    private String date;
    private String message;

    public TopDamage() {
    }

    public Integer getDamage() {
        return damage;
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return ":: " + Util.toBold("Damage ") + Util.formatWithComma(damage) +
                " :: " + Util.toBold("Date ") + date +
                " :: " + message;
    }
}
