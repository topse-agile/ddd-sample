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
        Advertise advertise = new Advertise(product);
        Date today = Calendar.getInstance().getTime();
        advertise.record(new DailyResult(today, 5000, 3));

        int operationFee = advertise.getOperationFee();

        assertThat(operationFee, is(1000));
    }

    @Test
    public void Get20PercentOf2DailyResults()
    {
        Product product = new Product("SixPad");
        Advertise advertise = new Advertise(product);
        Calendar day = Calendar.getInstance();
        Date d1 = day.getTime();
        advertise.record(new DailyResult(d1, 5000, 3));
        day.add(Calendar.DATE, 1);
        Date d2 = day.getTime();
        advertise.record(new DailyResult(d2, 7000, 5));

        int operationFee = advertise.getOperationFee();

        assertThat(operationFee, is(2400));
    }
}
