public class Cash extends Asset {
    private double balance;

    public Cash(String name, String symbol, double balance) {
        super(name, symbol);
        this.balance = balance;
    }

    @Override
    public double calculateValue() { return balance; }
}