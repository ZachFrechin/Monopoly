import java.util.ArrayList;
import java.util.List;

public class MenuConstruction extends Menu {
    
    public MenuConstruction(Personnage joueur) {
        super("Menu Construction", creerOptions(joueur));
    }

    private static List<String> creerOptions(Personnage joueur) {
        List<String> list = new ArrayList<>();
        List<Propriete> proprietesJoueur = joueur.getMesProprietes();
        list.add("Fin de construction");
        for (Propriete p : proprietesJoueur) {
            if (p instanceof Rue) {
                Rue pr = (Rue) p;
                if (pr.getEtatRue() instanceof EtatConstructible) {
                    list.add(pr.getNom() + " | Maisons : 0 | Hôtels : 0");
                } else if(pr.getEtatRue() instanceof EtatConstruit) {
                    list.add(pr.getNom() + " | Maisons : " + ((EtatConstruit) pr.getEtatRue()).getNbMaison() + " | Hôtels : " + ((EtatConstruit) pr.getEtatRue()).getNbHotel());
                }
            }
        }
        return list;
    }

    @Override
    public void traiterChoix(int choix) {}

    public void traiterChoix(int choix, Monopoly jeu) {
        Personnage joueur = jeu.getJoueurCourant();
        System.out.println(" -- " + this.getOptions().get(choix) + " -- ");
        switch (choix) { // Remplacer car nb choix inconnu
            default: // Fin menu
                break;
        }

    }
    
}
