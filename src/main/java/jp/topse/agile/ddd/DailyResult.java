package jp.topse.agile.ddd;

import java.util.Date;

public class DailyResult {

    private Date date;

    private int cost = 0;

    private int conversion = 0;
    public DailyResult(Date date, int cost, int conversion) {
        this.date = date;
        this.cost = cost;
        this.conversion = conversion;
    }

    public int getCost() {
        return this.cost;
    }

    public int getConversion() {
        return this.conversion;
    }
}
