package fr.diginamic.foodFacts;

import java.util.Map;
import java.util.Set;

public class Produit {
    private final Categorie categorie;
    private final Marque marque;
    private final char scoreNutritionnel;
    private final Map<String, Double> valeursNutritionnelles;
    private final Set<Ingredient> ingredients;
    private final Set<Additif> additifs;
    private final Set<Allergene> allergenes;

    public Produit(Categorie categorie, Marque marque, char scoreNutritionnel, Map<String, Double> valeursNutritionnelles, Set<Ingredient> ingredients, Set<Additif> additifs, Set<Allergene> allergenes) {
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

    public Set<Additif> getAdditifs() {
        return additifs;
    }

    public Set<Allergene> getAllergenes() {
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
