package fr.diginamic.foodFacts;

public class Marque {
    private String nom;

    public Marque(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(nom);
        return sb.toString();
    }
}
