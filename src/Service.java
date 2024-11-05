public class Service extends Propriete {

    private int prix = 150;

    @Override
    public void joueurArrive(Personnage joueur) {
        if (!estProprietaire(joueur)) {
            double loyer = calculLoyer();
            joueur.payer(loyer);
            notifier();
            System.out.println(joueur.getNom() + " a payé une taxe de service de " + loyer);
        }
    }

    @Override
    public double calculLoyer() {
        Observer quartier = getObserveur();
        if (quartier instanceof Quartier quartier1) {
            int nbServices = quartier1.getNbProprietesDetenues(this);
            return 100 * nbServices;
        }
        return 0;
    }

    @Override
    public int getPrix() {
        return prix;
    }
}
