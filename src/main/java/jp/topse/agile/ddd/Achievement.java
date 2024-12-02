package jp.topse.agile.ddd;

public class Achievement {
    private int count;
    private int cost;
    public Achievement(int count, int cost) {
        this.count = count;
        this.cost = cost;
    }

    public int getCount() {
        return count;
    }

    public int getCost() {
        return cost;
    }
}
