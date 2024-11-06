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

    public Des getDes() {
        return this.des;
    }

    public Personnage getJoueurCourant() {
        return this.joueurs.get(joueurCourant);
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

    public void initJeuDemos() {
        creerJoueur("Joueur 1");
        creerJoueur("Joueur 2");
        joueurCourant = 0;
    }

    public void gererToursDeJeu() {
        MenuTour mt = new MenuTour();
        while (!finPartie()) {
            Personnage joueur = joueurs.get(joueurCourant);
            if (joueur.peutJouer()) {
                mt.setTitle("Menu Tour de Jeu - " + joueur.getNom());
                mt.loop(this);
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

    // ---- DEMOS METHODS ----
    public void demo2() {
        MenuDemo m = new MenuDemo();
        // Démo : Tomber sur un terrain libre
        initJeuDemos();
        m.loop(this);
    }

    public void demo3() {
        MenuDemo m  = new MenuDemo();
        // Démo : Tomber sur un terrain acheté
        initJeuDemos();
        Personnage j1 = joueurs.get(joueurCourant);
        Rue r = (Rue) plateau.getCase("Boulevard de Belleville");
        j1.nouvellePropriete(r);
        r.setEtat(new EtatAcheter(r));
        this.setJoueurCourant(); // Passer au joueur suivant pour le tour de jeu de la démo
        m.loop(this);
    }

    public void demo4() {
        MenuDemo m = new MenuDemo();
        // Démo : Acheter un terrain pour obtenir un quartier complet
        initJeuDemos();
        Personnage j1 = joueurs.get(joueurCourant);
        Case BlvBelleville = plateau.getCase("Boulevard de Belleville");
        Rue RueLecourbe = (Rue) plateau.getCase("Rue Lecourbe");
        j1.nouvellePropriete(RueLecourbe);
        RueLecourbe.setEtat(new EtatAcheter(RueLecourbe));
        m.loop(this);
    }

    public void demo5() {
        MenuDemo m = new MenuDemo();
        // Démo : Tomber sur un terrain acheté, dans un quartier entièrement possédé par le même joueur 
        initJeuDemos();
        Personnage j1 = joueurs.get(joueurCourant);
        Rue BlvBelleville = (Rue) plateau.getCase("Boulevard de Belleville");
        Rue RueLecourbe = (Rue) plateau.getCase("Rue Lecourbe"); // Step de 2
        j1.nouvellePropriete(BlvBelleville);
        j1.nouvellePropriete(RueLecourbe);

        RueLecourbe.setEtat(new EtatAcheter(RueLecourbe));
        BlvBelleville.setEtat(new EtatAcheter(BlvBelleville));
        this.setJoueurCourant();
        m.loop(this);
    }

    public void demo6() {
        // Démo : Construire dans un quartier possédé
        // TODO
    }

    public void demo7() {
        MenuDemo m = new MenuDemo();
        // Démo : Tomber sur une des gares possédées par un joueur
        initJeuDemos();
        Personnage j1 = joueurs.get(joueurCourant);
        Personnage j2 = joueurs.get((joueurCourant + 1) % joueurs.size());
        Gare gareMontparnasse = (Gare) plateau.getCase("Gare Montparnasse");
        Gare gareDeLyon = (Gare) plateau.getCase("Gare de Lyon");
        j1.nouvellePropriete(gareMontparnasse);
        j1.nouvellePropriete(gareDeLyon);
        j2.setPosition(plateau.getCase("Rue Lecourbe"));
        this.setJoueurCourant();
        m.loop(this);
    }

    public void demo8() {
        // Démo : Tomber sur une des compagnies possédées par un joueur
        // TODO
    }

    public void demo9() {
        // Démo : Passer par la case Départ
        // TODO
    }

    public void demo10() {
        // Démo : Tomber sur une case Taxe
        // TODO
    }

    public void demo11() {
        // Démo : Tomber sur un terrain libre, sans pouvoir l'acheter
        // TODO
    }

    public void demo12() {
        // Démo : Tomber sur un terrain acheté, sans pouvoir payer
        // TODO
    }
}
