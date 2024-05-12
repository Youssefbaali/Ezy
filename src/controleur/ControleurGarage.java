package controleur;



import vue.InterfaceGraphique;
import modele.Garage;

public class ControleurGarage {
    private Garage garage;
    private InterfaceGraphique interfaceGraphique;

    public ControleurGarage(Garage garage, InterfaceGraphique interfaceGraphique) {
        this.garage = garage;
        this.interfaceGraphique = interfaceGraphique;
    }
}
