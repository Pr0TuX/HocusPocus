package com.erep.elucs.model.json.profile;

import com.erep.elucs.util.Util;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * @author dragos
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Region {
    private Integer id;
    private String name;

    public Region() {
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

    @Override
    public String toString() {
        return ":: " + Util.toBold("Region") +
                " :: " + Util.toBold("Id ") + id +
                " :: " + Util.toBold("Name ") + name;
    }
}
