package modele;

public abstract class Vehicule {
    private String marque;
    private String modele;
    private int anneeFabrication;
    private String code;

    public Vehicule(String marque, String modele, int anneeFabrication, String code) {
        this.marque = marque;
        this.modele = modele;
        this.anneeFabrication = anneeFabrication;
        this.code = code;
    }

    public String getMarque() {
        return marque;
    }

    public String getModele() {
        return modele;
    }

    public int getAnneeFabrication() {
        return anneeFabrication;
    }

    public String getCode() {
        return code;
    }
}
