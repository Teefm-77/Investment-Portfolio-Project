public class Stock extends Asset implements Taxable {
    private double quantity;
    private double pricePerShare;
    private double taxRate;

    public Stock(String name, String symbol, double quantity, double pricePerShare, double taxRate) {
        super(name, symbol);
        this.quantity = quantity;
        this.pricePerShare = pricePerShare;
        this.taxRate = taxRate;
    }

    @Override
    public double calculateValue() { return quantity * pricePerShare; }

    @Override
    public double calculateTax() { return calculateValue() * taxRate; }
}
