import java.util.ArrayList;
import java.util.List;


public class Plateau {

    private Case caseDepart;
    private List<Case> cases = new ArrayList<>();
    private List<Quartier> quartiers = new ArrayList<>();

    public Plateau() {
        genererCases();
        System.out.println("Fin génération cases");
    }

    private void genererCases() {
        // Création des quartiers
        Quartier marron = new Quartier("Marron");
        marron.setCouleur(ConsoleColors.CHOCOLATE);
        Quartier bleuClair = new Quartier("Bleu Clair");
        bleuClair.setCouleur(ConsoleColors.DEEPSKYBLUE);
        Quartier rose = new Quartier("Rose");
        rose.setCouleur(ConsoleColors.HOTPINK);
        Quartier orange = new Quartier("Orange");
        orange.setCouleur(ConsoleColors.ORANGE);
        Quartier rouge = new Quartier("Rouge");
        rouge.setCouleur(ConsoleColors.RED);
        Quartier jaune = new Quartier("Jaune");
        jaune.setCouleur(ConsoleColors.GOLD);
        Quartier vert = new Quartier("Vert");
        vert.setCouleur(ConsoleColors.LIGHTGREEN);
        Quartier bleuFonce = new Quartier("Bleu Foncé");
        bleuFonce.setCouleur(ConsoleColors.ROYALBLUE);
        Quartier gares = new Quartier("Gares");
        gares.setCouleur(ConsoleColors.WHITE);
        Quartier services = new Quartier("Services");
        services.setCouleur(ConsoleColors.WHITE);

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

        // Debut Quartier Marron
        Rue BoulevardDeBelleville = new Rue("Boulevard de Belleville", 60, 2, 50, 200);
        marron.ajouterPropriete(BoulevardDeBelleville);
        cases.add(BoulevardDeBelleville);

        // Case Fortune
        cases.add(new Fortune());

        // Fin Quartier Marron
        Rue RueLecourbe = new Rue("Rue Lecourbe", 60, 4, 50, 400);
        marron.ajouterPropriete(RueLecourbe);
        cases.add(RueLecourbe);

        // Impôt sur le revenu
        cases.add(new Taxe(200)); 

        // Gare Montparnasse
        Gare gareMontparnasse = new Gare("Gare Montparnasse", 200);
        gares.ajouterPropriete(gareMontparnasse);
        cases.add(gareMontparnasse);

        // Debut Quartier Bleu Clair
        Rue RueDeVaugirard = new Rue("Rue de Vaugirard", 100, 6, 50, 600);
        bleuClair.ajouterPropriete(RueDeVaugirard);
        cases.add(RueDeVaugirard);

        // Case Fortune
        cases.add(new Fortune());

        // Fin Quartier Bleu Clair
        Rue RueDeCourcelles = new Rue("Rue de Courcelles", 100, 6, 50, 600);
        bleuClair.ajouterPropriete(RueDeCourcelles);
        cases.add(RueDeCourcelles);

        Rue AvenueDeLaRepublique = new Rue("Avenue de la République", 120, 8, 50, 800);
        bleuClair.ajouterPropriete(AvenueDeLaRepublique);
        cases.add(AvenueDeLaRepublique);

        // Case Fortune
        cases.add(new Fortune());

        // Debut Quartier Rose
        Rue BoulevardDeLaVillette = new Rue("Boulevard de la Villette", 140, 10, 100, 1000);
        rose.ajouterPropriete(BoulevardDeLaVillette);
        cases.add(BoulevardDeLaVillette);

        // Service d'Électricité
        Service serviceElec = new Service("Compagnie de distribution d'électricité", 150);
        cases.add(serviceElec);
        services.ajouterPropriete(serviceElec);
        
        // Fin Quartier Rose
        Rue AvenueDeNeuilly = new Rue("Avenue de Neuilly", 140, 10, 100, 1000);
        rose.ajouterPropriete(AvenueDeNeuilly);
        cases.add(AvenueDeNeuilly);

        Rue RueDeParadis = new Rue("Rue de Paradis", 160, 12, 100, 1200);
        rose.ajouterPropriete(RueDeParadis);
        cases.add(RueDeParadis);

        // Gare de Lyon
        Gare gareDeLyon = new Gare("Gare de Lyon", 200);
        gares.ajouterPropriete(gareDeLyon);
        cases.add(gareDeLyon);

        // Début Quartier Orange
        Rue AvenueMozart = new Rue("Avenue Mozart", 180, 14, 100, 1400);
        orange.ajouterPropriete(AvenueMozart);
        cases.add(AvenueMozart);

        // Case Fortune
        cases.add(new Fortune());

        // Fin Quartier Orange
        Rue BoulevardSaintMichel = new Rue("Boulevard Saint-Michel", 180, 14, 100, 1400);
        orange.ajouterPropriete(BoulevardSaintMichel);
        cases.add(BoulevardSaintMichel);

        Rue PlacePigalle = new Rue("Place Pigalle", 200, 16, 100, 1600);
        orange.ajouterPropriete(PlacePigalle);
        cases.add(PlacePigalle);

        // Case Prison
        cases.add(new Prison());

        // Debut Quartier Rouge
        Rue AvenueMatignon = new Rue("Avenue Matignon", 220, 18, 150, 1800);
        rouge.ajouterPropriete(AvenueMatignon);
        cases.add(AvenueMatignon);

        // Case Fortune
        cases.add(new Fortune());

        // Fin Quartier Rouge
        Rue BoulevardMalesherbes = new Rue("Boulevard Malesherbes", 220, 18, 150, 1800);
        rouge.ajouterPropriete(BoulevardMalesherbes);
        cases.add(BoulevardMalesherbes);

        Rue AvenueHenriMartin = new Rue("Avenue Henri Martin", 240, 20, 150, 2000);
        rouge.ajouterPropriete((Propriete) AvenueHenriMartin);
        cases.add(AvenueHenriMartin);

        // Gare du Nord
        Gare gareDuNord = new Gare("Gare du Nord", 200);
        gares.ajouterPropriete(gareDuNord);
        cases.add(gareDuNord);

        // Début Quartier Jaune
        Rue FaubourgSaintHonore = new Rue("Faubourg Saint Honoré", 260, 22, 150, 2200);
        jaune.ajouterPropriete(FaubourgSaintHonore);
        cases.add(FaubourgSaintHonore);

        Rue PlaceDeLaBourse = new Rue("Place de la Bourse", 260, 22, 150, 2200);
        jaune.ajouterPropriete(PlaceDeLaBourse);
        cases.add(PlaceDeLaBourse);

        // Service des Eaux
        Service serviceEau = new Service("Compagnie de distribution des eaux", 150);
        cases.add(serviceEau);
        services.ajouterPropriete(serviceEau);

        // Fin Quartier Jaune
        Rue RueLaFayette = new Rue("Rue la Fayette", 280, 24, 150, 2400);
        jaune.ajouterPropriete(RueLaFayette);
        cases.add(RueLaFayette);

        // Case Fortune
        cases.add(new Fortune());

        // Debut Quartier Vert
        Rue AvenueDeBreteuil = new Rue("Avenue de Breteuil", 300, 26, 200, 2600);
        vert.ajouterPropriete(AvenueDeBreteuil);
        cases.add(AvenueDeBreteuil);

        Rue AvenueFoch = new Rue("Avenue Foch", 300, 26, 200, 2600);
        vert.ajouterPropriete(AvenueFoch);
        cases.add(AvenueFoch);

        // Case Fortune
        cases.add(new Fortune());

        // Fin Quartier Vert
        Rue BoulevardDesCapucines = new Rue("Boulevard des Capucines", 320, 28, 200, 2800);
        vert.ajouterPropriete(BoulevardDesCapucines);
        cases.add(BoulevardDesCapucines);

        // Gare Saint Lazarre
        Gare gareSaintLazarre = new Gare("Gare Saint Lazarre", 200);
        gares.ajouterPropriete(gareSaintLazarre);
        cases.add(gareSaintLazarre);

        // Case Fortune
        cases.add(new Fortune());

        // Debut Quartier Bleu Fonce
        Rue AvenuedesChampsElysees = new Rue("Avenue des Champs Elysees", 350, 35, 200, 3500);
        bleuFonce.ajouterPropriete(AvenuedesChampsElysees);
        cases.add(AvenuedesChampsElysees);

        // Taxe de Luxe
        cases.add(new Taxe(100)); 

        // Fin Quartier Bleu Fonce
        Rue RueDeLaPaix = new Rue("Rue de la Paix", 400, 50, 200, 5000);
        bleuFonce.ajouterPropriete(RueDeLaPaix);
        cases.add(RueDeLaPaix);

        // Création des liens entre les cases
        for (int i = 0; i < cases.size() - 1; i++) {
            cases.get(i).setCaseSuivante(cases.get(i + 1));
        }
        // Boucle le plateau pour que la dernière case mène à la première
        cases.get(cases.size() - 1).setCaseSuivante(caseDepart);
    }

    public Case getCase(String nom) {
        Case rCase = null;
        for (Case c : this.cases ) {
            if (c.getNom() == nom) {
                rCase = c;
            }
        }
        return rCase;
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

    public void afficher(List<Personnage> l) {
        for (int i = 0; i < cases.size(); i++) {
            cases.get(i).afficher(l);
        }
    }
}