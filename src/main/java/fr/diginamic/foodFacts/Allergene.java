package fr.diginamic.foodFacts;

import java.util.Objects;

public class Allergene {

    private final String libelle;

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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Allergene allergene = (Allergene) o;
        return Objects.equals(libelle, allergene.libelle);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(libelle);
    }
}
