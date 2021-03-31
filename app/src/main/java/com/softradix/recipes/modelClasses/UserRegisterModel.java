package com.softradix.recipes.modelClasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class UserRegisterModel implements Serializable {
    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("user")
    @Expose
    private User user;
    @SerializedName("goals")
    @Expose
    private List<Goal> goals = null;
    @SerializedName("cooking_levels")
    @Expose
    private List<CookingLevel> cookingLevels = null;
    @SerializedName("diet_categories")
    @Expose
    private List<DietCategory> dietCategories = null;
    @SerializedName("ingredient_categories")
    @Expose
    private List<IngredientCategory> ingredientCategories = null;
    @SerializedName("storage_types")
    @Expose
    private List<String> storageTypes = null;
    @SerializedName("units")
    @Expose
    private List<Unit> units = null;
    public List<Unit> getUnits() {
        return units;
    }

    public void setUnits(List<Unit> units) {
        this.units = units;
    }
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Goal> getGoals() {
        return goals;
    }

    public void setGoals(List<Goal> goals) {
        this.goals = goals;
    }

    public List<CookingLevel> getCookingLevels() {
        return cookingLevels;
    }

    public void setCookingLevels(List<CookingLevel> cookingLevels) {
        this.cookingLevels = cookingLevels;
    }

    public List<DietCategory> getDietCategories() {
        return dietCategories;
    }

    public void setDietCategories(List<DietCategory> dietCategories) {
        this.dietCategories = dietCategories;
    }

    public List<IngredientCategory> getIngredientCategories() {
        return ingredientCategories;
    }

    public void setIngredientCategories(List<IngredientCategory> ingredientCategories) {
        this.ingredientCategories = ingredientCategories;
    }

    public List<String> getStorageTypes() {
        return storageTypes;
    }

    public void setStorageTypes(List<String> storageTypes) {
        this.storageTypes = storageTypes;
    }

    public class Goal implements Serializable {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("goal_name")
        @Expose
        private String goalName;

        boolean isSelected = false;

        public boolean isSelected() {
            return isSelected;
        }

        public void setSelected(boolean selected) {
            isSelected = selected;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getGoalName() {
            return goalName;
        }

        public void setGoalName(String goalName) {
            this.goalName = goalName;
        }

    }

    public class Allergy implements Serializable {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("item_name")
        @Expose
        private String itemName;
        @SerializedName("item_image")
        @Expose
        private String itemImage;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getItemName() {
            return itemName;
        }

        public void setItemName(String itemName) {
            this.itemName = itemName;
        }

        public String getItemImage() {
            return itemImage;
        }

        public void setItemImage(String itemImage) {
            this.itemImage = itemImage;
        }

    }

    public class Unit implements Serializable {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("unit")
        @Expose
        private String unit;

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

    }

    public class IngredientCategory implements Serializable {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("category_name")
        @Expose
        private String categoryName;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;

        boolean isSelected = false;

        public boolean isSelected() {
            return isSelected;
        }

        public void setSelected(boolean selected) {
            isSelected = selected;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getCategoryName() {
            return categoryName;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

    }

    public class User implements Serializable {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("email")
        @Expose
        private String email;
        @SerializedName("email_verified_at")
        @Expose
        private Object emailVerifiedAt;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;
        @SerializedName("type")
        @Expose
        private String type;
        @SerializedName("last_name")
        @Expose
        private String lastName;
        @SerializedName("goals")
        @Expose
        private List<Object> goals = null;
        @SerializedName("diet_category")
        @Expose
        private Object dietCategory;
        @SerializedName("cooking_level")
        @Expose
        private Object cookingLevel;
        @SerializedName("allergies")
        @Expose
        private List<Object> allergies = null;
        @SerializedName("cook_for_people")
        @Expose
        private String cookForPeople;
        @SerializedName("deleted_at")
        @Expose
        private Object deletedAt;
        @SerializedName("ingredients_donot_like")
        @Expose
        private Object ingredientsDonotLike;
        @SerializedName("otp")
        @Expose
        private Object otp;
        @SerializedName("user_picture")
        @Expose
        private Object userPicture;
        @SerializedName("push_notification")
        @Expose
        private String pushNotification;
        @SerializedName("donot_like")
        @Expose
        private List<Object> donotLike = null;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Object getEmailVerifiedAt() {
            return emailVerifiedAt;
        }

        public void setEmailVerifiedAt(Object emailVerifiedAt) {
            this.emailVerifiedAt = emailVerifiedAt;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public List<Object> getGoals() {
            return goals;
        }

        public void setGoals(List<Object> goals) {
            this.goals = goals;
        }

        public Object getDietCategory() {
            return dietCategory;
        }

        public void setDietCategory(Object dietCategory) {
            this.dietCategory = dietCategory;
        }

        public Object getCookingLevel() {
            return cookingLevel;
        }

        public void setCookingLevel(Object cookingLevel) {
            this.cookingLevel = cookingLevel;
        }

        public List<Object> getAllergies() {
            return allergies;
        }

        public void setAllergies(List<Object> allergies) {
            this.allergies = allergies;
        }

        public String getCookForPeople() {
            return cookForPeople;
        }

        public void setCookForPeople(String cookForPeople) {
            this.cookForPeople = cookForPeople;
        }

        public Object getDeletedAt() {
            return deletedAt;
        }

        public void setDeletedAt(Object deletedAt) {
            this.deletedAt = deletedAt;
        }

        public Object getIngredientsDonotLike() {
            return ingredientsDonotLike;
        }

        public void setIngredientsDonotLike(Object ingredientsDonotLike) {
            this.ingredientsDonotLike = ingredientsDonotLike;
        }

        public Object getOtp() {
            return otp;
        }

        public void setOtp(Object otp) {
            this.otp = otp;
        }

        public Object getUserPicture() {
            return userPicture;
        }

        public void setUserPicture(Object userPicture) {
            this.userPicture = userPicture;
        }

        public String getPushNotification() {
            return pushNotification;
        }

        public void setPushNotification(String pushNotification) {
            this.pushNotification = pushNotification;
        }

        public List<Object> getDonotLike() {
            return donotLike;
        }

        public void setDonotLike(List<Object> donotLike) {
            this.donotLike = donotLike;
        }

    }

    public class CookingLevel implements Serializable {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("level_name")
        @Expose
        private String levelName;
        @SerializedName("description")
        @Expose
        private String description;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getLevelName() {
            return levelName;
        }

        public void setLevelName(String levelName) {
            this.levelName = levelName;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

    }

    public class DonotLike implements Serializable {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("item_name")
        @Expose
        private String itemName;
        @SerializedName("item_image")
        @Expose
        private String itemImage;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getItemName() {
            return itemName;
        }

        public void setItemName(String itemName) {
            this.itemName = itemName;
        }

        public String getItemImage() {
            return itemImage;
        }

        public void setItemImage(String itemImage) {
            this.itemImage = itemImage;
        }

    }

    public class DietCategory implements Serializable {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("diet_category_name")
        @Expose
        private String dietCategoryName;
        @SerializedName("diet_category_description")
        @Expose
        private String dietCategoryDescription;
        @SerializedName("deleted_at")
        @Expose
        private Object deletedAt;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getDietCategoryName() {
            return dietCategoryName;
        }

        public void setDietCategoryName(String dietCategoryName) {
            this.dietCategoryName = dietCategoryName;
        }

        public String getDietCategoryDescription() {
            return dietCategoryDescription;
        }

        public void setDietCategoryDescription(String dietCategoryDescription) {
            this.dietCategoryDescription = dietCategoryDescription;
        }

        public Object getDeletedAt() {
            return deletedAt;
        }

        public void setDeletedAt(Object deletedAt) {
            this.deletedAt = deletedAt;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

    }
}
