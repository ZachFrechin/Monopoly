public class Fortune extends Case {

    @Override
    public void joueurArrive(Personnage joueur) {
        System.out.println(joueur.getNom() + " est arrivé sur une case Fortune.");
        // Logique pour donner un bonus ou une carte pourrait être ajoutée ici
    }
}
