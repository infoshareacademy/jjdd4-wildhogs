package whildhogs;

import java.util.*;

public class Recipe {
    private String title;
    private String instruction;
    // breakfast, dinner, dessert, italian
    private Set<String> keywords;

    private Map<String, Ingredient> ingredientsMap;



    public Recipe(String title, String instruction) {
        this.title = title;
        this.instruction = instruction;
        ingredientsMap = new HashMap<>();
        keywords = new HashSet<>();
    }

    //PUT & ADD
    public void putIntoIngredientsMap(Ingredient ingredient) {
        this.ingredientsMap.put(ingredient.getName(), ingredient) ;
    }

    public void addToKeywords(String keyword) {
        this.keywords.add(keyword);
    }


    // GET
    public String getTitle() {
        return title;
    }

    public String getInstruction() {
        return instruction;
    }

    public Map<String, Ingredient> getIngredientsMap() {
        return ingredientsMap;
    }

    public Set<String> getKeywords() {
        return keywords;
    }





}
