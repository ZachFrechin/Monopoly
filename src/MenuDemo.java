import java.util.ArrayList;
import java.util.List;

public class MenuDemo extends Menu {
    
    public MenuDemo() {
        super("Menu Tour De Jeu Démo", creerOptions());
    }

        private static List<String> creerOptions() {
        List<String> list = new ArrayList<>();
        list.add("Fin du tour");
        list.add("Lancer les des");
        list.add("Construire des maisons / hôtels");
        list.add("Afficher mon solde");
        list.add("Afficher le plateau");
        return list;
    }

    @Override
    public void traiterChoix(int choix) {}

    public void traiterChoix(int choix, Monopoly jeu) {
        Personnage joueur = jeu.getJoueurCourant();
        System.out.println(" -- " + this.getOptions().get(choix)+" -- ");
        switch (choix) {
            case 0: // 0 - Fin du tour de jeu
                break;
            case 1: // 1 - Lancer les des
                joueur.jouerTour(jeu.getDes(), 1);
                break;
            case 2: //  2 - Construire maison / hôtel
                joueur.construire(jeu);
                break;
            case 3: // 3 -Afficher mon solde
                joueur.afficherSolde();
                break;
            case 4: // 4 - Afficher le plateau
                jeu.afficherPlateau();
                break;
            default: // Relancer le menu
                break;
        }

    }
    
}
