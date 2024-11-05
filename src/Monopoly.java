import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        joueurs.add(new Personnage(name, plateau.getCaseDepart()));
    }

    public void initJeu(final int nbj) {
                
        Scanner scanner = new Scanner(System.in);
        String input;

        // Boucle
        for(int i = 0; i < nbj; i++) {
            System.out.println("Entrez le nom du Joueur " + i);
            input = scanner.nextLine();
            creerJoueur(input);
        }
        joueurCourant = 0;
    }

    public void gererToursDeJeu() {
        while (!finPartie()) {
            Personnage joueur = joueurs.get(joueurCourant);
            if (joueur.peutJouer()) {
                joueur.jouerTour(des);
            }
            Scanner scanner = new Scanner(System.in);
            System.out.println("Passer à l'étape suivante >>>");
            scanner.nextLine();
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
