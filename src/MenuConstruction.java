import java.util.ArrayList;
import java.util.List;

public class MenuConstruction extends Menu {

    private static List<Rue> rueConstructibles = new ArrayList();
    private Personnage joueur;
    
    public MenuConstruction(Personnage joueur) {
        super("Menu Construction", creerOptions(joueur));
        this.joueur = joueur;
    }

    private static List<String> creerOptions(Personnage joueur) {
        List<String> list = new ArrayList<>();
        List<Propriete> proprietesJoueur = joueur.getMesProprietes();
        list.add("Fin de construction");
        for (Propriete p : proprietesJoueur) {
            if (p instanceof Rue) {
                Rue pr = (Rue) p;
                if (pr.getEtatRue() instanceof EtatConstructible) {
                    EtatConstructible erc = (EtatConstructible) pr.getEtatRue();
                    list.add(pr.getNom() + " | Maisons : " + erc.getNbMaison() + " | Hôtels : " + erc.getNbHotel());
                }
                rueConstructibles.add(pr);
            }
        }
        return list;
    }

    private void updateOptions() {
        this.setOptions(creerOptions(joueur));
    }

    @Override
    public void loop(Monopoly jeu) {
        int choix;
        updateOptions();
        do {
            choix = getChoix();
            traiterChoix(choix, jeu);
            updateOptions();
        } while (choix != 0);
    }


    @Override
    public void traiterChoix(int choix) {}

    public void traiterChoix(int choix, Monopoly jeu) {
        if (choix > 0 ) {
            System.out.println(" -- " + this.getOptions().get(choix - 1) + " -- ");
            Rue rueChoisie = rueConstructibles.get(choix - 1);
            MenuConstructionRue mcr = new MenuConstructionRue(rueChoisie);
            mcr.loop(jeu);
        }
    }
    
}
