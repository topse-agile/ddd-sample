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

        Advertise advertise = new Advertise(product);

        assertNotNull(advertise);
    }

    @Test
    public void testFailedToCreateAnAdvertiseWithoutProduct()
    {
        assertThrows(InvalidParameterException.class, new ThrowingRunnable() {
            @Override
            public void run() {
                new Advertise(null);
            }
        });
    }
}
