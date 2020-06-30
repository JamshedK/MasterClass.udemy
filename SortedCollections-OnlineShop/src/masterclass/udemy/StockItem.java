package masterclass.udemy;

public class StockItem implements Comparable<StockItem> {
    private final String name;
    private double price;
    private int quantityInStock;
    private int quantityReserved;

    public StockItem(String name, int quantityInStock, double price) {
        this.name = name;
        this.quantityInStock = quantityInStock;
        this.price = price;
        this.quantityReserved = 0;
    }

    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantityInStock = 0;
        this.quantityReserved = 0;

    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantityInStock() {
        return quantityInStock - quantityReserved;
    }

    public int getQuantityReserved() {
        return quantityReserved;
    }

    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        }
    }

    public int adjustStock(int quantity){
        int newQuantity = quantity + this.quantityInStock;
        if (newQuantity > 0){
            this.quantityInStock  = newQuantity;
            return quantity;
        }
        return 0;
    }

    public int adjustReservedQua(int quantity){
        int newQuantity = quantity + this.quantityReserved;
        if ((newQuantity >= 0) && (this.quantityInStock >= newQuantity)){
            quantityReserved = newQuantity;
            return this.quantityReserved;
        }
        return 0;
    }

    public int finaliseStock(int quantity){
        if (quantity > 0 && quantity <= quantityReserved){
            quantityInStock -= quantity;
            quantityReserved -= quantity;
            return quantity;
        }
        return 0;
    }

    public int reserve(int quantity){
        if (quantity <= getQuantityInStock()){
            return quantityReserved += quantity;
        }
        return 0;
    }

    public int unreserve(int quantity){
        if (quantity <= quantityReserved){
           return quantityReserved -= quantity;
        }
        return 0;
    }


    @Override
    public int hashCode() {
        return this.name.hashCode() + 51;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return false;
        }
        if (obj == null || obj.getClass() != this.getClass()){
            return false;
        }
        String objName = ((StockItem)obj).getName();
        return this.name.equals(objName);
    }

    @Override
    public int compareTo(StockItem obj) {
        if (obj != null) {
            return this.name.compareTo(obj.getName());
        }
        throw new NullPointerException();
    }

    @Override
    public String toString() {
        return this.name + " : " + String.format("%.2f",this.price) + "$. " + "Reserved: " + this.quantityReserved + ". ";
    }
}
