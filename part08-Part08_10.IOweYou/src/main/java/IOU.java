import java.util.HashMap;

public class IOU {

    private HashMap<String,Double> persons = new HashMap<>();

    public void setSum(String toWhom, double amount) {
        Double person = persons.getOrDefault(toWhom, 0.0);
        persons.put(toWhom, person + amount);
    }

    public double howMuchDoIOweTo(String toWhom) {
        return persons.getOrDefault(toWhom, 0.0);
    }
}
