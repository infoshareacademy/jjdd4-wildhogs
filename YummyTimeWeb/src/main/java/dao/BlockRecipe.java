package dao;

public class BlockRecipe {

    private final String name;
    private final String pathToPicture;

    public BlockRecipe(String name, String pathToPicture) {
        this.name = name;
        this.pathToPicture = pathToPicture;
    }

    public String getName() {
        return name;
    }

    public String getPathToPicture() {
        return pathToPicture;
    }
}
