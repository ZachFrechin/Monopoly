public class Taxe extends Case {

    private double montantTaxe;

    Taxe(int montant) {
        this.montantTaxe = montant;
    }

    @Override
    public void joueurArrive(Personnage joueur) {
        System.err.println(joueur.getNom() + " est arrivé sur une case taxe.");
        joueur.payer(montantTaxe);
        System.out.println(joueur.getNom() + " a payé une taxe de " + montantTaxe);
    }
}
