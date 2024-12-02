package jp.topse.agile.ddd;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class AdvertiseTest {
    @Test
    public void enableToCreateAdvertise() {
        Advertise advertise = new Advertise("coffee-01");

        assertThat(advertise.getName(), is("coffee-01"));
    }
}
