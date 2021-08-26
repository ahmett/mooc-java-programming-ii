public class Container {

    private int totalLiquid = 0;

    public void setTotalLiquid(int totalLiquid) {
        this.totalLiquid = totalLiquid;
    }

    public int contains() {
        return totalLiquid;
    }

    public void add(int amount) {
        if (amount >= 100 || amount + totalLiquid >= 100) {
            totalLiquid = 100;
        } else {
            if (amount > 0) {
                totalLiquid += amount;
            }
        }
    }

    public void move(Container firstContainer, int amount) {
        if (amount > firstContainer.contains()) {
            amount = firstContainer.contains();
            firstContainer.setTotalLiquid(0);
        } else {
            firstContainer.setTotalLiquid(firstContainer.contains() - amount);
        }

        if (amount + totalLiquid >= 100) {
            totalLiquid = 100;
        } else {
            totalLiquid += amount;
        }
    }

    public void remove(int amount) {
        if (amount >= 100 || amount > totalLiquid) {
            totalLiquid = 0;
        } else {
            totalLiquid -= amount;
        }
    }

    @Override
    public String toString() {
        return totalLiquid + "/100";
    }
}
