public abstract class EtatRue {

    protected Rue rue;

    public EtatRue(Rue rue) {
        this.rue = rue;
    }

    public void joueurArrive(Personnage joueur) {
        // Actions à définir dans les sous-classes en fonction de l’état
    }

    public void notifier() {
        rue.notifier(); // Notifie l'observateur via la rue
    }

    public void devientConstructible() {
        // Par défaut, ne fait rien ; chaque état spécifique gère sa constructibilité
    }

    public boolean estProprietaire(Personnage joueur) {
        return rue.estProprietaire(joueur);
    }

    public void construire_maison() {
        System.out.println("Construction impossible");
    }

    public int prix_maison() {
        return this.rue.getPrix() * 5;
    }

    public void construire_hotel() {
        System.out.println("Construction impossible");
    }

    public int prix_hotel() {
        return this.rue.getPrix() * 5;
    }






    public abstract int calculLoyer();
}
