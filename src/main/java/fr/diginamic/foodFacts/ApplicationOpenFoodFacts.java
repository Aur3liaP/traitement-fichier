package fr.diginamic.foodFacts;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ApplicationOpenFoodFacts {
    private final Stock stock;

    public ApplicationOpenFoodFacts(Stock stock) {
        this.stock = stock;
    }


    public static void main(String[] args) throws IOException {
        Stock stock = new Stock();
        ApplicationOpenFoodFacts app = new ApplicationOpenFoodFacts(stock);

        lireFichier("C:/Users/picau/Downloads/OneDrive_2025-03-27/11. Java approche objet/TP autonomie J6/open-food-facts.csv", stock);

        app.afficherMenu();

    }

    public static void lireFichier(String fichier, Stock stock) throws IOException {
        Path path = Paths.get(fichier);

        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

        for(int i =1; i< lines.size(); i++) {
            String line = lines.get(i);
            String[] token = line.split("\\|", -1);

            Categorie categorie = new Categorie(token[0]);

            ArrayList<Marque> marques = new ArrayList<>();
            String[] marquesListe = token[1].split(",");
            for (String marqueName : marquesListe) {
                marques.add(new Marque(marqueName.trim()));
            }

            char scoreNutritionnel = token[3].charAt(0);

            ArrayList<Ingredient> ingredients = new ArrayList<>();
            if (!token[4].isEmpty()) {
                String[] ingredientListe = token[4].split(",");
                for (String ingredient : ingredientListe) {
                    ingredients.add(new Ingredient(ingredient.trim()));
                }
            }


            HashMap<String, Double> valeursNutritionnelles = new HashMap<>();
            valeursNutritionnelles.put("energie100g", parseDouble(token[5]));
            valeursNutritionnelles.put("graisse100g", parseDouble(token[6]));
            valeursNutritionnelles.put("sucres100g", parseDouble(token[7]));
            valeursNutritionnelles.put("fibres100g", parseDouble(token[8]));
            valeursNutritionnelles.put("proteines100g", parseDouble(token[9]));
            valeursNutritionnelles.put("sel100g", parseDouble(token[10]));
            valeursNutritionnelles.put("vitA100g", parseDouble(token[11]));
            valeursNutritionnelles.put("vitD100g", parseDouble(token[12]));
            valeursNutritionnelles.put("vitE100g", parseDouble(token[13]));
            valeursNutritionnelles.put("vitK100g", parseDouble(token[14]));
            valeursNutritionnelles.put("vitC100g", parseDouble(token[15]));
            valeursNutritionnelles.put("vitB1100g", parseDouble(token[16]));
            valeursNutritionnelles.put("vitB2100g", parseDouble(token[17]));
            valeursNutritionnelles.put("vitPP100g", parseDouble(token[18]));
            valeursNutritionnelles.put("vitB6100g", parseDouble(token[19]));
            valeursNutritionnelles.put("vitB9100g", parseDouble(token[20]));
            valeursNutritionnelles.put("vitB12100g", parseDouble(token[21]));
            valeursNutritionnelles.put("calcium100g", parseDouble(token[22]));
            valeursNutritionnelles.put("magnesium100g", parseDouble(token[23]));
            valeursNutritionnelles.put("iron100g", parseDouble(token[24]));
            valeursNutritionnelles.put("fer100g", parseDouble(token[25]));
            valeursNutritionnelles.put("betaCarotene100g", parseDouble(token[26]));

            List<Allergene> allergenes = new ArrayList<>();
            if (!token[28].isEmpty()) {
                String[] allergeneListe = token[28].split(",");
                for (String allergene : allergeneListe) {
                    allergenes.add(new Allergene(allergene.trim()));
                }
            }


            List<Additif> additifs = new ArrayList<>();
            if (!token[29].isEmpty()) {
                String[] additifListe = token[29].split(",");
                for (String additif : additifListe) {
                    additifs.add(new Additif(additif.trim()));
                }
            }

            for (Marque marque : marques) {
                Produit produit = new Produit(categorie, marque, scoreNutritionnel, valeursNutritionnelles, ingredients, additifs, allergenes);
                stock.ajouterProduit(produit);
            }


        }

    }
    private static double parseDouble(String value) {
        if (value == null || value.isEmpty()) {
            return 0.0;
        }

        if (value.matches("-?\\d+(\\.\\d+)?")) {
            try {
                return Double.parseDouble(value);
            } catch (NumberFormatException e) {
                System.err.println("Impossible de convertir en nombre: " + value);
                return 0.0;
            }
        } else {
            return 0.0;
        }
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
