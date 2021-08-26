import java.util.ArrayList;
import java.util.HashMap;

public class StorageFacility {

    HashMap<String, ArrayList<String>> units = new HashMap<>();

    // adds the parameter item to the storage unit that is also given as a parameter.
    public void add(String unit, String item) {
        ArrayList<String> storageUnit = contents(unit);

        storageUnit.add(item);
        units.put(unit, storageUnit);
    }

    // returns a list that contains all the items in the storage unit indicated by the parameter.
    // If there is no such storage unit or it contains no items, the method should return an empty list.
    public ArrayList<String> contents(String storageUnit) {
        return units.getOrDefault(storageUnit, new ArrayList<>());
    }

    // removes the given item from the given storage unit.
    // NB! Only removes one item — if there are several items with the same name, the rest still remain.
    // If the storage unit would be empty after the removal, the method also removes the unit.
    public void remove(String storageUnit, String item) {
        ArrayList<String> contents = contents(storageUnit);

        contents.remove(item);

        if (contents.size() == 0) {
            units.remove(storageUnit);
        } else {
            units.put(storageUnit, contents);
        }
    }

    // returns the names of the storage units as a list.
    // NB! Only the units that contain items are listed.
    public ArrayList<String> storageUnits() {
        return new ArrayList<>(units.keySet());
    }

}
