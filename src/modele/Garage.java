package modele;

import java.util.ArrayList;
import java.util.List;

public class Garage {
    private List<Vehicule> vehicules;

    public Garage() {
        vehicules = new ArrayList<>();
        initialiserDonnees();
    }

    private void initialiserDonnees() {
        // Ajouter des véhicules de test dans le garage
        vehicules.add(new Voiture("Audi", "A4", 2015, "A123", 4));
        vehicules.add(new Moto("Honda", "CBR1000RR", 2018, "B456", 1000));
        vehicules.add(new Voiture("Renault", "Clio", 2010, "C789", 5));
        vehicules.add(new Moto("Yamaha", "YZF-R6", 2020, "D012", 600));
        vehicules.add(new Voiture("Toyota", "Corolla", 2019, "E234", 4));
        vehicules.add(new Moto("Ducati", "Panigale V4", 2020, "F345", 1100));
        vehicules.add(new Voiture("Mercedes", "C-Class", 2018, "G456", 4));
        vehicules.add(new Moto("KTM", "Duke 390", 2021, "H567", 390));
    }

    public void ajouterVehicule(Vehicule vehicule) {
        vehicules.add(vehicule);
    }

    public List<Vehicule> getVehicules() {
        return vehicules;
    }
}
