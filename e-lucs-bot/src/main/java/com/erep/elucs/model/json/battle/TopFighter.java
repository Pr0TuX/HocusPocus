package com.erep.elucs.model.json.battle;

import com.erep.elucs.model.json.profile.Country;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * @author dragos
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TopFighter {
    private Integer id;
    private String name;
    private String avatar;
    private String birth;
    private Country country;
    private Integer damage;
    private Integer kills;

    public TopFighter() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Integer getDamage() {
        return damage;
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
    }

    public Integer getKills() {
        return kills;
    }

    public void setKills(Integer kills) {
        this.kills = kills;
    }
}
