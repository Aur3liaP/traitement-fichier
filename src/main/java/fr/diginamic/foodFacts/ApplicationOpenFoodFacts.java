package fr.diginamic.foodFacts;

import java.io.IOException;
import java.util.*;

public class ApplicationOpenFoodFacts {
    private final Stock stock;

    public ApplicationOpenFoodFacts(Stock stock) {
        this.stock = stock;
    }


    public static void main(String[] args) throws IOException {
        Stock stock = new Stock();
        ApplicationOpenFoodFacts app = new ApplicationOpenFoodFacts(stock);

        FichierUtil.lireFichier("C:/Users/picau/Downloads/OneDrive_2025-03-27/11. Java approche objet/TP autonomie J6/open-food-facts.csv", stock);

        app.afficherMenu();

    }

    public void afficherMenu() {
        Scanner scanner = new Scanner(System.in);
        int choix;

        do{
            System.out.println("Menu:");
            System.out.println("1. Rechercher les meilleurs produits pour une marque donnée");
            System.out.println("2. Rechercher les meilleurs produits pour une catégorie donnée");
            System.out.println("3. Rechercher les meilleurs produits par marque et par catégorie");
            System.out.println("4. Afficher le top des allergènes les plus courants");
            System.out.println("5. Afficher le top des additifs les plus courants");
            System.out.println("0. Quitter");
            System.out.print("Choisissez une option: ");
            choix = scanner.nextInt();
            scanner.nextLine();
            switch (choix) {
                case 1:
                    meilleursProduitsParMarque(scanner);
                    break;
                case 2:
                    meilleursProduitsParCategorie(scanner);
                    break;
                case 3:
                   meilleursProduitsParMarqueEtCategorie(scanner);
                    break;
                case 4:
                    afficherAllergenesCourants();
                    break;
                case 5:
                    afficherAdditifsCourants();
                    break;
                case 0:
                    System.out.println("OK Thank you bye ~");
                    break;
                default:
                    System.out.println("Option invalide :'(  Choisissez entre 0 et 5.");
            }
        } while (choix != 0);

    }

    private void meilleursProduitsParMarque(Scanner scanner){
        System.out.print("Entrez la marque: ");
        String marque = scanner.nextLine();

        ArrayList<Produit> meilleursProduits = new ArrayList<>();
        for(Produit produit : stock.getProduits()) {
            if (produit.getMarque().getNom().equals(marque)){
                meilleursProduits.add(produit);
            }
        }

        Collections.sort(meilleursProduits, new ComparateurScoreNutritionnel());
        int limit = Math.min(15, meilleursProduits.size());

        System.out.println("Les 15 des meilleurs produits de " + marque + ":");
        for (int i = 0; i < limit; i++) {
            Produit produit = meilleursProduits.get(i);
            System.out.println(produit);
        }
    }

    private void meilleursProduitsParCategorie(Scanner scanner){
        System.out.print("Entrez la catégorie: ");
        String categorie = scanner.nextLine();

        ArrayList<Produit> meilleursProduits = new ArrayList<>();

        for(Produit produit : stock.getProduits()) {
            if (produit.getCategorie().getLibelle().equals(categorie)){
                meilleursProduits.add(produit);
            }
        }

        Collections.sort(meilleursProduits, new ComparateurScoreNutritionnel());
        int limit = Math.min(15, meilleursProduits.size());

        System.out.println("Les 15 des meilleurs produits dans la catégorie " + categorie + ":");
        for (int i = 0; i < limit; i++) {
            Produit produit = meilleursProduits.get(i);
            System.out.println(produit);
        }

    }

    private void meilleursProduitsParMarqueEtCategorie(Scanner scanner){
        System.out.print("Entrez la marque: ");
        String marque = scanner.nextLine();
        System.out.print("Entrez la catégorie: ");
        String categorie = scanner.nextLine();

        ArrayList<Produit> meilleursProduits = new ArrayList<>();


        for(Produit produit : stock.getProduits()) {
            if (produit.getMarque().getNom().equals(marque) && produit.getCategorie().getLibelle().equals(categorie)){
                meilleursProduits.add(produit);
            }
        }

        Collections.sort(meilleursProduits, new ComparateurScoreNutritionnel());
        int limit = Math.min(15, meilleursProduits.size());

        System.out.println("Les 15 des meilleurs produits de " + marque + " dans la catégorie " + categorie + ":");
        for (int i = 0; i < limit; i++) {
            Produit produit = meilleursProduits.get(i);
            System.out.println(produit);
        }

    }

    private void afficherAllergenesCourants() {
        HashMap<String, Integer> allergenesCourants = new HashMap<>();

        for (Produit produit : stock.getProduits()) {
            for (Allergene allergene : produit.getAllergenes()) {
                allergenesCourants.put(allergene.getLibelle(), allergenesCourants.getOrDefault(allergene.getLibelle(), 0) + 1);
            }
        }
        List<Map.Entry<String, Integer>> allergenesTries = new ArrayList<>(allergenesCourants.entrySet());
        Collections.sort(allergenesTries, new ComparateurAllergenes());

        System.out.println("Top 10 des allergènes les plus courants :");
        int limit = Math.min(10, allergenesTries.size());
        for (int i = 0; i < limit; i++) {
            Map.Entry<String, Integer> entry = allergenesTries.get(i);
            System.out.println(entry.getKey() + " avec " + entry.getValue() + " produits");
        }

    }

    private void afficherAdditifsCourants() {
        HashMap<String, Integer> additifsCourants = new HashMap<>();

        for (Produit produit : stock.getProduits()) {
            for (Additif additif : produit.getAdditifs()) {
                additifsCourants.put(additif.getLibelle(), additifsCourants.getOrDefault(additif.getLibelle(), 0) + 1);
            }
        }
        List<Map.Entry<String, Integer>> additifsTries = new ArrayList<>(additifsCourants.entrySet());
        Collections.sort(additifsTries, new ComparateurAdditifs());

        System.out.println("Top 10 des additifs les plus courants :");
        int limit = Math.min(10, additifsTries.size());
        for (int i = 0; i < limit; i++) {
            Map.Entry<String, Integer> entry = additifsTries.get(i);
            System.out.println(entry.getKey() + ", Nombre de produits: " + entry.getValue());
        }

    }
}
