public class Service extends Propriete {

    private int prix;
    private String nom;

    public Service(String nom, int prix) {
        this.nom = nom;
        this.prix = prix;
    }

    @Override
    public String getNom() {
        return this.nom;
    }

    @Override
    public void joueurArrive(Personnage joueur) {}

    @Override
    public void joueurArrive(Personnage joueur, Des des) {
        System.out.println(joueur.getNom() + " est sur un service : " + this.nom);

        if (proprietaire == null) { // Pas de propriétaire
            if (joueur.soldeSuffisant(this.getPrix())) {
                if (joueur.proposerAchat(this)) {
                    joueur.payer(prix);
                    setProprietaire(joueur);
                    joueur.nouvellePropriete(this);
                    System.out.println(joueur.getNom() + " a acheté le service " + this.nom);
                    notifier(); // Notifie le quartier de l'achat
                }
            } else {
                System.out.println("Solde insuffisant pour acheter la propriété");
            }
        } else if (!estProprietaire(joueur)) { // Le service a un propriétaire différent
            double loyer = calculLoyer(des);
            joueur.payer(loyer);
            proprietaire.crediter(loyer); // Le propriétaire reçoit la taxe
            System.out.println(joueur.getNom() + " a payé une taxe de " + loyer + " à " + proprietaire.getNom());
        } else {
            System.out.println(joueur.getNom() + " est le propriétaire de ce service.");
        }
    }

    @Override
    public double calculLoyer(Des des) {
        double loyer = 0;
        Observer quartier = getObserveur();
        if (quartier instanceof Quartier) {
            int nbServices = ((Quartier) quartier).getNbProprietesDetenues(this);
            if (nbServices == 2) {
                loyer =  10 * des.getTotalDes();
            } else {
                loyer = 4  * des.getTotalDes();
            }
        }
        return loyer;
    }

    @Override
    public int getPrix() {
        return prix;
    }

    @Override
    public double calculLoyer() {
        // Default method in case of error
        return 24;
    }
}
