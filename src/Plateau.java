import java.util.ArrayList;
import java.util.List;

public class Plateau {

    private Case caseDepart;
    private List<Case> cases = new ArrayList<>();
    private List<Quartier> quartiers = new ArrayList<>();

    public Plateau() {
        genererCases();
    }

    private void genererCases() {
        // Création des quartiers
        Quartier marron = new Quartier("Marron");
        Quartier bleuClair = new Quartier("Bleu Clair");
        Quartier rose = new Quartier("Rose");
        Quartier orange = new Quartier("Orange");
        Quartier rouge = new Quartier("Rouge");
        Quartier jaune = new Quartier("Jaune");
        Quartier vert = new Quartier("Vert");
        Quartier bleuFonce = new Quartier("Bleu Foncé");
        Quartier gares = new Quartier("Gares");
        Quartier services = new Quartier("Services");

        // Ajout des quartiers à la liste
        quartiers.add(marron);
        quartiers.add(bleuClair);
        quartiers.add(rose);
        quartiers.add(orange);
        quartiers.add(rouge);
        quartiers.add(jaune);
        quartiers.add(vert);
        quartiers.add(bleuFonce);
        quartiers.add(gares);
        quartiers.add(services);

        // Case de départ
        caseDepart = new Depart();
        cases.add(caseDepart);

        // Ajout des cases du vrai Monopoly

        // Groupe marron
        Rue boulevardDeBelleville = new Rue("Boulevard de Belleville", 60, 50, 10, 100);
        Rue rueLecourbe = new Rue("Rue Lecourbe", 60, 50, 10, 100);
        marron.ajouterPropriete(boulevardDeBelleville);
        marron.ajouterPropriete(rueLecourbe);
        cases.add(boulevardDeBelleville);
        cases.add(new Fortune());
        cases.add(rueLecourbe);
        cases.add(new Taxe()); // Impôt sur le revenu

        // Gare Montparnasse
        Gare gareMontparnasse = new Gare("Gare Montparnasse");
        gares.ajouterPropriete(gareMontparnasse);
        cases.add(gareMontparnasse);

        // Groupe bleu clair
        Rue rueDeVaugirard = new Rue("Rue de Vaugirard", 100, 50, 30, 150);
        Rue rueDeCourcelles = new Rue("Rue de Courcelles", 100, 50, 30, 150);
        Rue avenueDeLaRepublique = new Rue("Avenue de la République", 120, 50, 40, 180);
        bleuClair.ajouterPropriete(rueDeVaugirard);
        bleuClair.ajouterPropriete(rueDeCourcelles);
        bleuClair.ajouterPropriete(avenueDeLaRepublique);
        cases.add(rueDeVaugirard);
        cases.add(new Fortune());
        cases.add(rueDeCourcelles);
        cases.add(avenueDeLaRepublique);

        // Prison
        cases.add(new Prison());

        // Groupe rose
        Rue boulevardDeLaVillette = new Rue("Boulevard de la Villette", 140, 100, 50, 200);
        Rue avenueDeNeuilly = new Rue("Avenue de Neuilly", 140, 100, 50, 200);
        Rue rueDeParadis = new Rue("Rue de Paradis", 160, 100, 60, 220);
        Service elec = new Service("Compagnie de distribution d'électricité");
        rose.ajouterPropriete(boulevardDeLaVillette);
        rose.ajouterPropriete(avenueDeNeuilly);
        rose.ajouterPropriete(rueDeParadis);
        services.ajouterPropriete(elec);
        cases.add(boulevardDeLaVillette);
        cases.add(elec);
        cases.add(avenueDeNeuilly);
        cases.add(rueDeParadis);

        // Gare de Lyon
        Gare gareDeLyon = new Gare("Gare de Lyon");
        gares.ajouterPropriete(gareDeLyon);
        cases.add(gareDeLyon);

        // Groupe orange
        Rue avenueMozart = new Rue("Avenue Mozart", 180, 100, 70, 250);
        Rue boulevardSaintMichel = new Rue("Boulevard Saint-Michel", 180, 100, 70, 250);
        Rue placePigalle = new Rue("Place Pigalle", 200, 100, 80, 300);
        Service eau = new Service("Compagnie de distribution d'eau");
        orange.ajouterPropriete(avenueMozart);
        orange.ajouterPropriete(boulevardSaintMichel);
        orange.ajouterPropriete(placePigalle);
        services.ajouterPropriete(eau);
        cases.add(avenueMozart);
        cases.add(new Fortune());
        cases.add(boulevardSaintMichel);
        cases.add(eau);
        cases.add(placePigalle);

        // Création des liens entre les cases
        for (int i = 0; i < cases.size() - 1; i++) {
            cases.get(i).setCaseSuivante(cases.get(i + 1));
        }
        // Boucle le plateau pour que la dernière case mène à la première
        cases.get(cases.size() - 1).setCaseSuivante(caseDepart);
    }

    public Case getCaseDepart() {
        return caseDepart;
    }

    public List<Case> getCases() {
        return cases;
    }

    public List<Quartier> getQuartiers() {
        return quartiers;
    }
}
