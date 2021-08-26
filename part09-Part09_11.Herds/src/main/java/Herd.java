import java.util.ArrayList;

public class Herd implements Movable {

    private ArrayList<Movable> group;

    public Herd() {
        this.group = new ArrayList<>();
    }

    public void addToHerd(Movable movable) {
        group.add(movable);
    }

    public void move(int dx, int dy) {
        for (Movable movable : group) {
            movable.move(dx, dy);
        }
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();

        for (Movable movable : group) {
            string.append(movable).append("\n");
        }

        return string.toString();
    }
}
