package fr.diginamic.foodFacts;

import java.util.*;

public class ApplicationOpenFoodFacts {
    private Stock stock;

    public ApplicationOpenFoodFacts(Stock stock) {
        this.stock = stock;
    }


    public static void main(String[] args) {
        Stock stock = new Stock();
        ApplicationOpenFoodFacts app = new ApplicationOpenFoodFacts(stock);

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
            System.out.println("4. Afficher les allergènes les plus courants");
            System.out.println("5. Afficher les additifs les plus courants");
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
                    System.out.println("À plus !");
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

        Collections.sort(meilleursProduits, new ComparateurMarque());
        System.out.println(meilleursProduits);
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

        Collections.sort(meilleursProduits, new ComparateurMarque());
        System.out.println(meilleursProduits);

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

        Collections.sort(meilleursProduits, new ComparateurMarque());
        System.out.println(meilleursProduits);

    }

    private void afficherAllergenesCourants() {
        HashMap<String, Integer> allergenesCourants = new HashMap<>();

        for (Produit produit : stock.getProduits()) {
            for (Allergene allergene : produit.getAllergenes()) {
                allergenesCourants.put(allergene.getLibelle(), allergenesCourants.getOrDefault(allergene.getLibelle(), 0) + 1);
            }
        }
        for (Map.Entry<String, Integer> data : allergenesCourants.entrySet() ) {
            System.out.println("Allergène: "+ data.getKey() + ", Nombre de produits: " + data.getValue());
        }

    }

    private void afficherAdditifsCourants() {
        HashMap<String, Integer> additifsCourants = new HashMap<>();

        for (Produit produit : stock.getProduits()) {
            for (Additif additif : produit.getAdditifs()) {
                additifsCourants.put(additif.getLibelle(), additifsCourants.getOrDefault(additif.getLibelle(), 0) + 1);
            }
        }
        for (Map.Entry<String, Integer> data : additifsCourants.entrySet() ) {
            System.out.println("Additif: "+ data.getKey() + ", Nombre de produits: " + data.getValue());
        }

    }
}
