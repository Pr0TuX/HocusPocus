package com.erep.elucs.model.json.profile;

import com.erep.elucs.util.Util;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * @author dragos
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Newspaper {
    private Integer id;
    private String role;
    private String name;

    public Newspaper() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return ":: " + Util.toBold("Newspaper") +
                " :: " + Util.toBold("Id ") + id +
                " :: " + Util.toBold("Role ") + role +
                " :: " + Util.toBold("Name ") + name;
    }
}
