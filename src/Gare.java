public class Gare extends Propriete {

    private int prix = 200;

    @Override
    public void joueurArrive(Personnage joueur) {
        if (!estProprietaire(joueur)) {
            double loyer = calculLoyer();
            joueur.payer(loyer);
            notifier();
            System.out.println(joueur.getNom() + " a payé un loyer de gare de " + loyer);
        }
    }

    @Override
    public double calculLoyer() {
        Observer quartier = getObserveur();
        if (quartier instanceof Quartier) {
            int nbGares = ((Quartier) quartier).getNbProprietesDetenues(this);
            return 50 * Math.pow(2, nbGares - 1);
        }
        return 0;
    }

    @Override
    public int getPrix() {
        return prix;
    }
}
