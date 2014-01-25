package com.erep.elucs.model.json.profile;

import com.erep.elucs.util.Util;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * @author dragos
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TruePatriot {
    private Integer damage;
    private String since;

    public TruePatriot() {
    }

    public Integer getDamage() {
        return damage;
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
    }

    public String getSince() {
        return since;
    }

    public void setSince(String since) {
        this.since = since;
    }

    @Override
    public String toString() {
        return ":: " + Util.toString("True patriot") +
                " :: " + Util.toBold("Damage ") + Util.formatWithComma(damage) + Util.toBold(" Since ") + since;
    }

}
