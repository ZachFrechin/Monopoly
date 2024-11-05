public class Rue extends Propriete {

    private int loyer;
    private int prixMaison;
    private int loyerMaison;
    private int loyerHotel;
    private EtatRue etatRue;

    public int getLoyerMaison() {
        return loyerMaison;
    }

    public int getLoyerHotel() {
        return loyerHotel;
    }
    
    @Override
    public void attache(Quartier quartier) {
        // TODO Auto-generated method stub
    }

    public Rue(int loyer, int prixMaison, int loyerMaison, int loyerHotel) {
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
        if (!etatRue.estProprietaire(joueur)) { // Rue non achetée par ce joueur
            if (joueur.proposerAchat(this)) {
                joueur.payer(getPrix());
                joueur.nouvellePropriete(this);
                System.out.println(joueur.getNom() + " a acheté " + this);
                notifier(); // Notifie que la propriété a été achetée
            }
        } else { // Rue déjà achetée par un autre joueur
            double loyer = etatRue.calculLoyer();
            joueur.payer(loyer);
            System.out.println(joueur.getNom() + " a payé un loyer de " + loyer);
        }
    }

    public void setEtat(EtatRue etat) {
        this.etatRue = etat;
        notifier(); // Notifie le changement d'état
    }

    @Override
    public double calculLoyer() {
        return etatRue.calculLoyer();
    }

    public int getPrix() {
        return loyer;
    }
}
