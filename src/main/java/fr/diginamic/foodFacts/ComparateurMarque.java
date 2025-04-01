package fr.diginamic.foodFacts;

import java.util.Comparator;

class ComparateurMarque implements Comparator<Produit> {

    @Override
    public int compare(Produit p1, Produit p2) {
        return p1.getMarque().getNom().compareTo(p2.getMarque().getNom());
    }
}
