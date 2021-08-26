import java.util.ArrayList;

public class BoxWithMaxWeight extends Box {

    private final ArrayList<Item> items;
    private final int capacity;

    public BoxWithMaxWeight(int capacity) {
        this.items = new ArrayList<>();
        this.capacity = capacity;
    }

    public boolean isCanFit(Item item) {
        int currentTotal = 0;

        for (Item boxItem : items) {
            currentTotal += boxItem.getWeight();
        }

        return (capacity - currentTotal - item.getWeight()) >= 0;
    }

    @Override
    public void add(Item item) {
        if (isCanFit(item)) {
            items.add(item);
        }
    }

    @Override
    public boolean isInBox(Item item) {
        return items.contains(item);
    }
}
