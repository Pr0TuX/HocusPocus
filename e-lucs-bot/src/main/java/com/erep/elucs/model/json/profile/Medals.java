package com.erep.elucs.model.json.profile;

import com.erep.elucs.util.Util;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * @author dragos
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Medals {
    private Integer battle_hero;
    private Integer campaign_hero;
    private Integer congress_member;
    private Integer country_president;
    private Integer hard_worker;
    private Integer media_mogul;
    private Integer mercenary;
    private Integer resistance_hero;
    private Integer society_builder;
    private Integer super_soldier;
    private Integer top_fighter;


    private Integer true_patriot;

    Medals() {
    }

    public void setBattle_hero(Integer battle_hero) {
        this.battle_hero = battle_hero;
    }

    public void setCampaign_hero(Integer campaign_hero) {
        this.campaign_hero = campaign_hero;
    }

    public void setCongress_member(Integer congress_member) {
        this.congress_member = congress_member;
    }

    public void setCountry_president(Integer country_president) {
        this.country_president = country_president;
    }

    public void setHard_worker(Integer hard_worker) {
        this.hard_worker = hard_worker;
    }

    public void setMedia_mogul(Integer media_mogul) {
        this.media_mogul = media_mogul;
    }

    public void setMercenary(Integer mercenary) {
        this.mercenary = mercenary;
    }

    public void setResistance_hero(Integer resistance_hero) {
        this.resistance_hero = resistance_hero;
    }

    public void setSociety_builder(Integer society_builder) {
        this.society_builder = society_builder;
    }

    public void setSuper_soldier(Integer super_soldier) {
        this.super_soldier = super_soldier;
    }

    public void setTop_fighter(Integer top_fighter) {
        this.top_fighter = top_fighter;
    }

    public void setTrue_patriot(Integer true_patriot) {
        this.true_patriot = true_patriot;
    }

    public Integer getBattle_hero() {
        return battle_hero;
    }

    public Integer getCampaign_hero() {
        return campaign_hero;
    }

    public Integer getCongress_member() {
        return congress_member;
    }

    public Integer getCountry_president() {
        return country_president;
    }

    public Integer getHard_worker() {
        return hard_worker;
    }

    public Integer getMedia_mogul() {
        return media_mogul;
    }

    public Integer getMercenary() {
        return mercenary;
    }

    public Integer getResistance_hero() {
        return resistance_hero;
    }

    public Integer getSociety_builder() {
        return society_builder;
    }

    public Integer getSuper_soldier() {
        return super_soldier;
    }

    public Integer getTop_fighter() {
        return top_fighter;
    }

    public Integer getTrue_patriot() {
        return true_patriot;
    }

    @Override
    public String toString() {
        return ":: " + Util.toBold("Medals") +
                " :: " + Util.toBold("Battle Hero ") + battle_hero +
                " :: " + Util.toBold("Campaign Hero ") + campaign_hero +
                " :: " + Util.toBold("Congress Member ") + congress_member +
                " :: " + Util.toBold("Country President ") + country_president +
                " :: " + Util.toBold("Hard Worker ") + hard_worker +
                " :: " + Util.toBold("Media Mogul ") + media_mogul +
                " :: " + Util.toBold("Mercenary ") + mercenary +
                " :: " + Util.toBold("Resistance Hero ") + resistance_hero +
                " :: " + Util.toBold("Society Builder ") + society_builder +
                " :: " + Util.toBold("Super Soldier ") + super_soldier +
                " :: " + Util.toBold("Top Fighter ") + top_fighter +
                " :: " + Util.toBold("True Patriot ") + true_patriot;
    }

}

