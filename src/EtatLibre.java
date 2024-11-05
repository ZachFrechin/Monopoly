public class EtatLibre extends EtatRue {

    public EtatLibre(Rue rue) {
        super(rue);
    }

    @Override
    public void joueurArrive(Personnage joueur) {
        System.out.println("Cette rue est libre. Le joueur peut choisir de l'acheter.");
    }

    @Override
    public double calculLoyer() {
        return 0; // Pas de loyer pour une rue non achetée
    }
}
