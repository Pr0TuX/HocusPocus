package com.erep.elucs.cmd;

import com.erep.elucs.extractor.ErepublikDataExtractor;
import com.erep.elucs.extractor.ErpkErepublikDataExtractor;
import com.erep.elucs.model.json.exchange.Seller;
import com.erep.elucs.model.json.market.MarketInfo;
import com.erep.elucs.util.Util;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.pircbotx.PircBotX;
import org.pircbotx.hooks.events.MessageEvent;

import java.util.List;

/**
 * @author dragos
 */
public class FoodCmd extends AbstractCmd {


    public static final String QUALITY_ARG = "q";
    public static final String COUNTRY_CODE_ARG = "c";
    public static final String INDUSTRY_TYPE = "food";
    public static final String PAGE_ARG = "p";

    public static final int TOP_OFFERS = 3;
    private final ErepublikDataExtractor erepublikDataExtractor;

    public FoodCmd(PircBotX botX) {
        this(botX, "food", "Displays first offers of food from a market specified by <country_code> and <quality>");
    }

    protected FoodCmd(PircBotX botX, String cmd, String desc) {
        super(botX, cmd, desc);
        erepublikDataExtractor = new ErpkErepublikDataExtractor();
    }

    @Override
    public void doLogic(CommandLine commandLine, MessageEvent event) {
        Object optionObject = commandLine.getOptionObject(QUALITY_ARG);
        Integer quality;
        String countryCode;
        Integer page = 1;

        if (optionObject instanceof Number) {
            Number optNumber = (Number) optionObject;
            quality = optNumber.intValue();
        } else {
            sendUsage(event);
            return;
        }

        String stringOpt = commandLine.getOptionValue(COUNTRY_CODE_ARG);
        if (Util.isEmpty(stringOpt)) {
            countryCode = stringOpt;
        } else {
            sendUsage(event);
            return;
        }

        Object pageArg = commandLine.getOptionObject(PAGE_ARG);
        if (pageArg instanceof Number) {
            page = ((Number) pageArg).intValue();
        }

        List<MarketInfo> foods = erepublikDataExtractor.getMarketInfo(countryCode, INDUSTRY_TYPE, quality, page);

        if (foods != null) {
            StringBuilder builder = new StringBuilder();
            builder.append(":: ").append(Util.toBold("Food offers for")).append("(first ").append(TOP_OFFERS).append(")").append(" q").append(quality);
            builder.append(" in ").append(countryCode.toUpperCase());
            int i = 0;
            for (MarketInfo food : foods) {

                if (i == TOP_OFFERS) {
                    break;
                }
                builder.append(" :: ").append(Util.toBold("Id ")).append(food.getId()).append(" ");
                builder.append(Util.toBold("Amount ")).append(food.getAmount()).append(" ");
                builder.append(Util.toBold("Price ")).append(food.getPrice()).append(" ");
                Seller seller = food.getSeller();
                builder.append(Util.toBold("Seller ")).append("[ ").append(Util.toBold("name ")).append(seller.getName()).append(" ");
                builder.append(Util.toBold("id ")).append(seller.getId()).append(" ]");
                i++;
            }
            sendMessage(event, builder.toString());
        } else {
            sendError(event, "No data received. Please try again later.");
        }

    }

    @Override
    protected Options getCmdOptions() {
        Options options = new Options();

        Option opt = new Option(QUALITY_ARG, "quality", true, "Specifies quality of food");
        opt.setRequired(true);
        opt.setType(Number.class);
        options.addOption(opt);

        opt = new Option(COUNTRY_CODE_ARG, "country_code", true, "Specifies country code");
        opt.setRequired(true);
        options.addOption(opt);

        opt = new Option(PAGE_ARG, "page", true, "Specifies page code");
        opt.setType(Number.class);
        options.addOption(opt);

        return options;
    }
}
