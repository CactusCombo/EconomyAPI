package io.github.cactuscombo;

/**
 * Created by CactusCombo on 06/03/2015.
 */

public class EconomyAPI {

    MoneyStorage moneystorage = MoneyStorage.getInstance();

    public double getBalance(String p) {
        return moneystorage.config.getDouble("balance." + p.toLowerCase());
    }

    public void addBalance(String p, double amnt) {
        setBalance(p, getBalance(p) + amnt);
    }

    public boolean removeBalance(String p, double amnt) {
        if (getBalance(p) - amnt < 0) return false;

        setBalance(p, getBalance(p) - amnt);
        return true;
    }

    public void setBalance(String p, double amnt) {
        moneystorage.config.set("balance." + p.toLowerCase(), amnt);
        moneystorage.save();

    }

}
