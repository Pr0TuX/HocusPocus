package com.erep.elucs.model.json.battle;

import com.erep.elucs.model.json.profile.Region;
import com.erep.elucs.util.Util;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.Map;

/**
 * @author dragos
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Battle {
    private Integer id;
    private String url;
    private Boolean is_resistance;
    private Boolean is_finished;

    private Region region;

    private BattleInfo attacker;
    private BattleInfo defender;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getIs_resistance() {
        return is_resistance;
    }

    public void setIs_resistance(Boolean is_resistance) {
        this.is_resistance = is_resistance;
    }


    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public BattleInfo getAttacker() {
        return attacker;
    }

    public void setAttacker(BattleInfo attacker) {
        this.attacker = attacker;
    }

    public BattleInfo getDefender() {
        return defender;
    }

    public void setDefender(BattleInfo defender) {
        this.defender = defender;
    }

    public Boolean getIs_finished() {
        return is_finished;
    }

    public void setIs_finished(Boolean is_finished) {
        this.is_finished = is_finished;
    }

    public String toBasicInfo() {
//:: Battle (29229) Crisana :: Resistance force of Romania vs Hungary :: Total Points 1 - 32
//:: Div.1  :: Romania (1 p.) (45.75 %) (0 mini) <--> (1380 mini) (54.25 %) (2 p.) Hungary :: Timer min: 76
//:: Div.2  :: Romania (0 p.) (45.74 %) (10 mini) <--> (1370 mini) (54.26 %) (6 p.) Hungary :: Timer min: 76
//:: Div.3  :: Romania (0 p.) (44.25 %) (10 mini) <--> (1370 mini) (55.75 %) (9 p.) Hungary :: Timer min: 76
//:: Div.4  :: Romania (0 p.) (46.65 %) (460 mini) <--> (920 mini) (53.35 %) (15 p.) Hungary :: Timer min: 76
        if (id != null && url != null && attacker != null && defender != null) {

            StringBuilder builder = new StringBuilder();
            builder.append(":: Battle (").append(id).append(")").append(" ").append(region.getName()).append(" :: ");
            if (is_resistance != null && is_resistance) {
                builder.append("Resistance force of ");
            }
            builder.append(attacker.getName()).append(" vs ").append(defender.getName()).append(" :: ");
            builder.append(" Total points ").append(attacker.getPoints()).append(" - ").append(defender.getPoints());

            return builder.toString();
        } else {
            return "Invalid data received, please retry";
        }
    }

    public String toDivInfo(String divId) {
        if (id != null && url != null && attacker != null && defender != null) {

            StringBuilder builder = new StringBuilder();
            Map<String, DivisionInfo> divisions = attacker.getDivisions();
            DivisionInfo attackerDivInfo = divisions.get(divId);
            builder.append(":: Div.").append(divId).append(" :: ").append(attacker.getName());
            builder.append(" (").append(attackerDivInfo.getPoints()).append(" p.)");
            builder.append(" (").append(Util.formatDecimal(attackerDivInfo.getBar())).append(" %)");
            builder.append(" (").append(attackerDivInfo.getDomination()).append(" mini) ");
            builder.append("---");
            DivisionInfo defenderDivInfo = defender.getDivisions().get(divId);
            builder.append(" (").append(defenderDivInfo.getDomination()).append(" mini)");
            builder.append(" (").append(Util.formatDecimal(defenderDivInfo.getBar())).append(" %)");
            builder.append(" (").append(defenderDivInfo.getPoints()).append(" p.) ");
            builder.append(defender.getName());

            return builder.toString();
        } else {
            return "Invalid data received, please retry";
        }
    }
}
