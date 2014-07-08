package com.erep.elucs.extractor;

import com.erep.elucs.model.json.battle.Battle;
import com.erep.elucs.model.json.country.CountryInfo;
import com.erep.elucs.model.json.econ.EconInfo;
import com.erep.elucs.model.json.exchange.ExchangeInfo;
import com.erep.elucs.model.json.market.MarketInfo;
import com.erep.elucs.model.json.profile.UserProfile;
import com.erep.elucs.model.json.search.SearchedUser;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.List;

public class ErpkErepublikDataExtractor implements ErepublikDataExtractor {
    private static final Logger LOG = LoggerFactory.getLogger(ErpkErepublikDataExtractor.class);

    private final String accessKey;

    public ErpkErepublikDataExtractor() {
        accessKey = "dsLlNX6K";
    }

    public ErpkErepublikDataExtractor(String accessKey) {
        this.accessKey = accessKey;
    }

    @Override
    public UserProfile getUserProfile(String profileId) {
        String uri = "http://api.erpk.org/citizen/profile/" + profileId + ".json?key=" + accessKey;
        LOG.debug("Hitting : " + uri);
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(new URL(uri), UserProfile.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public EconInfo getEconInfo(String countryCode) {
        ObjectMapper mapper = new ObjectMapper();
        String uri = "http://api.erpk.org/country/" + countryCode + "/economy.json?key=" + accessKey;
        LOG.debug("Hitting : " + uri);
        try {

            EconInfo econInfo = mapper.readValue(new URL(uri), EconInfo.class);
            System.out.println("Econ info = " + econInfo);

            return econInfo;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Battle getBattleInfo(String battleId) {
        String uri = "http://api.erpk.org/battle/" + battleId + ".json?key=" + accessKey;
        LOG.debug("Hitting : " + uri);
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(new URL(uri), Battle.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ExchangeInfo> getExchangeInfo(int type) {
        String uri = "http://api.erpk.org/exchange/" + type + "/1" + ".json?key=" + accessKey;
        LOG.debug("Hitting : " + uri);
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(new URL(uri), new TypeReference<List<ExchangeInfo>>() {
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<SearchedUser> findUsers(String param) {
        String uri = "http://api.erpk.org/citizen/search/" + param + "/1" + ".json?key=" + accessKey;
        LOG.debug("Hitting : " + uri);
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(new URL(uri), new TypeReference<List<SearchedUser>>() {
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public CountryInfo getCountryInfo(String countryCode) {
        String uri = "http://api.erpk.org/country/" + countryCode + "/society" + ".json?key=" + accessKey;
        LOG.debug("Hitting : " + uri);
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(new URL(uri), CountryInfo.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<MarketInfo> getMarketInfo(String countryCode, String industry, Integer quality, Integer page) {
        String uri = "http://api.erpk.org/market/" + countryCode + "/" + industry + "/" + quality + "/" + page + ".json?key=" + accessKey;
        LOG.debug("Hitting : " + uri);
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(new URL(uri), new TypeReference<List<MarketInfo>>() {
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
