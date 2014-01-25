package com.erep.elucs.model.json.profile;

import com.erep.elucs.util.Util;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserProfile {
    private String id;
    private String name;
    private String birth;
    private String avatar;
    private Boolean online;
    private Boolean alive;
    private Integer level;
    private Integer experience;
    private Double strength;
    private Rank rank;
    private Boolean elite_citizen;
    private Integer national_rank;
    private Residence residence;
    private Citizenship citizenship;
    private String about;
    private Party party;
    private Army army;
    private Newspaper newspaper;
    private TopDamage top_damage;
    private TruePatriot true_patriot;
    private Integer hit;
    private Medals medals;


    public UserProfile() {
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public Residence getResidence() {
        return residence;
    }

    public void setResidence(Residence residence) {
        this.residence = residence;
    }

    public Citizenship getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(Citizenship citizenship) {
        this.citizenship = citizenship;
    }

    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
    }

    public Army getArmy() {
        return army;
    }

    public void setArmy(Army army) {
        this.army = army;
    }

    public Newspaper getNewspaper() {
        return newspaper;
    }

    public void setNewspaper(Newspaper newspaper) {
        this.newspaper = newspaper;
    }

    public TopDamage getTop_damage() {
        return top_damage;
    }

    public void setTop_damage(TopDamage top_damage) {
        this.top_damage = top_damage;
    }

    public TruePatriot getTrue_patriot() {
        return true_patriot;
    }

    public void setTrue_patriot(TruePatriot true_patriot) {
        this.true_patriot = true_patriot;
    }

    public Medals getMedals() {
        return medals;
    }

    public void setMedals(Medals medals) {
        this.medals = medals;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Boolean getOnline() {
        return online;
    }

    public void setOnline(Boolean online) {
        this.online = online;
    }

    public Boolean getAlive() {
        return alive;
    }

    public void setAlive(Boolean alive) {
        this.alive = alive;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public Double getStrength() {
        return strength;
    }

    public void setStrength(Double strength) {
        this.strength = strength;
    }

    public Boolean getElite_citizen() {
        return elite_citizen;
    }

    public void setElite_citizen(Boolean elite_citizen) {
        this.elite_citizen = elite_citizen;
    }

    public Integer getNational_rank() {
        return national_rank;
    }

    public void setNational_rank(Integer national_rank) {
        this.national_rank = national_rank;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Integer getHit() {
        return hit;
    }

    public void setHit(Integer hit) {
        this.hit = hit;
    }

    public String toBasicInfo() {
        Double q7Hit = rank != null ? Util.getHit(strength, rank.getLevel(), 200) : 0.0;
        return ":: " + Util.toBold("Name ") + name +
                " :: " + Util.toBold("Birth date ") + birth +
                " :: " + Util.toBold("Level ") + level +
                " " + rank +
                " :: " + Util.toBold("Strength ") + strength +
                " :: " + Util.toBold("National Rank ") + national_rank +
                " " + citizenship +
                " " + residence +
                " :: " + Util.toBold("MU ") + (army != null ? army.getName() : "No MU") +
                " :: " + Util.toBold("Hit(q7) ") + q7Hit;
    }

    public String toMedalsInfo() {
        return ":: " + getName() + " " + Util.toString(medals);
    }

    public String toTopInfo() {
        return ":: " + getName() + " " + Util.toString(top_damage, "No top damage") + " " + Util.toString(true_patriot, "No true patriot");
    }

    public String toAboutInfo() {
        return ":: " + getName() + " :: " + Util.toString(about, "No about");
    }

    public String toPaperInfo() {
        return ":: " + getName() + " " + Util.toString(newspaper, "No newspaper");
    }

    public String toAvatarInfo() {
        return ":: " + getName() + " :: " + Util.toBold("Avatar") + " :: " + Util.toString(avatar);
    }

    public String toPartyInfo() {
        return ":: " + getName() + " " + Util.toString(party, "No party member");
    }

    public String toMUInfo() {
        return ":: " + getName() + " " + Util.toString(army, "No military unit member");
    }
}
