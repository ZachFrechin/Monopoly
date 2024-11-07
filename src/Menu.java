import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Menu {

    private String title;
    private List<String> options = new ArrayList<>();

    Menu(String title, List<String> options) {
        this.title = title;
        this.options = options;
    }

    public List<String> getOptions() {
        return this.options;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void loop(Monopoly jeu) {
        int choix;
        do {
            choix = getChoix();
            traiterChoix(choix, jeu);
        } while (choix != 0);
    }

    public void loop () {
        int choix;
        do {
            choix = getChoix();
            traiterChoix(choix);
        } while (choix != 0);
    }

    private void afficher() {
        System.out.println(this.title + " : ");
        System.out.println("-----------------------");
        for (int i = 0; i < this.options.size(); i++) {
            System.out.println(i + " - " + this.options.get(i));
        }
    }

    protected int getChoix() {
        String input;
        Scanner scanner = new Scanner(System.in);
        Integer choix = null;
        while (choix == null) {
            this.afficher();
            System.out.println("\n Entrez le numéro correspondant à votre choix...");
            input = scanner.nextLine();
            try {
                choix = Integer.parseInt(input);
                if (choix < 0 || choix >= this.options.size()) {
                    System.err.println("Le numéro indiqué n'est pas un choix valide, veuillez réessayer.");
                    choix = null;
                }
            } catch(Exception ex) {
                System.err.println("Le numéro indiqué ne semble pas être un entier, veuillez réessayer.");
            }
        }
        return choix;
    }

    protected abstract void traiterChoix(int choix);
    protected abstract void traiterChoix(int choix, Monopoly jeu);
}