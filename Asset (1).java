public abstract class Asset {
    private String name;
    private String symbol;

    public Asset(String name, String symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public abstract double calculateValue();
    public String getName() { return name; }
}