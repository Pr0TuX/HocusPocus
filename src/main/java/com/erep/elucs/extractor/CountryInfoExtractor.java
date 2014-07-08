package com.erep.elucs.extractor;

import com.erep.elucs.model.json.country.CountryInfo;

/**
 * @author dragos
 */
public interface CountryInfoExtractor {
    CountryInfo getCountryInfo(String countryCode);
}
