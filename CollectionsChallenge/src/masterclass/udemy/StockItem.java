package masterclass.udemy;

public class StockItem implements Comparable<StockItem> {
    private final String name;
    private double price;
    private int quantity;

    public StockItem(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantity = 0;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        }
    }

    public int updateQuantity(int quantity){
        int newQuantity = quantity + this.quantity;
        if (newQuantity > 0){
            this.quantity = newQuantity;
        }
        return this.quantity;
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
            String objName = ((StockItem) obj).getName();
            return this.name.compareTo(objName);
        }
        throw new NullPointerException();
    }

    public double getTotalPrice(){
        return this.price * this.quantity;
    }


    @Override
    public String toString() {
        return this.name + " : " + this.quantity + " pieces " + " -> ";
    }
}
