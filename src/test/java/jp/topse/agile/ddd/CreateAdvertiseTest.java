package jp.topse.agile.ddd;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

import org.junit.function.ThrowingRunnable;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

public class CreateAdvertiseTest
{
    @Test
    public void testEnableToCreateAnAdvertise()
    {
        Product product = new Product("SixPad");
        Media media = new Media("Google");

        Advertise advertise = new Advertise(product, media);

        assertNotNull(advertise);
    }

    @Test
    public void testFailedToCreateAnAdvertiseWithoutProduct()
    {
        final Media media = new Media("Google");

        assertThrows(InvalidParameterException.class, new ThrowingRunnable() {
            @Override
            public void run() {
                new Advertise(null, media);
            }
        });
    }

    @Test
    public void testFailedToCreateAnAdvertiseWithoutMedia()
    {
        final Product product = new Product("SixPad");

        assertThrows(InvalidParameterException.class, new ThrowingRunnable() {
            @Override
            public void run() {
                new Advertise(product, null);
            }
        });
    }
}
