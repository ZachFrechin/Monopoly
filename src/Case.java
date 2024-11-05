public class Case {

    private Case caseSuivante;

    public void setCaseSuivante(Case caseSuivante) {
        this.caseSuivante = caseSuivante;
    }

    public Case avancer(int nbCase) {
        Case currentCase = this;
        for (int i = 0; i < nbCase; i++) {
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
