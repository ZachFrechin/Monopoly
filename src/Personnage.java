import java.util.ArrayList;
import java.util.List;


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

    public Case getPosition() {
        return this.position;
    }

    public double getSolde() {
        return this.argent;
    }

    public List<Propriete> getMesProprietes() {
        return this.mesProprietes;
    }

    // Setters
    public void setPosition(Case caseNouvelle) {
        this.position = caseNouvelle;
    }

    public void setArgent(double montant) {
        this.argent = montant;
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
        if (des.getLancables()) {
            des.lancerDes();
            des.setLancables(false);
            if (des.estDouble()) {
                des.setLancables(true);
                System.out.println("Doubles !");
            }
            int deplacement = des.getTotalDes();
            System.out.println(nom + " se déplace de " + deplacement + " cases");
            position = position.avancer(deplacement, this);
            if (position instanceof Service) {
                position.joueurArrive(this, des);
            } else {
                position.joueurArrive(this);
            }
        } else {
            System.out.println("Impossible de relancer les dés pendant ce tour");
        }
    }

    public void jouerTour(Des des, Integer score) {
        des.lancerDes(score);
        int deplacement = des.getTotalDes();
        System.out.println(nom + " se déplace de " + deplacement + " cases");
        position = position.avancer(deplacement, this);
        if (position instanceof Service) {
            position.joueurArrive(this, des);
        } else {
            position.joueurArrive(this);
        }
    }

    public boolean proposerAchat(Propriete propriete) {
        MenuAchat ma = new MenuAchat(propriete.getNom(), propriete.getPrix());
        return (ma.getChoix() == 1);
    }

    public void afficherSolde() {
        System.out.println("Solde de " + nom + " : " + argent);
    }

    public void payer(double somme) {
        argent -= somme;
        if (argent < 0) {
            System.out.println(nom + " est en faillite !");
        }     
        afficherSolde();   
    }

    public void nouvellePropriete(Propriete propriete) {
        mesProprietes.add(propriete);
        propriete.setProprietaire(this);
    }

    public void crediter(double montant) {
        argent += montant;
        afficherSolde();
    }


}
