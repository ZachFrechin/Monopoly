import java.util.ArrayList;
import java.util.List;

public class Personnage {

    private String nom;
    private double argent = 1500; // Montant de départ
    private Case position;
    private List<Propriete> mesProprietes = new ArrayList<>();

    public Personnage(String nom) {
        this.nom = nom;
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
        position = position.avancer(deplacement);
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
    }

    public void nouvellePropriete(Propriete propriete) {
        mesProprietes.add(propriete);
    }

    public void crediter(double montant) {
        argent += montant;
    }

    public void debiter(double montant) {
        argent -= montant;
    }
}
