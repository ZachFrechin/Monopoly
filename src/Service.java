public class Service extends Propriete {

    private int prix;
    private String nom;

    public Service(String nom, int prix) {
        this.nom = nom;
        this.prix = prix;
    }

    @Override
    public void joueurArrive(Personnage joueur) {
        System.out.println(joueur.getNom() + " est sur un service : " + this.nom);

        if (proprietaire == null) { // Pas de propriétaire
            if (joueur.proposerAchat(this)) {
                joueur.payer(prix);
                setProprietaire(joueur);
                joueur.nouvellePropriete(this);
                System.out.println(joueur.getNom() + " a acheté le service " + this.nom);
                notifier(); // Notifie le quartier de l'achat
            }
        } else if (!estProprietaire(joueur)) { // Le service a un propriétaire différent
            double loyer = calculLoyer();
            joueur.payer(loyer);
            proprietaire.crediter(loyer); // Le propriétaire reçoit la taxe
            System.out.println(joueur.getNom() + " a payé une taxe de " + loyer + " à " + proprietaire.getNom());
        } else {
            System.out.println(joueur.getNom() + " est le propriétaire de ce service.");
        }
    }

    @Override
    public double calculLoyer() {
        Observer quartier = getObserveur();
        if (quartier instanceof Quartier) {
            int nbServices = ((Quartier) quartier).getNbProprietesDetenues(this);
            return 100 * nbServices; // Exemple : taxe basée sur le nombre de services détenus
        }
        return 0;
    }

    @Override
    public int getPrix() {
        return prix;
    }
}
