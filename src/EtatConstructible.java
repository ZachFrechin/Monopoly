public class EtatConstructible extends EtatRue {

    private int maison;
    private int hotel;
    private int[] coeff = new int[] {1, 1, 3, 5, 7};

    public EtatConstructible(Rue rue) {
        super(rue);
        maison = 0;
        hotel = 0;
    }

    public void setNbMaison(int nbMaison) {
        this.maison = nbMaison;
    }

    public void setNbHotel(int nbHotel) {
        this.hotel = nbHotel;
    }

    public int getNbMaison() {
        return this.maison;
    }

    public int getNbHotel() {
        return this.hotel;
    }

    public int[] getCoeff() {
        return this.coeff;
    }

    @Override
    public void joueurArrive(Personnage joueur) {
        rue.afficherDetails();
        if (!rue.estProprietaire(joueur)) {
            double loyer = calculLoyer();
            joueur.payer(loyer);
            rue.getProprietaire().crediter(loyer);
            System.out.println(joueur.getNom() + " a payé un loyer de " + loyer + " à " + rue.getProprietaire().getNom());
        } else {
            System.out.println(joueur.getNom() + " est le propriétaire de cette rue et peut y construire.");
        }
    }

    @Override
    public int loyer_maison() { 
        return this.rue.getLoyerMaison();
    }

    @Override
    public int loyer_hotel() {
        return this.rue.getLoyerHotel();
    }

    @Override
    public int calculLoyer() {
        return (rue.getPrix() * 2) + (maison * loyer_maison()) + (hotel * loyer_hotel());
    }

    public void construire(int nbMaison, int nbHotel) {
        this.maison += nbMaison;
        this.hotel += nbHotel;
    }

    @Override
    public void construire_maison() {
        if(maison == 4) {
            System.out.println("Vous ne pouvez pas construire plus de maison.");
        } else if (hotel == 4) {
            System.out.println("Le nombre maximum de bâtiments a été atteint !");
        }else {
            construire(1, 0);
            System.out.println("Maison construite !");
        }
    }

    @Override 
    public void construire_hotel() {    
        if(hotel == 4) {
            System.out.println("Vous ne pouvez pas construire plus de hotel.");
        } else if (maison != 4) {
            System.out.println("Il faut 4 maisons pour construire un hôtel !");
        }else {
            construire(0, 1);
            this.setNbMaison(0);
            System.out.println("Hôtel construit !");
        }
    }
    
    public void devientConstruit(int nbMaison, int nbHotel) {
        rue.setEtat(new EtatConstruit(rue, nbMaison, nbHotel));
        notifier();
        System.out.println(rue.getNom() + " - Construction terminée : " + nbMaison + " maisons, " + nbHotel + " hôtel(s).");
    }
}
