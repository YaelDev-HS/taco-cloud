package com.taco.cloud.taco_cloud.entities;

import java.util.List;

public class TacoEntity {

    private String name;
    private List<IngredientEntity> ingredients;

    public TacoEntity(String name, List<IngredientEntity> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    public TacoEntity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<IngredientEntity> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientEntity> ingredients) {
        this.ingredients = ingredients;
    }

}
