package com.infoshareacademy.jjdd4.wildhogs.data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "INGREDIENTS")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "amount")
    @NotNull
    private double amount;

    @Column(name = "unit")
    @NotNull
    private Unit unit;

    @ManyToOne()
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;


    public Ingredient() {
    }

    public Ingredient(String name, double amount, Unit unit, Recipe recipe) {
        this.name = name;
        this.amount = amount;
        this.unit = unit;
        this.recipe = recipe;
    }

    public Ingredient(String name, double amount, Unit unit) {
        this.name = name;
        this.amount = amount;
        this.unit = unit;

    }

    public Ingredient(Ingredient ingredient) {
        this.name = ingredient.name;
        this.amount = ingredient.amount;
        this.unit = ingredient.unit;
    }

    @Override
    public String toString() {
        return name + " - " + amount + " " + unit.getDescription();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ingredient)) return false;
        Ingredient that = (Ingredient) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, amount, unit);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public void multiplyAmount(int multi) {
        amount *= multi;
    }

    public void addToAmount(double adder) {
        amount += adder;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}