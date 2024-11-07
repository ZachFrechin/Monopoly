public class Rue extends Propriete {

    private String nom;
    private int loyer;
    private int prixMaison;
    private int loyerMaison;
    private int loyerHotel;
    private EtatRue etatRue;


    public String getNom() {
        return nom;
    }
    public int getLoyerMaison() {
        return loyerMaison;
    }

    public int getLoyerHotel() {
        return loyerHotel;
    }

    public EtatRue getEtatRue() {
        return this.etatRue;
    }

    public Rue(String nom, int loyer, int prixMaison, int loyerMaison, int loyerHotel) {
        this.nom = nom;
        this.loyer = loyer;
        this.prixMaison = prixMaison;
        this.loyerMaison = loyerMaison;
        this.loyerHotel = loyerHotel;
        this.etatRue = new EtatLibre(this); // État initial
    }

    @Override
    public void notifier() {
        // Logique de notification vers l’observateur
        if (getObserveur() != null) {
            getObserveur().update();
        }
    }

    @Override
    public void joueurArrive(Personnage joueur) {
        etatRue.joueurArrive(joueur);
    }

    public void setEtat(EtatRue etat) {
        this.etatRue = etat;
        notifier();
    }

    @Override
    public double calculLoyer() {
        return etatRue.calculLoyer();
    }

    public int getPrix() {
        return loyer;
    }
}
