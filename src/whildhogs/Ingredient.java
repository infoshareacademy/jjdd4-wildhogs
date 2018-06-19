package whildhogs;

public class Ingredient {
    private String name;
    private double amount;
    private Units unit;


    public Ingredient (String name, double amount, Units unit) {
        this.name = name;
        this.amount = amount;
        this.unit = unit;
    }

    public Ingredient (String name, Units unit) {
        this(name, 0, unit);
    }


    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                ", unit=" + unit +
                '}';
    }
}
