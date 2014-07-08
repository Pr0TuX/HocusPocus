package com.erep.elucs.extractor.direct;

import com.erep.elucs.model.json.profile.Rank;
import com.erep.elucs.model.json.profile.UserProfile;
import com.erep.elucs.util.Util;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dragos
 */
public class ProfileInfoExtractor {

    public static final String NAME_CSS_SELECTOR = "div[class*=citizen_profile_header] h2";

    private String extractName(Document document) {
        return document.select(NAME_CSS_SELECTOR).text();
    }

    public UserProfile extractUserProfile(Document document, ExtraParams extraParams) {
        UserProfile userProfile = new UserProfile();

        userProfile.setId(extraParams.<String>get("id"));
        userProfile.setName(extractName(document));
        userProfile.setStrength(extractStrength(document));
        Rank rank = new Rank();
        rank.setPoints(extractRankPoints(document));
        rank.setName(extractRankName(document));
        userProfile.setRank(rank);

        userProfile.setLevel(extractLevel(document));
        userProfile.setExperience(extractExperience(document));
        return userProfile;
    }

    private Integer extractExperience(Document document) {
        Elements select = document.select("div[class*=citizen_experience] div p");
        String value = select.text();
        if (value != null) {
            if (value.contains("/")) {
                String[] split = value.split("/");
                return Util.toIntUS(split[0]);
            }
        }
        return null;
    }

    private Integer extractLevel(Document document) {
        Elements select = document.select("div[class*=citizen_experience] strong");
        return Util.toInt(select.text());
    }

    private String extractRankName(Document document) {
        Elements select = document.select("div[class*=citizen_military]");
        return select.get(1).select("h4 a").text();
    }

    private Long extractRankPoints(Document document) {
        Elements eq = document.select("div[class*=citizen_military] div[class*=stat] strong").eq(1);
        String textVal = eq.text();
        Long rankPoints = null;
        if (textVal != null) {
            if (textVal.contains("/")) {
                String[] split = textVal.split("/");
                rankPoints = Util.toLongUS(split[0]);
            }
            System.out.println(rankPoints);
        }
        return rankPoints;
    }

    private Double extractStrength(Document document) {
        Elements select = document.select("div[class*=citizen_military]");
        Elements strengthVal = select.first().select("h4");
        System.out.println(strengthVal.text());
        return Util.toDoubleUS(strengthVal.text());
    }

    public static class ExtraParams {

        private Map<String, Object> innerMap;


        public ExtraParams() {
            innerMap = new HashMap<String, Object>();
        }

        public void put(String key, Object value) {
            innerMap.put(key, value);
        }

        public <T> T get(String key) {
            return (T) innerMap.get(key);
        }
    }
}
