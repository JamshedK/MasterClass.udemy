package masterclass.udemy;

import java.util.*;

public class StockList {
    private final Map<String, StockItem> list;

    public StockList() {
        list = new LinkedHashMap<>();
    }

    public int addStock(StockItem item){
        if (item != null) {
            // check item is already in the list
            StockItem inStock = list.getOrDefault(item.getName(), item);
            // if yes, then adjust the quantity
            if (inStock != item){   // you might be wondering but even if item exists in the stock,  but aren't inStock and item are gonna be the same? the answer is no. They refer to different objects
               item.adjustStock(inStock.getQuantityInStock());
            }
            list.put(item.getName(), item);
            return item.getQuantityInStock();
        }
        return 0;
    }

    public int sellStock(String name, int quantity){
        StockItem itemToBeSold = list.get(name);
        if (itemToBeSold != null && quantity > 0){
            return itemToBeSold.finaliseStock(quantity);
        }
        return 0;
    }

    public int reserveStock(String name, int quantity){
        StockItem item = list.get(name);
        if (item != null && quantity > 0){
            return item.reserve(quantity);
        }
        return 0;
    }

    public int unreserveStock(String name, int quantity){
        StockItem item = list.get(name);
        if (item != null && quantity > 0){
            return item.unreserve(quantity);
        }
        return 0;
    }

    public  Map<String, StockItem> getList() {
        return Collections.unmodifiableMap(list);
    }

    public StockItem get(String key){
        return list.get(key);
    }

    public Map<String, Double> priceList(){
        Map<String, Double> prices = new LinkedHashMap<>();
        for (Map.Entry<String, StockItem> entry : list.entrySet()){
            prices.put(entry.getKey(), entry.getValue().getPrice());
        }
        return Collections.unmodifiableMap(prices);
    }
    @Override
    public String toString() {
        String s = "\n \t Stock list \n";
        double totalPrice = 0;
        for (Map.Entry<String, StockItem> entrySet : list.entrySet()){
            StockItem item = entrySet.getValue();
            s = s + item + " In stock: " + item.getQuantityInStock() + ". Total value: " + String.format("%.2f",item.getPrice() * item.getQuantityInStock()) + "$\n";
            totalPrice += item.getPrice() * item.getQuantityInStock();
        }
        return s + "Total cost: " + String.format("%.2f",totalPrice) + "$";
    }
}
