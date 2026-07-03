public class Crypto extends Asset implements Taxable {
    private double quantity;
    private double pricePerCoin;
    private double taxRate;

    public Crypto(String name, String symbol, double quantity, double pricePerCoin, double taxRate) {
        super(name, symbol);
        this.quantity = quantity;
        this.pricePerCoin = pricePerCoin;
        this.taxRate = taxRate;
    }

    @Override
    public double calculateValue() { return quantity * pricePerCoin; }

    @Override
    public double calculateTax() { return calculateValue() * taxRate; }
}