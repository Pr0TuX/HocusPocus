package com.erep.elucs.model.json.profile;

import com.erep.elucs.util.Util;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * @author dragos
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Citizenship {
    private Integer id;
    private String name;
    private String code;

    public Citizenship() {
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

    @Override
    public String toString() {
        return ":: " + Util.toBold("Citizenship ") + name;
    }
}
