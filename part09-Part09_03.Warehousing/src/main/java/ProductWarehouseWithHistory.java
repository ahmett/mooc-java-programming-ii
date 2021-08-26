public class ProductWarehouseWithHistory extends ProductWarehouse {

    private final ChangeHistory changeHistory = new ChangeHistory();

    public ProductWarehouseWithHistory(String productName, double capacity, double initialBalance) {
        super(productName, capacity);

        super.addToWarehouse(initialBalance);
        this.changeHistory.add(initialBalance);
    }

    public String history() {
        return changeHistory.toString();
    }

    public void addToWarehouse(double amount) {
        super.addToWarehouse(amount);

        changeHistory.add(super.getBalance());
    }

    public double takeFromWarehouse(double amount) {
        changeHistory.add(super.getBalance() - amount);

        return super.takeFromWarehouse(amount);
    }

    public void printAnalysis() {
        System.out.println(
                "Product: " + this.getName() + "\n" +
                "History: " + this.history() + "\n" +
                "Largest amount of product: " + changeHistory.maxValue() + "\n" +
                "Smallest amount of product: " + changeHistory.minValue() + "\n" +
                "Average: " + changeHistory.average()
        );
    }
}
