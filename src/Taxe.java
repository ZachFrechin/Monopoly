public class Taxe extends Case {

    private double montantTaxe = 100; // Exemple de montant de taxe

    @Override
    public void joueurArrive(Personnage joueur) {
        joueur.payer(montantTaxe);
        System.out.println(joueur.getNom() + " a payé une taxe de " + montantTaxe);
    }
}
