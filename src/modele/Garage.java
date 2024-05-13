package modele;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Garage {
    private List<Vehicule> vehicules;

    public Garage() {
        vehicules = new ArrayList<>();
    }

    public void ajouterVehicule(Vehicule vehicule) {
        vehicules.add(vehicule);
    }

    public void chargerDepuisJSON(String cheminFichier) throws IOException, ParseException {
        JSONParser parser = new JSONParser();

        // Lecture du fichier JSON
        Object obj = parser.parse(new FileReader(cheminFichier));
        JSONArray vehiculesJSON = (JSONArray) obj;

        // Parcours des objets JSON pour créer les véhicules
        for (Object o : vehiculesJSON) {
            JSONObject vehiculeJSON = (JSONObject) o;
            String type = (String) vehiculeJSON.get("type");
            String marque = (String) vehiculeJSON.get("marque");
            String modele = (String) vehiculeJSON.get("modele");
            int anneeFabrication = ((Long) vehiculeJSON.get("anneeFabrication")).intValue();
            String code = (String) vehiculeJSON.get("code");

            Vehicule vehicule = null;
            if ("Voiture".equals(type)) {
                vehicule = new Voiture(marque, modele, anneeFabrication, code, anneeFabrication);
            } else if ("Moto".equals(type)) {
                vehicule = new Moto(marque, modele, anneeFabrication, code, anneeFabrication);
            }

            if (vehicule != null) {
                ajouterVehicule(vehicule);
            }
        }

        System.out.println("Initialisation à partir du fichier JSON réussie.");
    }

    public void sauvegarderEnJSON(String cheminFichier) {
        JSONArray vehiculesJSON = new JSONArray();

        // Conversion des véhicules en objets JSON
        for (Vehicule vehicule : vehicules) {
            JSONObject vehiculeJSON = new JSONObject();
            vehiculeJSON.put("type", vehicule.getClass().getSimpleName());
            vehiculeJSON.put("marque", vehicule.getMarque());
            vehiculeJSON.put("modele", vehicule.getModele());
            vehiculeJSON.put("anneeFabrication", vehicule.getAnneeFabrication());
            vehiculeJSON.put("code", vehicule.getCode());

            vehiculesJSON.add(vehiculeJSON);
        }

        // Écriture des données JSON dans le fichier
        try (FileWriter file = new FileWriter(cheminFichier)) {
            file.write(vehiculesJSON.toJSONString());
            System.out.println("Données sauvegardées avec succès dans le fichier JSON.");
        } catch (IOException e) {
            System.out.println("Erreur lors de la sauvegarde des données dans le fichier JSON.");
        }
    }

    private void initialiserDonnees() {
        // Ajouter des véhicules de test dans le garage
        ajouterVehicule(new Voiture("Audi", "A4", 2015, "A123", 4));
        ajouterVehicule(new Moto("Honda", "CBR1000RR", 2018, "B456", 1000));
        ajouterVehicule(new Voiture("Renault", "Clio", 2010, "C789", 5));
        ajouterVehicule(new Moto("Yamaha", "YZF-R6", 2020, "D012", 600));
        ajouterVehicule(new Voiture("Toyota", "Corolla", 2019, "E234", 4));
        ajouterVehicule(new Moto("Ducati", "Panigale V4", 2020, "F345", 1100));
        ajouterVehicule(new Voiture("Mercedes", "C-Class", 2018, "G456", 4));
        ajouterVehicule(new Moto("KTM", "Duke 390", 2021, "H567", 390));
    }

    public List<Vehicule> getVehicules() {
        return vehicules;
    }
}

