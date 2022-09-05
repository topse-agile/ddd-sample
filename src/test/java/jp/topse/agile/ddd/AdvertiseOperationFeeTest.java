package jp.topse.agile.ddd;

import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class AdvertiseOperationFeeTest {

    @Test
    public void Get20PercentOf1DailyResult()
    {
        Product product = new Product("SixPad");
        Media media = new Media("Google");
        Advertise advertise = new Advertise(product, media);
        Date today = Calendar.getInstance().getTime();
        advertise.record(new DailyResult(today, 5000, 3));

        int operationFee = advertise.getOperationFee();

        assertThat(operationFee, is(1000));
    }

    @Test
    public void Get20PercentOf2DailyResults()
    {
        Product product = new Product("SixPad");
        Media media = new Media("Google");
        Advertise advertise = new Advertise(product, media);
        Date today = Calendar.getInstance().getTime();
        advertise.record(new DailyResult(today, 5000, 3));
        advertise.record(new DailyResult(today, 7000, 5));

        int operationFee = advertise.getOperationFee();

        assertThat(operationFee, is(2400));
    }
}
