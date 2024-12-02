package jp.topse.agile.ddd;

import java.util.ArrayList;
import java.util.List;

public class AdvertiseManager {
    static class ProductAdvertise {
        public Product product;
        public Advertise advertise;

        public ProductAdvertise(Product product, Advertise advertise) {
            this.product = product;
            this.advertise = advertise;
        }
    }

    List<Product> products = new ArrayList<Product>();
    List<ProductAdvertise> productAdvertisePairs = new ArrayList<ProductAdvertise>();
    public int registerProduct(Product product) {
        products.add(product);
        return products.size();
    }

    public Product getProduct(int id) {
        return products.get(id - 1);
    }

    public int registerAdvertise(int productId, Advertise advertise) {
        Product product = this.getProduct(productId);
        productAdvertisePairs.add(new ProductAdvertise(product, advertise));
        return productAdvertisePairs.size();
    }

    public Advertise getAdvertise(int advertiseId) {
        ProductAdvertise productAdvertise = productAdvertisePairs.get(advertiseId - 1);
        return productAdvertise.advertise;
    }
}
