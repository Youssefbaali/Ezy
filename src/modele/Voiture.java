package modele;

public class Voiture extends Vehicule {
    private int nombrePortes;

    public Voiture(String marque, String modele, int anneeFabrication, String code, int nombrePortes) {
        super(marque, modele, anneeFabrication, code);
        this.nombrePortes = nombrePortes;
    }

    public int getNombrePortes() {
        return nombrePortes;
    }
}
