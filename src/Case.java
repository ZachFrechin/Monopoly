public class Case {

    private Case caseSuivante;
    private String nom;


    public void setCaseSuivante(Case caseSuivante) {
        this.caseSuivante = caseSuivante;
    }

    public Case avancer(int nbCase, Personnage joueur) {
        Case currentCase = this;
        for (int i = 0; i < nbCase; i++) {
            if(currentCase instanceof Depart) {
                System.out.println(joueur.getNom() + " à toucher son salaire.");
                joueur.crediter(200);
            }
            if (currentCase.caseSuivante != null) {
                currentCase = currentCase.caseSuivante;
            }
        }
        return currentCase;
    }

    public void joueurArrive(Personnage personnage) {
        // Actions à réaliser quand un joueur arrive sur la case
    }
}
