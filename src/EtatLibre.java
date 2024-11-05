public class EtatLibre extends EtatRue {

    public EtatLibre(Rue rue) {
        super(rue);
    }

    @Override
    public void joueurArrive(Personnage joueur) {
        System.out.println(joueur.getNom() + " est sur une rue : " + rue.getNom());
        if (joueur.proposerAchat(rue)) {
            joueur.payer(rue.getPrix());
            joueur.nouvellePropriete(rue);
            
            System.out.println(joueur.getNom() + " a acheté " + rue.getNom());
            rue.setEtat(new EtatAcheter(rue));
            notifier(); // Notifie que la propriété a été achetée
        }
    }

    @Override
    public double calculLoyer() {
        return 0; // Pas de loyer pour une rue non achetée
    }
}
