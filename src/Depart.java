public class Depart extends Case {
    
    private int salaire = 200;
    @Override
    public void joueurArrive(Personnage joueur) {
        System.out.println(joueur.getNom() + " est arrivé sur la case départ");
        // Logique future pour gérer les tours en prison
    }

    
}
