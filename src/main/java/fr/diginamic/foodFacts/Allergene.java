package fr.diginamic.foodFacts;

public class Allergene {

    private String libelle;

    public Allergene(String libelle) {
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
