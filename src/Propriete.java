
public abstract class Propriete extends Case implements Subject {

    protected Personnage proprietaire;
    protected Quartier quartier;

    public Personnage getProprietaire() {
        return proprietaire;
    }

    public Quartier getQuartier() {
        return quartier;
    }

    public void setProprietaire(Personnage proprietaire) {
        this.proprietaire = proprietaire;
    }

    @Override
    public void attache(Quartier quartier) {
        this.quartier = quartier;
    }

    @Override
    public void notifier() {
        this.quartier.update();
    }

    public Observer getObserveur() {
        return quartier; // Retourne le premier observateur par défaut
    }

    public boolean estProprietaire(Personnage joueur) {
        if(joueur == null) return false;
        return joueur.getMesProprietes().contains(this);
    }


    public abstract int getPrix();
    public abstract double calculLoyer();
    public abstract double calculLoyer(Des des);
}
