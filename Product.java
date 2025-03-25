class Product implements Comparable<Product> {
    String SKU;
    double priceRetail;
    double priceCurrent;
    String productName;
    String category;

    public Product(String SKU, double priceRetail, double priceCurrent, String productName, String category) {
        this.SKU = SKU;
        this.priceRetail = priceRetail;
        this.priceCurrent = priceCurrent;
        this.productName = productName;
        this.category = category;
    }

    @Override
    public int compareTo(Product other) {
        return this.SKU.compareTo(other.SKU);
    }

    @Override
    public String toString() {
        return "SKU: " + SKU + ", Price Retail: $" + priceRetail + ", Price Current: $" + priceCurrent +
               ", Name: " + productName + ", Category: " + category;
    }
}
