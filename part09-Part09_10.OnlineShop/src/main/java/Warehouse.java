import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Warehouse {

    private final Map<String, Integer> products;
    private final Map<String, Integer> stocks;

    public Warehouse() {
        this.products = new HashMap<>();
        this.stocks = new HashMap<>();
    }

    public void addProduct(String product, int price, int stock) {
        products.put(product, price);
        stocks.put(product, stock);
    }

    public int price(String product) {
        return products.getOrDefault(product, -99);
    }

    public int stock(String product) {
        return stocks.getOrDefault(product, 0);
    }

    public boolean take(String product) {
        int stock = stocks.getOrDefault(product, 0);

        if (stock <= 0) {
            return false;
        }

        stocks.put(product, --stock);

        return true;
    }

    public Set<String> products() {
        return products.keySet();
    }
}
