package fr.diginamic.foodFacts;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FichierUtil {
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


}
