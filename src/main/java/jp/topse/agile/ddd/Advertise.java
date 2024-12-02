package jp.topse.agile.ddd;

public class Advertise {
    private final Product product;

    private final String name;
    public Advertise(Product product, String name) {
        this.product = product;
        this.name = name;
    }

    public Product getProduct() {
        return product;
    }

    public String getName() {
        return name;
    }
}
