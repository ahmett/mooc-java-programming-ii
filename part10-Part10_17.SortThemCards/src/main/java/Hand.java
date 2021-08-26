import java.util.ArrayList;
import java.util.Collections;

public class Hand implements Comparable<Hand> {

    private final ArrayList<Card> cards;

    public Hand() {
        this.cards = new ArrayList<>();
    }

    public void add(Card card) {
        cards.add(card);
    }

    public void print() {
        for (Card card : cards) System.out.println(card);
    }

    public void sort() {
        Collections.sort(cards);
    }

    public void sortBySuit() {
        cards.sort(new BySuitInValueOrder());
    }

    @Override
    public int compareTo(Hand o) {
        int _this = cards.stream().map(Card::getValue).reduce(0, Integer::sum);
        int other = o.cards.stream().map(Card::getValue).reduce(0, Integer::sum);

        return _this - other;
    }
}
