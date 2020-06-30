package masterclass.udemy;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Cart {
    private String name;
    private final Map<StockItem, Integer> list;

    public Cart(String name) {
        this.name = name;
        list = new HashMap<>();
    }

    public int addToCart(StockItem item, int quantity){
        if (item != null) {
            // first check if the item is already in cart
            int inCart = list.getOrDefault(item, 0);
            list.put(item, inCart + quantity);
            return quantity;
        }
        return 0;
    }

    public int removeFromCart(StockItem item, int quantity){
        if (item != null && quantity > 0){
            // first check if the item in the cart or not
           int inCart = list.getOrDefault(item, 0);
           if (inCart != 0){
               // firstly, if the quantity is the same as the value in the stock -> remove the item
               if (list.get(item) == quantity){
                   list.remove(item);
                   return quantity;
               }
               int newQuantity = inCart - quantity;
               list.put(item, newQuantity);
               return quantity;
           }
        }
        return 0;
    }

    public void clearCart(){
        this.list.clear();
    }


    public Map<StockItem, Integer> getList() {
//        return Collections.unmodifiableMap(list);
        return this.list;
    }

    public String getName() {
        return name;
    }

    public StockItem get(String name){
        for (StockItem key : list.keySet()){
            if (key.getName().equals(name)){
                return key;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        String s = "\t Items in " + name + "'s cart: \n";
        double totalCost = 0.0;

        for (Map.Entry<StockItem, Integer> item : list.entrySet()){
            s = s + item.getKey() + item.getValue() + " pieces -> " + item.getValue() * item.getKey().getPrice() + "$" + "\n";
            totalCost += item.getKey().getPrice()*item.getValue();
        }
        return s + "Total cost: " + String.format("%.2f",totalCost);
    }
}
