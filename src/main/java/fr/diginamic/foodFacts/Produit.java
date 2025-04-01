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

    public Marque getMarque() {
        return marque;
    }

    public char getScoreNutritionnel() {
        return scoreNutritionnel;
    }

    public List<Additif> getAdditifs() {
        return additifs;
    }

    public List<Allergene> getAllergenes() {
        return allergenes;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("\n - ");
        sb.append(categorie);
        sb.append(" de ").append(marque);
        sb.append(" avec un score : ").append(scoreNutritionnel);
        sb.append(", valeurs nutritionnelles : ").append(valeursNutritionnelles);
        sb.append("\n\t Ingrédients : ").append(ingredients);
        sb.append("\n\t Additifs : ").append(additifs);
        sb.append("\n\t Allergènes : ").append(allergenes);
        return sb.toString();
    }
}
