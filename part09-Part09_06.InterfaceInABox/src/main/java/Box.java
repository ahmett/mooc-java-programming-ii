import java.util.ArrayList;

public class Box implements Packable {

    private final double capacity;
    private final ArrayList<Packable> items;

    public Box(double capacity) {
        this.capacity = capacity;
        this.items = new ArrayList<>();
    }

    public double weight() {
        double total = 0;

        for (Packable item : items) {
            total += item.weight();
        }

        return total;
    }

    private boolean availableFor(Packable packable) {
        double current = weight();

        return (capacity - current - packable.weight()) >= 0;
    }

    public void add(Packable packable) {
        if (availableFor(packable)) {
            items.add(packable);
        }
    }

    @Override
    public String toString() {
        return "Box: " + items.size() + " items" + ", total weight " + weight() + " kg";
    }
}
