package com.infoshareacademy.jjdd4.wildhogs.data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "SHOPPING_LIST")
public class ShoppingListItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @NotNull
    private Recipe recipe;

    @ManyToOne(optional = false)
    @NotNull
    private User user;

    public ShoppingListItem() {
        id = -1l;
        recipe = null;
        user = null;
    }

    public ShoppingListItem(@NotNull Recipe recipe, @NotNull User user) {
        this.recipe = recipe;
        this.user = user;
    }

    public Recipe getRecipe() {
        return recipe;
    }

}
