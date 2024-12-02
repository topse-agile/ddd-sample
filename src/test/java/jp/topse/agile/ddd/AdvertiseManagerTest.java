package jp.topse.agile.ddd;

import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

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

    @Test
    public void enableToRegisterAdvertiseAchievement() {
        AdvertiseManager manager = new AdvertiseManager();
        Product product = new Product("Coffee");
        int productId = manager.registerProduct(product);
        Advertise advertise = new Advertise("coffee-01");
        int advertiseId = manager.registerAdvertise(productId, advertise);

        Calendar calendar = Calendar.getInstance();
        calendar.set(2024, 11, 2);
        Date date = calendar.getTime();

        manager.recordAchievement(advertiseId, date, 200, 10000);
        Achievement achievement = manager.getAchievement(advertiseId, date);

        assertThat(achievement.getCount(), is(200));
        assertThat(achievement.getCost(), is(10000));
    }


    @Test
    public void calculateAdvertiseCost() {
        AdvertiseManager manager = new AdvertiseManager();
        Product product = new Product("Coffee");
        int productId = manager.registerProduct(product);
        Advertise advertise = new Advertise("coffee-01");
        int advertiseId = manager.registerAdvertise(productId, advertise);

        Calendar calendar = Calendar.getInstance();
        calendar.set(2024, 11, 2);
        manager.recordAchievement(advertiseId, calendar.getTime(), 200, 10000);
        calendar.set(2024, 11, 1);
        manager.recordAchievement(advertiseId, calendar.getTime(), 300, 12000);

        Achievement achievement = manager.getAdvertiseAchievement(advertiseId, 2024, 12);

        assertThat(achievement.getCount(), is(500));
        assertThat(achievement.getCost(), is(22000));
    }
}
