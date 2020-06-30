package masterclass.udemy;

import java.util.*;

public class StockList {
    private static Map<String, StockItem> list;

    public StockList() {
        list = new LinkedHashMap<>();
    }

    public Map<String, StockItem> getList() {
        return Collections.unmodifiableMap(list);
    }

    public int addStock(StockItem item){
        if (item != null) {
            // check item is already in the list
            StockItem inStock = list.getOrDefault(item.getName(), item);
            // if yes, then adjust the quantity
            if (inStock != item){   // you might be wondering but even if item exists in the stock,  but aren't inStock and item are gonna be the same? the answer is no. They refer to different objects
               item.updateQuantity(inStock.getQuantity());
            }
            list.put(item.getName(), item);
            return item.getQuantity();
        }
        return 0;
    }

    public static int sellStock(String name, int quantity){
        StockItem itemToBeSold = list.get(name);
        if (itemToBeSold != null &&  itemToBeSold.getQuantity() > quantity && quantity > 0){
            itemToBeSold.updateQuantity(-quantity);
            return quantity;
        }
        return 0;
    }

    @Override
    public String toString() {
        String s = "\n \t Stock list \n";
        double totalPrice = 0;
        for (Map.Entry<String, StockItem> entrySet : list.entrySet()){
            StockItem item = entrySet.getValue();
            s = s + item + String.format("%.2f",item.getTotalPrice()) + "$ \n";
            totalPrice += item.getTotalPrice();
        }
        return s + "Total cost: " + totalPrice + "$";
    }
}
