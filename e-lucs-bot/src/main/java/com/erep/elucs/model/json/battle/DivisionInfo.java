package com.erep.elucs.model.json.battle;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.List;

/**
 * @author dragos
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DivisionInfo {
    private Integer points;
    private Double bar;
    private Integer domination;
    private Boolean won;
    private List<TopFighter> topFighters;

    public DivisionInfo() {
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Double getBar() {
        return bar;
    }

    public void setBar(Double bar) {
        this.bar = bar;
    }

    public Integer getDomination() {
        return domination;
    }

    public void setDomination(Integer domination) {
        this.domination = domination;
    }

    public Boolean getWon() {
        return won;
    }

    public void setWon(Boolean won) {
        this.won = won;
    }

    public List<TopFighter> getTopFighters() {
        return topFighters;
    }

    public void setTopFighters(List<TopFighter> topFighters) {
        this.topFighters = topFighters;
    }
}
