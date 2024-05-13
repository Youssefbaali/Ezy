package main;

import controleur.ControleurGarage;
import modele.Garage;
import vue.InterfaceGraphique;

import org.json.simple.parser.ParseException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Garage garage = new Garage();

        // Charger les données depuis un fichier JSON
        try {
            garage.chargerDepuisJSON("garage_data.json");
        } catch (IOException | ParseException e) {
            System.out.println("Aucun fichier JSON trouvé ou erreur de lecture. Initialisation avec des données par défaut.");
        }

        // Créer le contrôleur
        ControleurGarage controleur = new ControleurGarage(garage);

        // Afficher l'interface graphique
        InterfaceGraphique interfaceGraphique = new InterfaceGraphique(garage);
        interfaceGraphique.afficher();

        // Ajouter un hook pour sauvegarder les données en JSON lors de la fermeture de l'application
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            garage.sauvegarderEnJSON("garage_data.json");
        }));
    }
}
