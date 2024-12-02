package jp.topse.agile.ddd;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class ProductTest {
    @Test
    public void enableToCreateProduct() {
        Product product = new Product("Coffee");

        assertThat(product.getName(), is("Coffee"));
    }
}
