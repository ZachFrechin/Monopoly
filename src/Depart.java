public class Depart extends Case {
    
    @Override
    public String getNom() {
        return "Départ";
    }

    @Override
    public void joueurArrive(Personnage joueur) {
        System.out.println(joueur.getNom() + " est arrivé sur la case départ");
        // Logique future pour gérer les tours en prison
    }
}
