package fr.diginamic.foodFacts;

import java.util.ArrayList;

public class Stock {
    private final ArrayList<Produit> produits;

    public Stock() {
        this.produits = new ArrayList<>();
    }

    public void ajouterProduit(Produit produit) {
        produits.add(produit);
    }

    public ArrayList<Produit> getProduits() {
        return produits;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Stock{");
        sb.append(produits);
        sb.append('}');
        return sb.toString();
    }
}
