package com.erep.elucs.extractor;

import com.erep.elucs.model.json.market.MarketInfo;

import java.util.List;

/**
 * @author dragos
 */
public interface MarketInfoExtractor {

    public List<MarketInfo> getMarketInfo(String countryCode, String industry, Integer quality, Integer page);
}
