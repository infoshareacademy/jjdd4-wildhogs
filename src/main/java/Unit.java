public enum Unit {

    KILOGRAMS("kg"),
    GRAMS("g"),
    LITERS("l"),
    MILILITERS("ml"),
    CUP("cup"),
    CLOVES("cloves"),
    CENTIMETER("cm"),
    UNIT("unit");


    private String description;

    Unit (String desc){
        description=desc;
    }

    public String getDescription() {
        return description;
    }
}
