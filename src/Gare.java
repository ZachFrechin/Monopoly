public class Gare extends Propriete {

    private int prix;
    private String nom;

    public Gare(String nom, int loyer) {
        this.nom = nom;
        this.prix = loyer;
    }

    @Override
    public String getNom() {
        return this.nom;
    }

    @Override
    public void joueurArrive(Personnage joueur) {
        System.out.println(joueur.getNom() + " est sur une gare : " + this.nom);

        if (proprietaire == null) { // Pas de propriétaire
            if (joueur.soldeSuffisant(this.getPrix())) {
                if (joueur.proposerAchat(this)) {
                    joueur.payer(prix);
                    setProprietaire(joueur);
                    joueur.nouvellePropriete(this);
                    System.out.println(joueur.getNom() + " a acheté la gare " + this.nom);
                    notifier(); // Notifie le quartier de l'achat
                }
            } else {
                System.out.println("Solde insuffisant pour acheter la propriété");
            }
        } else if (!estProprietaire(joueur)) { // La gare a un propriétaire différent
            int loyer = calculLoyer();
            joueur.payer(loyer);
            proprietaire.crediter(loyer); // Le propriétaire reçoit le loyer
            System.out.println(joueur.getNom() + " a payé un loyer de " + loyer + " à " + proprietaire.getNom());
        } else {
            System.out.println(joueur.getNom() + " est le propriétaire de cette gare.");
        }
    }

    @Override
    public int calculLoyer(Des des) {
        return 0;
    }

    @Override
    public int calculLoyer() {
        Observer quartier = getObserveur();
        if (quartier instanceof Quartier) {
            int nbGares = ((Quartier) quartier).getNbProprietesDetenues(this);
            double result = 50 * Math.pow(2, nbGares - 1);
            int resultInt = (int) result;
            return resultInt; // Loyer int en fonction des gares détenues
        }
        return 0;
    }

    @Override
    public int getPrix() {
        return prix;
    }
}
