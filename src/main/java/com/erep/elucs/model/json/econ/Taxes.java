package com.erep.elucs.model.json.econ;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * @author dragos
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Taxes {
    private Tax food;
    private Tax weapons;
    private Tax tickets;
    private Tax frm;
    private Tax wrm;
    private Tax hospital;
    private Tax defense;

    public Taxes() {
    }

    public Tax getFood() {
        return food;
    }

    public void setFood(Tax food) {
        this.food = food;
    }

    public Tax getWeapons() {
        return weapons;
    }

    public void setWeapons(Tax weapons) {
        this.weapons = weapons;
    }

    public Tax getTickets() {
        return tickets;
    }

    public void setTickets(Tax tickets) {
        this.tickets = tickets;
    }

    public Tax getFrm() {
        return frm;
    }

    public void setFrm(Tax frm) {
        this.frm = frm;
    }

    public Tax getWrm() {
        return wrm;
    }

    public void setWrm(Tax wrm) {
        this.wrm = wrm;
    }

    public Tax getHospital() {
        return hospital;
    }

    public void setHospital(Tax hospital) {
        this.hospital = hospital;
    }

    public Tax getDefense() {
        return defense;
    }

    public void setDefense(Tax defense) {
        this.defense = defense;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    static class Tax {
        private Double income;
        private Double _import;
        private Double vat;

        private Tax() {
        }

        public Double getIncome() {
            return income;
        }

        public void setIncome(Double income) {
            this.income = income;
        }

        public Double getImport() {
            return _import;
        }

        public void setImport(Double _import) {
            this._import = _import;
        }

        public Double getVat() {
            return vat;
        }

        public void setVat(Double vat) {
            this.vat = vat;
        }
    }
}
