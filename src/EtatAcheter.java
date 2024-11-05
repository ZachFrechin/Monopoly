public class EtatAcheter extends EtatRue {

    public EtatAcheter(Rue rue) {
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
            System.out.println(joueur.getNom() + " est le propriétaire de cette rue.");
        }
    }

    @Override
    public double calculLoyer() {
        return rue.getPrix(); // Loyer de base pour une rue achetée sans constructions
    }

    @Override
    public void devientConstructible() {
        rue.setEtat(new EtatConstructible(rue));
        notifier();
        System.out.println("La rue est maintenant constructible.");
    }
}
