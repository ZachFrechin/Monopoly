public class EtatConstructible extends EtatRue {

    public EtatConstructible(Rue rue) {
        super(rue);
    }

    @Override
    public void joueurArrive(Personnage joueur) {
        if (!rue.estProprietaire(joueur)) {
            double loyer = calculLoyer();
            joueur.payer(loyer);
            rue.getProprietaire().crediter(loyer);
            System.out.println(joueur.getNom() + " a payé un loyer de " + loyer + " à " + rue.getProprietaire().getNom());
        } else {
            System.out.println(joueur.getNom() + " est le propriétaire de cette rue et peut y construire.");
        }
    }

    @Override
    public double calculLoyer() {
        return rue.getPrix() * 1.5; // Exemple d’un loyer majoré sans constructions
    }

    public void construire(int nbMaison, int nbHotel) {
        if (nbMaison > 0 || nbHotel > 0) {
            rue.setEtat(new EtatConstruit(rue, nbMaison, nbHotel));
            notifier();
            System.out.println("Construction terminée : " + nbMaison + " maisons, " + nbHotel + " hôtel(s).");
        }
    }
}
