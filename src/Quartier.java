import java.util.ArrayList;
import java.util.List;

public class Quartier implements Observer {

    private String nom;
    private List<Propriete> proprietes = new ArrayList<>();


    public Quartier(String nom) {
        this.nom = nom;
    }

    public List<Propriete> getProprietes() {
        return this.proprietes;
    }

    public String getNom() {
        return this.nom;
    }

    public void ajouterPropriete(Propriete propriete) {
        proprietes.add(propriete);
        propriete.attache(this);
    }


    @Override
    public void update() {
        // Vérification de la possession complète et ajustement d'état pour la constructibilité si nécessaire
        if (getNbProprietesDetenues(this.proprietes.get(0)) == this.proprietes.size()) {
            // Toutes les propriétés appartiennent au même joueur
            for (Propriete p : this.proprietes) {
                if (p instanceof Rue) {
                    Rue rue = (Rue) p;  // Cast sécurisé
                    rue.getEtatRue().devientConstructible();
                }
            }
        }
    }

    public int getNbProprietesDetenues(Propriete propriete) {
        int count = 0;
        for (Propriete p : proprietes) {
            if (p.estProprietaire(propriete.getProprietaire())) {
                count++;
            }
        }
        return count;
    }
}
