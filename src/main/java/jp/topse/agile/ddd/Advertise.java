package jp.topse.agile.ddd;

import java.security.InvalidParameterException;
import java.util.LinkedList;
import java.util.List;

public class Advertise {

    private Product product;
    private List<DailyResult> results = new LinkedList<DailyResult>();
    public Advertise(Product product) {
        if (product == null) {
            throw new InvalidParameterException("Product is null");
        }
        this.product = product;
    }

    public void record(DailyResult dailyResult) {
        results.add(dailyResult);
    }

    public int getOperationFee() {
        int total = 0;
        for (DailyResult dailyResult : results) {
            total += dailyResult.getCost();
        }
        return (int)(total * 0.2);
    }
}
