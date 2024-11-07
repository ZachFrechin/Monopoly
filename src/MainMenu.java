import java.util.ArrayList;
import java.util.List;

public class MainMenu extends Menu {

    public MainMenu() {
        super("Menu Monopoly", creerOptions());
    }

    private static List<String> creerOptions() {
        List<String> list = new ArrayList<>();
        list.add("Fin du programme");
        list.add("Lancer partie classique");
        list.add("Tomber sur un terrain libre");
        list.add("Tomber sur un terrain acheté");
        list.add("Acheter un terrain pour obtenir un quartier complet");
        list.add("Tomber sur un terrain acheté, dans un quartier entièrement possédé par le même joueur");
        list.add("Constuire dans un quartier possédé");
        list.add("Tomber sur un des gares possédées par un joueur");
        list.add("Tomber sur un des compagnies possédées par un joueur");
        list.add("Passer par la case Départ");
        list.add("Tomber sur une case Taxe");
        list.add("Tomver sur un terrain libre, sans pouvoir l'acheter");
        list.add("Tomber sur un terrain acheté, sans pouvoir payer");
        list.add("Tomber sur une taxe, sans pouvoir payer");
        return list;
    }

    @Override
    public void traiterChoix(int choix, Monopoly jeu) {}

    public void traiterChoix(int choix) {
        System.out.println(" -- " + this.getOptions().get(choix)+" -- ");
        Monopoly jeu;
        switch (choix) {
            case 0: // Exit le programme
                System.exit(0);
                break;
            case 1: // 1 - Lancer partie classique
                jeu = new Monopoly();
                jeu.lancerPartie(2);
                break;
            case 2: // 2 - Démo : Tomber sur un terrain libre
                jeu = new Monopoly();
                jeu.demo2();
                break;
            case 3: // 3 - Démo : Tomber sur un terrain acheté
                jeu = new Monopoly();
                jeu.demo3();
                break;
            case 4: // 4 - Démo : Acheter un terrain pour obtenir un quartier complet
                jeu = new Monopoly();
                jeu.demo4();
                break;
            case 5: // 5 - Démo : Tomber sur un terrain acheté, dans un quartier entièrement possédé par le même joueur
                jeu = new Monopoly();
                jeu.demo5();
                break;
            case 6: // 6 - Démo : Construire dans un quartier possédé
                jeu = new Monopoly();
                jeu.demo6();
                break;
            case 7: // 7 - Démo : Tomber sur une des gares possédées par un joueur
                jeu = new Monopoly();
                jeu.demo7();
                break;
            case 8: // 8 - Démo : Tomber sur une des compagnies possédées par un joueur
                jeu = new Monopoly();
                jeu.demo8();
                break;
            case 9: // 9 - Démo : Passer par la case Départ
                jeu = new Monopoly();
                jeu.demo9();
                break;
            case 10: // 10 - Démo : Tomber sur une case Taxe
                jeu = new Monopoly();
                jeu.demo10();
                break;
            case 11: // 11 - Démo : Tomber sur un terrain libre, sans pouvoir l'acheter
                jeu = new Monopoly();
                jeu.demo11();
                break;
            case 12: // 12 - Démo : Tomber sur un terrain acheté, sans pouvoir payer
                jeu = new Monopoly();
                jeu.demo12();
                break;
            case 13: // 13 - Démo : Tomber sur une taxe, sans pouvoir payer
                jeu = new Monopoly();
                jeu.demo13();
                break;
            default: // Relancer le menu
                break;
        }

    }
}
