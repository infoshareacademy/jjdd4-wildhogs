package com.infoshareacademy.jjdd4.wildhogs.data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;

@Entity
@Table(name = "RECIPES")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="likes")
    @NotNull
    private int likes;

    @Column(name="name")
    @NotNull
    private String name;

    @Column(name="path_to_picture")
    private String pathToPicture = "";

    @Column(name="category")
    @NotNull
    private Category category;

    @Column(name="description", length=20000)
    @NotNull
    private String description;

    @OneToMany(mappedBy = "recipe", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<Ingredient> ingredientsList;

    public Recipe() {
    }

    public Recipe(String name, Category category, String description) {
        this.name = name;
        this.category = category;
        this.description = description;
        ingredientsList = new ArrayList<>();
        likes=0;
    }

//    public Recipe(void aVoid) {
//        this.getDescription(); //FOR RecipesProviderFromJSONTest
//    }

    public void addIngredient(Ingredient ingredient) {
        ingredientsList.add(ingredient);
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "name='" + name + '\'' +
                "url='" + pathToPicture + '\'' +
                ", category=" + category +
                ", description='" + description + '\'' +
                ", ingredientsList=" + ingredientsList +
                ", likes= "+likes+
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return Objects.equals(name, recipe.name) &&
                Objects.equals(category, recipe.category) &&
                Objects.equals(description, recipe.description) &&
                Objects.equals(ingredientsList, recipe.ingredientsList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, category, description, ingredientsList);
    }


    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public List<Ingredient> getIngredientsList() {
        return ingredientsList;
    }

    public String getPathToPicture() {
        return pathToPicture;
    }

    public void setPathToPicture(String pathToPicture) {
        this.pathToPicture = pathToPicture;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIngredientsList(List<Ingredient> ingredientsList) {
        this.ingredientsList = ingredientsList;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
