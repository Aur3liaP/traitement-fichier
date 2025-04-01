package fr.diginamic.foodFacts;

public class Ingredient {
    private String libelle;

    public Ingredient(String libelle) {
        this.libelle = libelle;
    }

    public String getLibelle() {
        return libelle;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ingredient{");
        sb.append(libelle).append(' ');
        sb.append('}');
        return sb.toString();
    }
}
