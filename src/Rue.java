public class Rue extends Propriete {

    private String nom;
    private int loyer;
    private int prixMaison;
    private int loyerMaison;
    private int loyerHotel;
    private EtatRue etatRue;


    public String getNom() {
        return nom;
    }
    public int getLoyerMaison() {
        return loyerMaison;
    }

    public int getLoyerHotel() {
        return loyerHotel;
    }

    public EtatRue getEtatRue() {
        return this.etatRue;
    }

    public Rue(String nom, int loyer, int prixMaison, int loyerMaison, int loyerHotel) {
        this.nom = nom;
        this.loyer = loyer;
        this.prixMaison = prixMaison;
        this.loyerMaison = loyerMaison;
        this.loyerHotel = loyerHotel;
        this.etatRue = new EtatLibre(this); // État initial
    }

    public void afficherDetails() {
        String nomProprietaire = proprietaire!=null?proprietaire.getNom():"Pas de proprietaire";
        System.out.println("- " + nom + " -");
        System.out.println("Proprietaire : " + nomProprietaire);
        System.out.println("\tLoyers");
        System.out.println("Terrain unique : " + loyer);
        System.out.println("Quartier entier : " + (loyer * 1.5));
        System.out.println("Par maison : " + loyerMaison);
        System.out.println("Par hôtel : " + loyerHotel);
        System.out.println("\tMaisons & Hôtels");
        if (this.etatRue instanceof EtatConstruit) {
            System.out.println("Maisons : " + ((EtatConstruit) this.getEtatRue()).getNbMaison() + " | Hôtels : " + ((EtatConstruit) this.getEtatRue()).getNbHotel());
        } else {
            System.out.println("Maisons : 0 | Hôtels : 0");
        }
        System.out.println("--------------------------");
    }

    @Override
    public void notifier() {
        // Logique de notification vers l’observateur
        if (getObserveur() != null) {
            getObserveur().update();
        }
    }

    @Override
    public void joueurArrive(Personnage joueur) {
        etatRue.joueurArrive(joueur);
    }

    public void setEtat(EtatRue etat) {
        this.etatRue = etat;
        notifier();
    }

    @Override
    public double calculLoyer() {
        return etatRue.calculLoyer();
    }

    @Override
    public double calculLoyer(Des des) {
        return etatRue.calculLoyer();
    }

    public int getPrix() {
        return loyer;
    }
}
