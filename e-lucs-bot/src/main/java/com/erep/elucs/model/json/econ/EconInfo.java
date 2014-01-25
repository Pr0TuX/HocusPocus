package com.erep.elucs.model.json.econ;

import com.erep.elucs.util.Util;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * @author dragos
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class EconInfo {
    private String name;
    private String code;
    private Treasury treasury;
    private Bonuses bonuses;
    private Taxes taxes;

    public EconInfo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Treasury getTreasury() {
        return treasury;
    }

    public void setTreasury(Treasury treasury) {
        this.treasury = treasury;
    }

    public Bonuses getBonuses() {
        return bonuses;
    }

    public void setBonuses(Bonuses bonuses) {
        this.bonuses = bonuses;
    }

    public Taxes getTaxes() {
        return taxes;
    }

    public void setTaxes(Taxes taxes) {
        this.taxes = taxes;
    }

    public String toBasicInfo() {
        if (bonuses == null || treasury == null || taxes == null) {
            return "Could not retrieve data";
        }

        return ":: " + Util.toBold("Name ") + name + "(" + code + ")" +
                " :: " + Util.toBold("CC ") + treasury.getCc() +
                " :: " + Util.toBold("Gold ") + treasury.getGold() +
                " :: " + Util.toBold("Food ") + Util.getPercent(bonuses.getFood()) + "% " +
                "[income " + Util.toString(taxes.getFood().getIncome(), "0") + "% " +
                "import " + Util.toString(taxes.getFood().getImport(), "0") + "% " +
                "vat " + Util.toString(taxes.getFood().getVat(), "0") + "%]" +
                " :: " + Util.toBold("Weapons ") + Util.getPercent(bonuses.getWeapons()) + "% " +
                "[income " + Util.toString(taxes.getWeapons().getIncome(), "0") + "% " +
                "import " + Util.toString(taxes.getWeapons().getImport(), "0") + "% " +
                "vat " + Util.toString(taxes.getWeapons().getVat(), "0") + "%]" +
                " :: " + Util.toBold("WRM ") +
                "[income " + Util.toString(taxes.getWrm().getIncome(), "0") + "% " +
                "import " + Util.toString(taxes.getWrm().getImport(), "0") + "% " +
                "vat " + Util.toString(taxes.getWrm().getVat(), "0") + "%]" +
                " :: " + Util.toBold("FRM ") +
                "[income " + Util.toString(taxes.getFrm().getIncome(), "0") + "% " +
                "import " + Util.toString(taxes.getFrm().getImport(), "0") + "% " +
                "vat " + Util.toString(taxes.getFrm().getVat(), "0") + "%]";
    }
}
