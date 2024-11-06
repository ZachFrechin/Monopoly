import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Personnage {

    private String nom;
    private double argent = 1500; // Montant de départ
    private Case position;
    private List<Propriete> mesProprietes = new ArrayList<>();

    public Personnage(String nom, Case position) {
        this.nom = nom;
        this.position = position;
    }

    // Getters
    public String getNom() {
        return this.nom;
    }

    public List<Propriete> getMesProprietes() {
        return this.mesProprietes;
    }

    // Setters
    public void setPosition(Case caseNouvelle) {
        this.position = caseNouvelle;
    }

    public boolean peutJouer() {
        return argent > 0;
    }

    public boolean soldeSuffisant(int montant) {
        // Vérifie si le joueur possède au moins le montant donné
        return (this.argent >= montant);
    }

    public void construire(Monopoly jeu) {
        MenuConstruction mc = new MenuConstruction(this);
        mc.loop(jeu);
    }

    public void jouerTour(Des des) {
        des.lancerDes();
        int deplacement = des.getTotalDes();
        System.out.println(nom + " se déplace de " + deplacement + " cases");
        position = position.avancer(deplacement, this);
        position.joueurArrive(this);
    }

    public void jouerTour(Des des, Integer score) {
        des.lancerDes(score);
        int deplacement = des.getTotalDes();
        System.out.println(nom + " se déplace de " + deplacement + " cases");
        position = position.avancer(deplacement, this);
        position.joueurArrive(this);
    }

    public boolean proposerAchat(Propriete propriete) {
        MenuAchat ma = new MenuAchat(propriete.getNom());
        return (ma.getChoix() == 1);
    }

    public void payer(double somme) {
        argent -= somme;
        if (argent < 0) {
            System.out.println(nom + " est en faillite !");
        }

        System.out.println("Nouveau solde de " + nom + " : " + argent);
    }

    public void nouvellePropriete(Propriete propriete) {
        mesProprietes.add(propriete);
        propriete.setProprietaire(this);
    }

    public void crediter(double montant) {
        argent += montant;
        System.out.println("Nouveau solde de " + nom + " : " + argent);
    }


}
