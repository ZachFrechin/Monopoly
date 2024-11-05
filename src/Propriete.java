import java.util.ArrayList;
import java.util.List;

public abstract class Propriete extends Case implements Subject {

    protected Personnage proprietaire;
    protected List<Quartier> quartiers = new ArrayList<>();

    public Personnage getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Personnage proprietaire) {
        this.proprietaire = proprietaire;
    }

    @Override
    public void attache(Quartier quartier) {
        quartiers.add(quartier);
    }

    @Override
    public void notifier() {
        for (Quartier quartier : quartiers) {
            quartier.update();
        }
    }

    public Observer getObserveur() {
        return quartiers.isEmpty() ? null : quartiers.get(0); // Retourne le premier observateur par défaut
    }

    public boolean estProprietaire(Personnage joueur) {
        return joueur.getMesProprietes().contains(this);
    }


    public abstract int getPrix();
    public abstract double calculLoyer();
}
