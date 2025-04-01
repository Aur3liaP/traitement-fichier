package fr.diginamic.foodFacts;

import java.util.Comparator;

class ComparateurScoreNutritionnel implements Comparator<Produit> {

    @Override
    public int compare(Produit p1, Produit p2) {
        return Character.compare(p1.getScoreNutritionnel(), p2.getScoreNutritionnel());
    }
}
