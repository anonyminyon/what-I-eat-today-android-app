package com.trhiep.homnayangi.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ingredient {
    @SerializedName("ingredientId")
    @Expose
    private Integer ingredientId;
    @SerializedName("ingredientName")
    @Expose
    private String ingredientName;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("createdBy")
    @Expose
    private Object createdBy;

    public Ingredient() {
    }

    public Ingredient(Integer ingredientId, String ingredientName, String description, Object createdBy) {
        this.ingredientId = ingredientId;
        this.ingredientName = ingredientName;
        this.description = description;
        this.createdBy = createdBy;
    }

    public Integer getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Integer ingredientId) {
        this.ingredientId = ingredientId;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Object createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "ingredientId=" + ingredientId +
                ", ingredientName='" + ingredientName + '\'' +
                ", description='" + description + '\'' +
                ", createdBy=" + createdBy +
                '}';
    }
}
