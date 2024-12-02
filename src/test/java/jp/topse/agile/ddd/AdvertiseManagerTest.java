package jp.topse.agile.ddd;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class AdvertiseManagerTest {

    @Test
    public void enableToRegisterProduct() {
        AdvertiseManager manager = new AdvertiseManager();
        Product product = new Product("Coffee");

        int id = manager.registerProduct(product);
        Product check = manager.getProduct(id);

        assertThat(check.getName(), is("Coffee"));
    }

    @Test
    public void enableToRegisterAdvertise() {
        AdvertiseManager manager = new AdvertiseManager();
        Product product = new Product("Coffee");
        int productId = manager.registerProduct(product);

        Advertise advertise = new Advertise("coffee-01");
        int advertiseId = manager.registerAdvertise(productId, advertise);
        Advertise check = manager.getAdvertise(advertiseId);

        assertThat(check.getName(), is("coffee-01"));

    }
}
