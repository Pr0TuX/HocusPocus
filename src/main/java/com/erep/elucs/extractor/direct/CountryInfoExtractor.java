package com.erep.elucs.extractor.direct;

import com.erep.elucs.model.json.country.CountryInfo;
import com.erep.elucs.util.Util;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author dragos
 */
public class CountryInfoExtractor {

    public CountryInfo extract(Document parse, String countryCode) {


        CountryInfo countryInfo = new CountryInfo();

        countryInfo.setId(getCountryId(parse, countryCode));
        countryInfo.setCode(countryCode);
        countryInfo.setName(getCountryName(parse));
        countryInfo.setActive_citizens(getActiveCitizens(parse));
        countryInfo.setAverage_citizen_level(getAverageCitizens(parse));
        countryInfo.setCitizen_fee(getCitizensFee(parse));
        countryInfo.setNew_citizens_today(getNewCitizensToday(parse));
        countryInfo.setOnline_now(getOnlineCitizens(parse));
        countryInfo.setRegion_count(getRegionCount(parse));

        return countryInfo;
    }

    private Integer getRegionCount(Document parse) {
        try {
            Elements select = parse.select("div#content h2.section");
            Element element = select.get(1);
            String text = element.text();
            int first = text.indexOf("(");
            if (first > 0) {
                text = text.substring(first + 1, text.length() - 1);
                return Util.toInt(text);
            }
        } catch (Exception ex) {
            // ignored
        }
        return null;
    }

    private Integer getOnlineCitizens(Document parse) {
        try {
            Elements onlineCitizens = parse.select(".citizens.largepadded tr:eq(5) td:eq(2) span:eq(0)");
            return Util.toInt(onlineCitizens.text());
        } catch (Exception ex) {
            // ignored
        }
        return null;
    }

    private Integer getNewCitizensToday(Document parse) {
        try {
            Elements newCitizensToday = parse.select(".citizens.largepadded tr:eq(2) td:eq(2) span");
            return Util.toInt(newCitizensToday.text());
        } catch (Exception ex) {
            // ignored
        }
        return null;
    }

    private Integer getCitizensFee(Document parse) {
        return null; // not used right now
    }

    private Integer getAverageCitizens(Document parse) {
        try {
            Elements newCitizensToday = parse.select(".citizens.largepadded tr:eq(4) td:eq(2) span");
            return Util.toInt(newCitizensToday.text());
        } catch (Exception ex) {
            return null;
        }
    }

    private Integer getCountryId(Document parse, String countryCode) {
        try {
            CountryCode cc = CountryCode.fromCode(countryCode);
            String uri = "http://www.erepublik.com/en/country/society/" + cc.getLongName();
            String cssQuery = "div.core a[href=" + uri + "]";
            Elements idAnchor = parse.select(cssQuery);
            return Util.toInt(idAnchor.attr("id"));
        } catch (Exception ex) {
            // ignored
        }
        return null;
    }

    private Integer getActiveCitizens(Document parse) {
        Elements activeCitizens = parse.select(".citizens.largepadded tr:eq(1) td:eq(2) span");
        String activeCitizensText = activeCitizens.text();
        return Util.toInt(activeCitizensText);
    }

    private String getCountryName(Document parse) {
        Elements select = parse.select("#profileholder h1");
        return select.text();
    }
}
