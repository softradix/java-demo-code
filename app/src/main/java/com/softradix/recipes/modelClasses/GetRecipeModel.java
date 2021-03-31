package com.softradix.recipes.modelClasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class GetRecipeModel implements Serializable {
    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("current_page")
    @Expose
    private Integer currentPage;
    @SerializedName("last_page")
    @Expose
    private Integer lastPage;
    @SerializedName("total_results")
    @Expose
    private Integer totalResults;
    @SerializedName("recipes")
    @Expose
    private List<Recipe> recipes = null;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getLastPage() {
        return lastPage;
    }

    public void setLastPage(Integer lastPage) {
        this.lastPage = lastPage;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    public class Ingredient implements Serializable {

        @SerializedName("ingredient_id")
        @Expose
        private Integer ingredientId;
        @SerializedName("ingredient_name")
        @Expose
        private String ingredientName;
        @SerializedName("ingredient_description")
        @Expose
        private String ingredientDescription;
        @SerializedName("ingredient_storage_type")
        @Expose
        private List<IngredientStorageType> ingredientStorageType = null;
        @SerializedName("quantity")
        @Expose
        private String quantity;
        @SerializedName("is_available")
        @Expose
        private Integer isAvailable;
        String calculatedQuantity;
        @SerializedName("user_quantity")
        @Expose
        private String userQuantity;
        Integer missingStatus;
        @SerializedName("unit")
        @Expose
        private Unit unit;

        public Integer getMissingStatus() {
            return missingStatus;
        }

        public void setMissingStatus(Integer missingStatus) {
            this.missingStatus = missingStatus;
        }

        public String getUserQuantity() {
            return userQuantity;
        }

        public void setUserQuantity(String userQuantity) {
            this.userQuantity = userQuantity;
        }

        public Unit getUnit() {
            return unit;
        }
        public void setUnit(Unit unit) {
            this.unit = unit;
        }

        public String getCalculatedQuantity() {
            return calculatedQuantity;
        }

        public void setCalculatedQuantity(String calculatedQuantity) {
            this.calculatedQuantity = calculatedQuantity;
        }

        public Integer getIsAvailable() {
            return isAvailable;
        }

        public void setIsAvailable(Integer isAvailable) {
            this.isAvailable = isAvailable;
        }

        boolean isSelected = false;

        public boolean isSelected() {
            return isSelected;
        }

        public void setSelected(boolean selected) {
            isSelected = selected;
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

        public String getIngredientDescription() {
            return ingredientDescription;
        }

        public void setIngredientDescription(String ingredientDescription) {
            this.ingredientDescription = ingredientDescription;
        }

        public List<IngredientStorageType> getIngredientStorageType() {
            return ingredientStorageType;
        }

        public void setIngredientStorageType(List<IngredientStorageType> ingredientStorageType) {
            this.ingredientStorageType = ingredientStorageType;
        }

        public String getQuantity() {
            return quantity;
        }

        public void setQuantity(String quantity) {
            this.quantity = quantity;
        }

    }

    public class IngredientStorageType implements Serializable {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("item_id")
        @Expose
        private String itemId;
        @SerializedName("storage_type")
        @Expose
        private StorageType storageType;
        @SerializedName("expire_days")
        @Expose
        private String expireDays;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getItemId() {
            return itemId;
        }

        public void setItemId(String itemId) {
            this.itemId = itemId;
        }

        public StorageType getStorageType() {
            return storageType;
        }

        public void setStorageType(StorageType storageType) {
            this.storageType = storageType;
        }

        public String getExpireDays() {
            return expireDays;
        }

        public void setExpireDays(String expireDays) {
            this.expireDays = expireDays;
        }

    }

    public class StorageType implements Serializable {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("storage_name")
        @Expose
        private String storageName;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getStorageName() {
            return storageName;
        }

        public void setStorageName(String storageName) {
            this.storageName = storageName;
        }

    }

    public class Unit implements Serializable {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("unit")
        @Expose
        private String unit;
        @SerializedName("created_at")
        @Expose
        private Object createdAt;
        @SerializedName("updated_at")
        @Expose
        private Object updatedAt;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public Object getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(Object createdAt) {
            this.createdAt = createdAt;
        }

        public Object getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(Object updatedAt) {
            this.updatedAt = updatedAt;
        }

    }

    public static class Recipe implements Serializable {

        @SerializedName("receipe_id")
        @Expose
        private Integer receipeId;
        @SerializedName("receipe_name")
        @Expose
        private String receipeName;
        @SerializedName("cooking_time")
        @Expose
        private String cookingTime;
        @SerializedName("directions")
        @Expose
        private String directions;
        @SerializedName("receipe_image")
        @Expose
        private String receipeImage;
        @SerializedName("dish")
        @Expose
        private String dish;
        @SerializedName("diet")
        @Expose
        private String diet;
        @SerializedName("cuisine")
        @Expose
        private String cuisine;
        @SerializedName("is_favourite")
        @Expose
        private Integer isFavourite;
        @SerializedName("ingredients")
        @Expose
        private List<Ingredient> ingredients = null;
        @SerializedName("ingredients_count")
        @Expose
        private Integer ingredientsCount = 0;

        public Integer getIngredientsCount() {
            return ingredientsCount;
        }

        public void setIngredientsCount(Integer ingredientsCount) {
            this.ingredientsCount = ingredientsCount;
        }

        public Integer getReceipeId() {
            return receipeId;
        }

        public void setReceipeId(Integer receipeId) {
            this.receipeId = receipeId;
        }

        public String getReceipeName() {
            return receipeName;
        }

        public void setReceipeName(String receipeName) {
            this.receipeName = receipeName;
        }

        public String getCookingTime() {
            return cookingTime;
        }

        public void setCookingTime(String cookingTime) {
            this.cookingTime = cookingTime;
        }

        public String getDirections() {
            return directions;
        }

        public void setDirections(String directions) {
            this.directions = directions;
        }

        public String getReceipeImage() {
            return receipeImage;
        }

        public void setReceipeImage(String receipeImage) {
            this.receipeImage = receipeImage;
        }

        public String getDish() {
            return dish;
        }

        public void setDish(String dish) {
            this.dish = dish;
        }

        public String getDiet() {
            return diet;
        }

        public void setDiet(String diet) {
            this.diet = diet;
        }

        public String getCuisine() {
            return cuisine;
        }

        public void setCuisine(String cuisine) {
            this.cuisine = cuisine;
        }

        public Integer getIsFavourite() {
            return isFavourite;
        }

        public void setIsFavourite(Integer isFavourite) {
            this.isFavourite = isFavourite;
        }

        public List<Ingredient> getIngredients() {
            return ingredients;
        }

        public void setIngredients(List<Ingredient> ingredients) {
            this.ingredients = ingredients;
        }

    }

}
