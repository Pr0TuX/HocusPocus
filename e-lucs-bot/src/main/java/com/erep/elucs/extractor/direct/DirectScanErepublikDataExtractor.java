package com.erep.elucs.extractor.direct;

import com.erep.elucs.extractor.ErepublikDataExtractor;
import com.erep.elucs.model.json.battle.Battle;
import com.erep.elucs.model.json.country.CountryInfo;
import com.erep.elucs.model.json.econ.EconInfo;
import com.erep.elucs.model.json.exchange.ExchangeInfo;
import com.erep.elucs.model.json.market.MarketInfo;
import com.erep.elucs.model.json.profile.UserProfile;
import com.erep.elucs.model.json.search.SearchedUser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.List;

public class DirectScanErepublikDataExtractor implements ErepublikDataExtractor {

    private final CountryInfoExtractor countryInfoExtractor;
    private ProfileInfoExtractor profileInfoExtractor;

    public DirectScanErepublikDataExtractor() {
        countryInfoExtractor = new CountryInfoExtractor();
        profileInfoExtractor = new ProfileInfoExtractor();
    }

    @Override
    public UserProfile getUserProfile(String profileId) {
        String uri = "http://www.erepublik.com/en/citizen/profile/" + profileId;
        try {
            URL url = new URL(uri);
            URLConnection urlConnection = url.openConnection();
            Document parse = Jsoup.parse(urlConnection.getInputStream(), "UTF-8", "http://www.erepublik.com");
            ProfileInfoExtractor.ExtraParams extraParams = new ProfileInfoExtractor.ExtraParams();
            extraParams.put("id", profileId);
            return profileInfoExtractor.extractUserProfile(parse, extraParams);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public EconInfo getEconInfo(String countryCode) {
        // TODO implement me.
        return null;
    }

    private String getNameFromDocument(Document parse) {
        Elements citizen_profile_header = parse.getElementsByClass("citizen_profile_header");

        Element first = citizen_profile_header.first();
        Element h2 = first.getElementsByTag("h2").first();
        return h2.text();
    }

    @Override
    public Battle getBattleInfo(String battleId) {
        // TODO implement me
        return null;
    }

    @Override
    public List<ExchangeInfo> getExchangeInfo(int type) {
        // TODO implement me
        return null;
    }

    @Override
    public List<SearchedUser> findUsers(String param) {
        // TODO implement me
        return null;
    }


    @Override
    public CountryInfo getCountryInfo(String countryCode) {
        CountryCode cc = CountryCode.fromCode(countryCode);
        if (cc != CountryCode.UNKNOWN) {
            String uri = "http://www.erepublik.com/en/country/society/" + cc.getLongName();
            try {
                Document parse = Jsoup.connect(uri).get();
                return countryInfoExtractor.extract(parse, countryCode);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<MarketInfo> getMarketInfo(String countryCode, String industry, Integer quality, Integer page) {
        // TODO implement me
        return null;

    }

    public static void main(String[] args) throws InterruptedException {
        DirectScanErepublikDataExtractor directScanErepublikDataExtractor = new DirectScanErepublikDataExtractor();
        for (Integer profileId : profileIds) {

            UserProfile userProfile = directScanErepublikDataExtractor.getUserProfile(profileId.toString());
            System.out.println("**************************************************************************");
            System.out.println("ID=" + userProfile.getId());
            System.out.println("NAME=" + userProfile.getName());
            System.out.println("LEVEL=" + userProfile.getLevel());
            System.out.println("EXPERIENCE=" + userProfile.getExperience());
            System.out.println("STRENGTH=" + userProfile.getStrength());
            System.out.println("RANK=" + userProfile.getRank().getPoints());
            System.out.println("RANKNAME=" + userProfile.getRank().getName());

            Thread.sleep(700);
        }
    }

    public static List<Integer> profileIds = Arrays.asList(
            5396197,
            4075295,
            5649615,
            5618926,
            5326372,
            413371,
            5719435,
            5215068,
            5092506,
            5145982,
            1806517,
            5297830,
            5025272,
            5388494,
            1317949,
            4392253,
            5647848,
            4647565,
            1501584,
            2748674,
            1638912,
            5428867,
            4945905,
            5693846,
            5678899,
            4691260,
            4352124,
            992322,
            6655857,
            6731571,
            5012826,
            1848291,
            5767439,
            4914673,
            3067212,
            7424080,
            4975967,
            2042042,
            4545349,
            2433776,
            5356874,
            4682613,
            2851658,
            1959625,
            4396217,
            7583794,
            5746639,
            2219670,
            6224555,
            2593535,
            1878314,
            2529834,
            1035732,
            478091,
            1523448,
            5388576,
            2878815,
            5185584,
            1461688,
            3845012,
            1432844,
            4689330,
            3509747,
            5440574,
            1999466,
            3900625,
            6431990,
            4076882,
            3450683,
            1472379,
            2218707,
            7238408,
            1640840,
            448252,
            1623270,
            1257037,
            7580798,
            3994096,
            2492504,
            4796115,
            6218569,
            5816686,
            1876025,
            5568656,
            7577107,
            4753819,
            4897473
    );

}
