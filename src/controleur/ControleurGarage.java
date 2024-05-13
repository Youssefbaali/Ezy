package controleur;

import modele.Garage;
import modele.Vehicule;

public class ControleurGarage {
    private Garage garage;

    public ControleurGarage(Garage garage) {
        this.garage = garage;
    }

    public Vehicule rechercherVehicule(String type, String code) {
        for (Vehicule vehicule : garage.getVehicules()) {
            if (vehicule.getCode().equals(code) && vehicule.getClass().getSimpleName().equalsIgnoreCase(type)) {
                return vehicule;
            }
        }
        return null;
    }
}
