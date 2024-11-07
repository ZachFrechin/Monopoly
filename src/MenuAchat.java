import java.util.ArrayList;
import java.util.List;

public class MenuAchat extends Menu {
    
    public MenuAchat(String nom, int prix) {
        super("Menu Achat : " + nom + " - Prix d'achat :" + prix , creerOptions());
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
