import java.util.ArrayList;
import java.util.List;

public class MenuConstructionRue extends Menu {
    
    private Rue rue;

    public MenuConstructionRue(Rue r) {
        super("Menu Construction - " + r.getNom() , creerOptions(r));
        this.rue = r;
    }

    private void updateTitle(Personnage joueur) {
        EtatConstructible erc = (EtatConstructible) rue.getEtatRue();
        String fixedPart = "Menu Construction - " + rue.getNom();
        String updatablePart = " | Maisons : " + erc.getNbMaison() + " | Hôtels : " + erc.getNbHotel() + "\n" + "Solde de " + joueur.getNom() + " : " +joueur.getSolde();
        this.setTitle(fixedPart + updatablePart);
    }

    @Override
    public void loop(Monopoly jeu) {
        int choix;
        updateTitle(jeu.getJoueurCourant());
        do {
            choix = getChoix();
            traiterChoix(choix, jeu);
            updateTitle(jeu.getJoueurCourant());
        } while (choix != 0);
    }

    private static List<String> creerOptions(Rue r) {
        EtatConstructible etatRue = (EtatConstructible) r.getEtatRue();
        List<String> list = new ArrayList<>();
        list.add("Fin construction");
        list.add("Construire 1 maison (" + etatRue.prix_maison() +")");
        list.add("Construire 1 hôtel (" + etatRue.prix_hotel() + ")");
        return list;
    }

    @Override
    public void traiterChoix(int choix) {}

    public void traiterChoix(int choix, Monopoly jeu) {
        Personnage joueur = jeu.getJoueurCourant();
        EtatConstructible etatRue = (EtatConstructible) rue.getEtatRue();
        System.out.println(" -- " + this.getOptions().get(choix)+" -- ");
        switch (choix) {
            case 0: // 0 - Fin construction
                break;
            case 1: // 1 - Construire une maison
                if (joueur.soldeSuffisant(rue.getPrixMaison())) {
                    etatRue.construire_maison();
                    joueur.payer(rue.getPrixMaison());
                } else {
                    System.out.println("Solde insuffisant pour acheter une maison");
                }
                break;
            case 2: //  2 - Construire un hôtel
                if (joueur.soldeSuffisant(rue.getPrixHotel())) {
                    etatRue.construire_hotel();
                    joueur.payer(rue.getPrixHotel());
                } else {
                    System.out.println("Solde insuffisant pour acheter une hotel");
                }
                break;
            default: // Relancer le menu
                break;
        }
    } 
}
