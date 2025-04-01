package fr.diginamic.foodFacts;

import java.util.Objects;

public class Additif {
    private final String libelle;

    public Additif(String libelle) {
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
        Additif additif = (Additif) o;
        return Objects.equals(libelle, additif.libelle);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(libelle);
    }
}
