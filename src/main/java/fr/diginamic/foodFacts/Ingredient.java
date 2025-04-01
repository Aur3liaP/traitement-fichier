package fr.diginamic.foodFacts;

public class Ingredient {
    private final String libelle;

    public Ingredient(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(libelle);
        return sb.toString();
    }
}
