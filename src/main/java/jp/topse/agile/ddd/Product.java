package jp.topse.agile.ddd;

public class Product {
    private final String name;
    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
