public class EtatAcheter extends EtatRue {

    public EtatAcheter(Rue rue) {
        super(rue);
    }

    @Override
    public void joueurArrive(Personnage joueur) {
        rue.afficherDetails();
        System.out.println(joueur.getNom() + " est sur une rue : " + rue.getNom());
        if (!rue.estProprietaire(joueur)) {
            int loyer = calculLoyer();
            System.out.println(joueur.getNom() + " a payé un loyer de " + loyer + " à " + rue.getProprietaire().getNom());
            joueur.payer(loyer);
            rue.getProprietaire().crediter(loyer);
        } else {
            System.out.println(joueur.getNom() + " est le propriétaire de cette rue.");
        }
    }

    @Override
    public int calculLoyer() {
        return rue.getPrix(); // Loyer de base pour une rue achetée sans constructions
    }

    @Override
    public void devientConstructible() {
        rue.setEtat(new EtatConstructible(rue));
        notifier();
        System.out.println(rue.getNom() + " est maintenant constructible.");
    }
}
