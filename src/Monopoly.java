import java.util.ArrayList;
import java.util.List;

public class Monopoly {

    private int joueurCourant = 0;
    private Des des = new Des();
    private Plateau plateau = new Plateau();
    private List<Personnage> joueurs = new ArrayList<>();

    public void lancerPartie(final int nbj) {
        initJeu(nbj);
        gererToursDeJeu();
    }

    public void setJoueurCourant() {
        joueurCourant = (joueurCourant + 1) % joueurs.size();
    }

    public void creerJoueur(String name) {
        joueurs.add(new Personnage(name));
    }

    public void initJeu(final int nbj) {
        for (int i = 1; i <= nbj; i++) {
            creerJoueur("Joueur" + i);
        }
        joueurCourant = 0;
    }

    public void gererToursDeJeu() {
        while (!finPartie()) {
            Personnage joueur = joueurs.get(joueurCourant);
            if (joueur.peutJouer()) {
                joueur.jouerTour(des);
            }
            setJoueurCourant();
        }
        System.out.println("Partie terminée ! Le gagnant est : " + joueurs.get(joueurCourant).getNom());
    }

    public boolean finPartie() {
        int joueursActifs = 0;
        for (Personnage joueur : joueurs) {
            if (joueur.peutJouer()) joueursActifs++;
        }
        return joueursActifs <= 1;
    }
}
