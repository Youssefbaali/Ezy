package vue;

import controleur.ControleurGarage;
import modele.Garage;
import modele.Vehicule;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfaceGraphique {
    private JFrame frame;
    private JComboBox<String> comboBoxTypeVehicule;
    private JTextField textFieldCodeVehicule;
    private JTextField textFieldCode;
    private JTextArea textAreaDetails;
    private JButton buttonRechercher;

    private Garage garage;
    private ControleurGarage controleur;

    public InterfaceGraphique(Garage garage) {
        this.garage = garage;
        this.controleur = new ControleurGarage(garage);
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Application Garage");
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        // Ajout d'une étiquette pour le choix du type de véhicule
        JLabel labelTypeVehicule = new JLabel("Type de véhicule :");
        labelTypeVehicule.setBounds(20, 0, 120, 20);
        frame.getContentPane().add(labelTypeVehicule);

        comboBoxTypeVehicule = new JComboBox<>(new String[]{"Voiture", "Moto"});
        comboBoxTypeVehicule.setBounds(20, 20, 100, 25);
        frame.getContentPane().add(comboBoxTypeVehicule);

        // Ajout d'une étiquette pour le code du véhicule
        JLabel labelCodeVehicule = new JLabel("Code du véhicule :");
        labelCodeVehicule.setBounds(140, 0, 120, 20);
        frame.getContentPane().add(labelCodeVehicule);

        textFieldCodeVehicule = new JTextField();
        textFieldCodeVehicule.setBounds(140, 20, 100, 25);
        frame.getContentPane().add(textFieldCodeVehicule);

        textFieldCode = new JTextField();
        textFieldCode.setBounds(260, 20, 100, 25);
        frame.getContentPane().add(textFieldCode);

        buttonRechercher = new JButton("Rechercher");
        buttonRechercher.setBounds(140, 60, 100, 25);
        frame.getContentPane().add(buttonRechercher);

        textAreaDetails = new JTextArea();
        textAreaDetails.setEditable(false);
        textAreaDetails.setBounds(20, 100, 400, 140);
        frame.getContentPane().add(textAreaDetails);

        buttonRechercher.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rechercherVehicule();
            }
        });
    }

    public void afficher() {
        frame.setVisible(true);
    }

    private void rechercherVehicule() {
        String typeVehicule = (String) comboBoxTypeVehicule.getSelectedItem();
        String codeVehicule = textFieldCodeVehicule.getText();

        // Utiliser le contrôleur pour rechercher le véhicule
        Vehicule vehicule = controleur.rechercherVehicule(typeVehicule, codeVehicule);

        // Affichage des détails du véhicule
        if (vehicule != null) {
            textAreaDetails.setText("Marque : " + vehicule.getMarque() +
                    "\nModèle : " + vehicule.getModele() +
                    "\nAnnée de fabrication : " + vehicule.getAnneeFabrication());
        } else {
            textAreaDetails.setText("Aucun véhicule correspondant trouvé.");
        }
    }
}


