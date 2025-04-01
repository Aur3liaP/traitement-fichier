package fr.diginamic.foodFacts;

import java.util.List;
import java.util.Map;

public class Produit {
    private Categorie categorie;
    private Marque marque;
    private char scoreNutritionnel;
    private Map<String, Double> valeursNutritionnelles;
    private List<Ingredient> ingredients;
    private List<Additif> additifs;
    private List<Allergene> allergenes;

    public Produit(Categorie categorie, Marque marque, char scoreNutritionnel, Map<String, Double> valeursNutritionnelles, List<Ingredient> ingredients, List<Additif> additifs, List<Allergene> allergenes) {
        this.categorie = categorie;
        this.marque = marque;
        this.scoreNutritionnel = scoreNutritionnel;
        this.valeursNutritionnelles = valeursNutritionnelles;
        this.ingredients = ingredients;
        this.additifs = additifs;
        this.allergenes = allergenes;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Marque getMarque() {
        return marque;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    public char getScoreNutritionnel() {
        return scoreNutritionnel;
    }

    public void setScoreNutritionnel(char scoreNutritionnel) {
        this.scoreNutritionnel = scoreNutritionnel;
    }

    public Double getValeurNutritionnelle(String type) {
        return valeursNutritionnelles.getOrDefault(type, null);
    }

    public void setValeursNutritionnelles(Map<String, Double> valeursNutritionnelles) {
        this.valeursNutritionnelles = valeursNutritionnelles;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Additif> getAdditifs() {
        return additifs;
    }

    public void setAdditifs(List<Additif> additifs) {
        this.additifs = additifs;
    }

    public List<Allergene> getAllergenes() {
        return allergenes;
    }

    public void setAllergenes(List<Allergene> allergenes) {
        this.allergenes = allergenes;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Produit{");
        sb.append("categorie=").append(categorie);
        sb.append(", marque=").append(marque);
        sb.append(", scoreNutritionnel=").append(scoreNutritionnel);
        sb.append(", valeursNutritionnelles=").append(valeursNutritionnelles);
        sb.append(", ingredients=").append(ingredients);
        sb.append(", additifs=").append(additifs);
        sb.append(", allergenes=").append(allergenes);
        sb.append('}');
        return sb.toString();
    }
}
