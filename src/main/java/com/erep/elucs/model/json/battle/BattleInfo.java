package com.erep.elucs.model.json.battle;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.Map;

/**
 * @author dragos
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BattleInfo {
    private Integer id;
    private String code;
    private String name;
    private Integer points;
    private Map<String, DivisionInfo> divisions;

    public BattleInfo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Map<String, DivisionInfo> getDivisions() {
        return divisions;
    }

    public void setDivisions(Map<String, DivisionInfo> divisions) {
        this.divisions = divisions;
    }

}
