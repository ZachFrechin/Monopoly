public class EtatConstructible extends EtatRue {

    private int maison;
    private int hotel;
    private int[] coeff = new int[] {5, 15, 45, 80};

    public EtatConstructible(Rue rue) {
        super(rue);
        maison = 0;
        hotel = 0;

        
    }

    @Override
    public void joueurArrive(Personnage joueur) {
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
    public double calculLoyer() {
        return rue.getPrix() * 1.5; // Exemple d’un loyer majoré sans constructions
    }

    public void construire(int nbMaison, int nbHotel) {
        if (nbMaison > 0 || nbHotel > 0) {
            rue.setEtat(new EtatConstruit(rue, nbMaison, nbHotel));
            notifier();
            System.out.println("Construction terminée : " + nbMaison + " maisons, " + nbHotel + " hôtel(s).");
        }
    }

    @Override
    public void construire_maison() {
        if(maison == 4) {
            System.out.println("Vous ne pouvez pas construire plus de maison.");
        }else {
        construire(1, 0);
        }
    }

    @Override 
    public void construire_hotel() {    
        if(hotel == 4) {
            System.out.println("Vous ne pouvez pas construire plus de hotel.");
        }else {
        construire(0, 1);
        }
    }

    @Override 
    public int prix_maison() {
        return rue.getPrix() * this.coeff[maison];
    }

    @Override
    public int prix_hotel() {
        return rue.getPrix() * this.coeff[hotel];
    }
}
