package igor.com.calories.Items;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Component;

@JsonIgnoreProperties(ignoreUnknown = true)
@Component
public class NutritionItem {
    private String name;
    private Double calories;
    private Double serving_size_g;
    private Double fat_total_g;
    private Double fat_saturated_g;
    private Double protein_g;
    private Double sodium_mg;
    private Double potassium_mg;
    private Double cholesterol_mg;
    private Double carbohydrates_total_g;
    private Double fiber_g;
    private Double sugar_g;

    public NutritionItem() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCalories() {
        return calories;
    }

    public void setCalories(Double calories) {
        this.calories = calories;
    }

    public Double getServing_size_g() {
        return serving_size_g;
    }

    public void setServing_size_g(Double serving_size_g) {
        this.serving_size_g = serving_size_g;
    }

    public Double getFat_total_g() {
        return fat_total_g;
    }

    public void setFat_total_g(Double fat_total_g) {
        this.fat_total_g = fat_total_g;
    }

    public Double getFat_saturated_g() {
        return fat_saturated_g;
    }

    public void setFat_saturated_g(Double fat_saturated_g) {
        this.fat_saturated_g = fat_saturated_g;
    }

    public Double getProtein_g() {
        return protein_g;
    }

    public void setProtein_g(Double protein_g) {
        this.protein_g = protein_g;
    }

    public Double getSodium_mg() {
        return sodium_mg;
    }

    public void setSodium_mg(Double sodium_mg) {
        this.sodium_mg = sodium_mg;
    }

    public Double getPotassium_mg() {
        return potassium_mg;
    }

    public void setPotassium_mg(Double potassium_mg) {
        this.potassium_mg = potassium_mg;
    }

    public Double getCholesterol_mg() {
        return cholesterol_mg;
    }

    public void setCholesterol_mg(Double cholesterol_mg) {
        this.cholesterol_mg = cholesterol_mg;
    }

    public Double getCarbohydrates_total_g() {
        return carbohydrates_total_g;
    }

    public void setCarbohydrates_total_g(Double carbohydrates_total_g) {
        this.carbohydrates_total_g = carbohydrates_total_g;
    }

    public Double getFiber_g() {
        return fiber_g;
    }

    public void setFiber_g(Double fiber_g) {
        this.fiber_g = fiber_g;
    }

    public Double getSugar_g() {
        return sugar_g;
    }

    public void setSugar_g(Double sugar_g) {
        this.sugar_g = sugar_g;
    }

    @Override
    public String toString() {
        return "NutritionItem{" +
                "name='" + name + '\'' +
                ", calories=" + calories +
                ", serving_size_g=" + serving_size_g +
                ", fat_total_g=" + fat_total_g +
                ", fat_saturated_g=" + fat_saturated_g +
                ", protein_g=" + protein_g +
                ", sodium_mg=" + sodium_mg +
                ", potassium_mg=" + potassium_mg +
                ", cholesterol_mg=" + cholesterol_mg +
                ", carbohydrates_total_g=" + carbohydrates_total_g +
                ", fiber_g=" + fiber_g +
                ", sugar_g=" + sugar_g +
                '}';
    }
}
