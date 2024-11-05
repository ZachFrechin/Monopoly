import java.util.Random;

public class Des {

    private int des1;
    private int des2;
    private Random random = new Random();

    public void lancerDes() {
        des1 = random.nextInt(6) + 1;
        des2 = random.nextInt(6) + 1;
    }

    public int getTotalDes() {
        return des1 + des2;
    }

    public boolean estDouble() {
        return des1 == des2;
    }
}
