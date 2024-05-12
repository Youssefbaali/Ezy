import controleur.ControleurGarage;
import modele.Garage;
import vue.InterfaceGraphique;

public class Main {
    public static void main(String[] args) {
        // Initialiser le garage
        Garage garage = new Garage();

        // Initialiser la vue
        InterfaceGraphique interfaceGraphique = new InterfaceGraphique(garage);

        // Initialiser le contrôleur et le connecter au modèle et à la vue
        ControleurGarage controleurGarage = new ControleurGarage(garage, interfaceGraphique);

        // Afficher l'interface graphique
        interfaceGraphique.afficher();
    }
}
