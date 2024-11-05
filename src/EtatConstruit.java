public class EtatConstruit extends EtatRue {

    private int nbMaison;
    private int nbHotel;

    public EtatConstruit(Rue rue, int nbMaison, int nbHotel) {
        super(rue);
        this.nbMaison = nbMaison;
        this.nbHotel = nbHotel;
    }

    public void setNbMaison(int nbMaison) {
        this.nbMaison = nbMaison;
        notifier();
    }

    public void setNbHotel(int nbHotel) {
        this.nbHotel = nbHotel;
        notifier();
    }

    @Override
    public void joueurArrive(Personnage joueur) {
        if (!rue.estProprietaire(joueur)) {
            double loyer = calculLoyer();
            joueur.payer(loyer);
            rue.getProprietaire().crediter(loyer);
            System.out.println(joueur.getNom() + " a payé un loyer de " + loyer + " à " + rue.getProprietaire().getNom());
        } else {
            System.out.println(joueur.getNom() + " est le propriétaire de cette rue.");
        }
    }

    @Override
    public double calculLoyer() {
        double baseLoyer = rue.getPrix();
        return baseLoyer + (nbMaison * rue.getLoyerMaison()) + (nbHotel * rue.getLoyerHotel());
    }
}
