import java.util.Random;

public class Die {

    private final Random random;
    private final int numberOfFaces;

    public Die(int numberOfFaces) {
        this.random = new Random();
        this.numberOfFaces = numberOfFaces;
    }

    public int throwDie() {
        return random.nextInt(numberOfFaces) + 1;
    }
}
