import java.util.ArrayList;
import java.util.List;

public class Case {

    private Case caseSuivante;
    private String nom;


    public void setCaseSuivante(Case caseSuivante) {
        this.caseSuivante = caseSuivante;
    }

    public Case getCaseSuivante() {
        return this.caseSuivante;
    }

    public String getNom() {
        return this.nom;
    }

    public Case avancer(int nbCase, Personnage joueur) {
        Case currentCase = this;
        for (int i = 0; i < nbCase; i++) {
            // Passer par la case départ
            if(currentCase instanceof Depart && i != 0) {
                // On vérifie si on ne part pas de la case départ pour ne pas donner 2x le salaire
                System.out.println(joueur.getNom() + " à toucher son salaire.");
                joueur.crediter(200);
            }
            if (currentCase.caseSuivante != null) {
                currentCase = currentCase.caseSuivante;
            }
        }
        // Tomber exactement sur la case départ
        if(currentCase instanceof Depart) {
            System.out.println(joueur.getNom() + " à toucher son salaire.");
            joueur.crediter(200);
        }
        return currentCase;
    }

    public void afficher(List<Personnage> l) {
        String s;
        if (this instanceof Propriete) {
            Personnage proprietaire = ((Propriete) this).getProprietaire();
            String nomProprietaire = proprietaire!=null?proprietaire.getNom():"Pas de proprietaire";
            String couleurQuartier = ((Propriete) this).getQuartier().getCouleur();
            s = couleurQuartier + this.getNom() +"("+ nomProprietaire +")" + ConsoleColors.RESET;
        } else {
            s = ConsoleColors.WHITE + this.getNom() + ConsoleColors.RESET;
        }
        for (Personnage p : l) {
            if (this == p.getPosition()) {
                s += " | " + p.getNom();
            }
        }
        System.out.println(s);
    }

    public void joueurArrive(Personnage personnage) {
        // Actions à réaliser quand un joueur arrive sur la case
    }

    public void joueurArrive(Personnage personnage, Des des) {
        // Actions à réaliser quand un joueur arrive sur la case
    }
}
