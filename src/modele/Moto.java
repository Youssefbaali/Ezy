package modele;



public class Moto extends Vehicule {
    private int cylindree;

    public Moto(String marque, String modele, int anneeFabrication, String code, int cylindree) {
        super(marque, modele, anneeFabrication, code);
        this.cylindree = cylindree;
    }

    public int getCylindree() {
        return cylindree;
    }
}
