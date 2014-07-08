package com.erep.elucs.extractor;

import com.erep.elucs.model.json.exchange.ExchangeInfo;

import java.util.List;

/**
 * @author dragos
 */
public interface ExchangeInfoExtractor {
    List<ExchangeInfo> getExchangeInfo(int type);
}
