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

    public String getNom() {
        return nom;
    }

    public boolean peutJouer() {
        return argent > 0;
    }

    public List<Propriete> getMesProprietes() {
        return mesProprietes;
    }

    public void setPosition(Case caseNouvelle) {
        this.position = caseNouvelle;
    }

    public void jouerTour(Des des) {
        des.lancerDes();
        int deplacement = des.getTotalDes();
        System.out.println(nom + " se déplace de " + deplacement + " cases");
        position = position.avancer(deplacement, this);
        position.joueurArrive(this);
    }

    public boolean proposerAchat(Propriete propriete) {
        return argent >= propriete.getPrix();
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
