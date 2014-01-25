package com.erep.elucs.model.json.profile;

import com.erep.elucs.util.Util;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * @author dragos
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Party {
    private Integer id;
    private String name;
    private String role;

    public Party() {
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

    @Override
    public String toString() {
        return ":: " + Util.toBold("Party") +
                " :: " + Util.toBold("Id ") + id +
                " :: " + Util.toBold("Name ") + name +
                " :: " + Util.toBold("Role ") + role;
    }
}
