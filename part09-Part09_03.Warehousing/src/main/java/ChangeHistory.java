import java.util.ArrayList;

public class ChangeHistory {

    private final ArrayList<Double> history;

    public ChangeHistory() {
        this.history = new ArrayList<>();
    }

    public void add(double status) {
        history.add(status);
    }

    public void clear() {
        history.clear();
    }

    public double maxValue() {
        if (history.isEmpty()) {
            return 0;
        }

        double max = history.get(0);

        for (Double status : history) {
            if (status > max) {
                max = status;
            }
        }

        return max;
    }

    public double minValue() {
        if (history.isEmpty()) {
            return 0;
        }

        double min = history.get(0);

        for (Double status : history) {
            if (status < min) {
                min = status;
            }
        }

        return min;
    }

    public double average() {
        if (history.isEmpty()) {
            return 0;
        }

        double total = 0;

        for (Double status : history) {
            total += status;
        }

        return total / history.size();
    }

    @Override
    public String toString() {
        return history.toString();
    }
}
