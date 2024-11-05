import java.util.ArrayList;
import java.util.List;

public class Quartier implements Observer {

    private String nom;
    private List<Propriete> proprietes = new ArrayList<>();


    public Quartier(String nom) {
        this.nom = nom;
    }

    public void ajouterPropriete(Propriete propriete) {
        proprietes.add(propriete);
        propriete.attache(this);
    }


    @Override
    public void update() {
        System.out.println("Mise à jour du quartier : vérification des propriétés détenues.");
        // Vérification de la possession complète et ajustement d'état pour la constructibilité si nécessaire
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
