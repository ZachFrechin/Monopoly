import java.util.ArrayList;
import java.util.List;

public class MenuAchat extends Menu {
    
    public MenuAchat(String nom) {
        super("Menu Achat : " + nom, creerOptions());
    }

        private static List<String> creerOptions() {
        List<String> list = new ArrayList<>();
        list.add("Non");
        list.add("Oui");
        return list;
    }

    @Override
    public void traiterChoix(int choix) {
    }

    public void traiterChoix(int choix, Monopoly jeu) {
    }
    
}
