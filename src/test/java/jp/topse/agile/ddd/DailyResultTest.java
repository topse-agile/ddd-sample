package jp.topse.agile.ddd;

import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class DailyResultTest {

    @Test
    public void DailyResultKeepsValues()
    {
        Date date = Calendar.getInstance().getTime();
        DailyResult dailyResult = new DailyResult(date,10000, 10);

        assertThat(dailyResult.getCost(), is(10000));
        assertThat(dailyResult.getConversion(), is(10));
    }

}
