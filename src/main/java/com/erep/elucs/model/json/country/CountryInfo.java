package com.erep.elucs.model.json.country;

import com.erep.elucs.util.Util;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * @author dragos
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CountryInfo {

    Integer id;
    String name;
    String code;
    Integer active_citizens;
    Integer new_citizens_today;
    Integer average_citizen_level;
    Integer online_now;
    Integer citizen_fee;
    Integer region_count;

    public CountryInfo() {
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getActive_citizens() {
        return active_citizens;
    }

    public void setActive_citizens(Integer active_citizens) {
        this.active_citizens = active_citizens;
    }

    public Integer getNew_citizens_today() {
        return new_citizens_today;
    }

    public void setNew_citizens_today(Integer new_citizens_today) {
        this.new_citizens_today = new_citizens_today;
    }

    public Integer getAverage_citizen_level() {
        return average_citizen_level;
    }

    public void setAverage_citizen_level(Integer average_citizen_level) {
        this.average_citizen_level = average_citizen_level;
    }

    public Integer getOnline_now() {
        return online_now;
    }

    public void setOnline_now(Integer online_now) {
        this.online_now = online_now;
    }

    public Integer getCitizen_fee() {
        return citizen_fee;
    }

    public void setCitizen_fee(Integer citizen_fee) {
        this.citizen_fee = citizen_fee;
    }

    public Integer getRegion_count() {
        return region_count;
    }

    public void setRegion_count(Integer region_count) {
        this.region_count = region_count;
    }

    public String toBasicInfo() {
        StringBuilder builder = new StringBuilder();
        builder.append(":: ").append(Util.toBold(name)).append(" (").append(id).append(")");
        if (active_citizens != null) {
            builder.append(" :: ").append(Util.toBold("Active citizens ")).append(active_citizens);
        }
        if (new_citizens_today != null) {
            builder.append(" :: ").append(Util.toBold("New citizens today ")).append(new_citizens_today);
        }
        if (average_citizen_level != null) {
            builder.append(" :: ").append(Util.toBold("Average citizens level ")).append(average_citizen_level);
        }
        if (online_now != null) {
            builder.append(" :: ").append(Util.toBold("Online ")).append(online_now);
        }
        if (citizen_fee != null) {
            builder.append(" :: ").append(Util.toBold("Fee ")).append(citizen_fee);
        }
        if (region_count != null) {
            builder.append(" :: ").append(Util.toBold("Regions :")).append(region_count);
        }
        return builder.toString();
    }
}
