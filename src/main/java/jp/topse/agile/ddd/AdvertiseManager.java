package jp.topse.agile.ddd;

import java.util.*;

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

    Map<Integer, Map<Date, Achievement>> achievements = new HashMap<Integer, Map<Date, Achievement>>();
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

    public void recordAchievement(int advertiseId, Date date, int count, int cost) {
        Map<Date, Achievement> advertiseAchievements = achievements.get(advertiseId);
        if (advertiseAchievements == null) {
            advertiseAchievements = new HashMap<Date, Achievement>();
            achievements.put(advertiseId, advertiseAchievements);
        }
        advertiseAchievements.put(date, new Achievement(count, cost));
    }

    public Achievement getAchievement(int advertiseId, Date date) {
        Map<Date, Achievement> advertiseAchievements = achievements.get(advertiseId);
        return advertiseAchievements.get(date);
    }

    public Achievement getAdvertiseAchievement(int advertiseId, int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, 1);

        int count = 0;
        int cost = 0;
        int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (int i = 1; i <= maxDay; ++i) {
            calendar.set(Calendar.DATE, i);
            Achievement achievement = getAchievement(advertiseId, calendar.getTime());
            if (achievement != null) {
                count += achievement.getCount();
                cost += achievement.getCost();
            }
        }
        return new Achievement(count, cost);
    }
}
