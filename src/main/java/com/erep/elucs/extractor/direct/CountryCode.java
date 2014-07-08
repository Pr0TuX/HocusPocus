package com.erep.elucs.extractor.direct;

/**
 * @author dragos
 */
public enum CountryCode {
    RO("Romania"),
    UNKNOWN(""),;
    private final String longName;
    private final String code;

    CountryCode(String longName) {
        this.longName = longName;
        this.code = name();
    }

    public static CountryCode fromCode(String countryCode) {
        if (countryCode != null && countryCode.length() >= 2) {
            for (CountryCode cc : values()) {
                if (cc.code.equals(countryCode)) {
                    return cc;
                }
            }
        }
        return UNKNOWN;
    }

    public String getLongName() {
        return longName;
    }

    public String getCode() {
        return code;
    }
}