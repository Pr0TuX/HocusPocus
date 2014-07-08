package com.erep.elucs.model.json.profile;

import com.erep.elucs.util.Util;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * @author dragos
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Army {
    private Integer id;
    private String name;
    private String role;
    private String created_at;
    private String avatar;
    private String rank;

    public Army() {
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return ":: " + Util.toBold("Military Unit ") +
                " :: " + Util.toBold("Id ") + id +
                " :: " + Util.toBold("Name ") + name +
                " :: " + Util.toBold("Role ") + role +
                " :: " + Util.toBold("Avatar ") + avatar +
                " :: " + Util.toBold("Rank ") + rank +
                " :: " + Util.toBold("Created ") + created_at;
    }
}
