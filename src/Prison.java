public class Prison extends Case {

    @Override
    public void joueurArrive(Personnage joueur) {
        System.out.println(joueur.getNom() + " est sur la case prison.");
        // Logique future pour gérer les tours en prison
    }
}
