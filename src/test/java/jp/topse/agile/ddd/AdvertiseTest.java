package jp.topse.agile.ddd;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class AdvertiseTest {
    @Test
    public void enableToCreateAdvertise() {
        Product product = new Product("Coffee");

        Advertise advertise = new Advertise(product, "coffee-01");

        assertThat(advertise.getName(), is("coffee-01"));
        assertThat(advertise.getProduct().getName(), is("Coffee"));
    }
}
