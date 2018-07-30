package dao;

public class Statistic {

    private String name;
    private long quantity;

    public Statistic(String name, long quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public long getQuantity() {
        return quantity;
    }
}
