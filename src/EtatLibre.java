public class EtatLibre extends EtatRue {

    public EtatLibre(Rue rue) {
        super(rue);
    }

    @Override
    public void joueurArrive(Personnage joueur) {
        System.out.println(joueur.getNom() + " est sur une rue : " + rue.getNom());
        rue.afficherDetails();
        if (joueur.soldeSuffisant(rue.getPrix())) {
            joueur.afficherSolde();
            if (joueur.proposerAchat(rue)) {
                System.out.println(joueur.getNom() + " a acheté " + rue.getNom());
                joueur.payer(rue.getPrix());
                joueur.nouvellePropriete(rue);
                this.devientAcheter();
            }
        } else {
            System.out.println("Solde insuffisant pour acheter la propriété");
        }
    }

    public void devientAcheter() {
        rue.setEtat(new EtatAcheter(rue));
        notifier();
        System.out.println(rue.getNom() + " est maintenant achetée.");
    }

    @Override
    public double calculLoyer() {
        return 0; // Pas de loyer pour une rue non achetée
    }
}
