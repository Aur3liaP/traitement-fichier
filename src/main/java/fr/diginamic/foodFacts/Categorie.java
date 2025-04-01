package fr.diginamic.foodFacts;

public class Categorie {
    private final String libelle;

    public Categorie(String libelle) {
        this.libelle = libelle;
    }

    public String getLibelle() {
        return libelle;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(libelle);
        return sb.toString();
    }
}
