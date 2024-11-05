import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // Initialisation des variables
        Monopoly game = new Monopoly();
        // Initialisation du jeu
        creerJoueurs(game);
        game.initJeu();
        game.lancerPartie();
    }

    private static void creerJoueurs(Monopoly jeu) {
        // Initialisation des variables
        Scanner scanner = new Scanner(System.in);
        int nb_joueurs = 0;
        String input;

        // Structure d'ajout de joueur
        System.out.println("Entrez le nom du Joueur " + (nb_joueurs + 1) + " :");
        input = scanner.nextLine();
        // Boucle
        while (!input.equals("exit") && nb_joueurs < 2) {
            // Traitement de l'élément
            jeu.creerJoueur(input);
            // Mise à jour de l'élément
            nb_joueurs++;
            System.out.println("Entrez le nom du Joueur " + (nb_joueurs + 1) +(nb_joueurs < 2 ? "" : ": ('exit' pour terminer la création de joueur)"));
            input = scanner.nextLine();
        }
    }
}
