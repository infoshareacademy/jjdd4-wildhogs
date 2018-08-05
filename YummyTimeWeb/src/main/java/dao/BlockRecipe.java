package dao;

public class BlockRecipe {

    private final Long id;
    private final String name;
    private final String pathToPicture;

    public BlockRecipe(String name, String pathToPicture, Long id) {
        this.name = name;
        this.pathToPicture = pathToPicture;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getPathToPicture() {
        return pathToPicture;
    }

    public Long getId() {
        return id;
    }
}
