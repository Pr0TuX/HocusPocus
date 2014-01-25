package com.erep.elucs.extractor;

import com.erep.elucs.model.json.econ.EconInfo;

/**
 * @author dragos
 */
public interface EconExtractor {
    EconInfo getEconInfo(String countryCode);
}
