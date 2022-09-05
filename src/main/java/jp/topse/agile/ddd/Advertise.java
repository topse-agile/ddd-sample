package jp.topse.agile.ddd;

import java.security.InvalidParameterException;
import java.util.LinkedList;
import java.util.List;

public class Advertise {

    private Product product;
    private Media media;

    private List<DailyResult> results = new LinkedList<DailyResult>();
    public Advertise(Product product, Media media) {
        if (product == null) {
            throw new InvalidParameterException("Product is null");
        }
        if (media == null) {
            throw new InvalidParameterException("Media is null");
        }
        this.product = product;
        this.media = media;
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
