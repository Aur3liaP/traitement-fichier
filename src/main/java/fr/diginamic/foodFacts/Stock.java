package fr.diginamic.foodFacts;

import java.util.ArrayList;

public class Stock {
    private ArrayList<Produit> produits;

    public Stock() {
        this.produits = new ArrayList<>();
    }

    public void ajouterProduit(Produit produit) {
        produits.add(produit);
    }

    public ArrayList<Produit> getProduits() {
        return produits;
    }

}
