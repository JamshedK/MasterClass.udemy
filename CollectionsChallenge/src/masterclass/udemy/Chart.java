package masterclass.udemy;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Chart {

    private final Map<StockItem, Integer> list;

    public Chart() {
        list = new HashMap<>();
    }

    public int addItem(StockItem item, int quantity){
        if (item != null && quantity > 0){
            // first check if the item is already in chart
            int inChart = list.getOrDefault(item, 0);
            // if yes, put it in the map. The value will get updated, if the item exists
            list.put(item, inChart + quantity);
            return inChart;
        }
        return 0;
    }

    public Map<StockItem, Integer> getList() {
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\t Items in shopping chart \n";
        double totalCost = 0.0;

        for (Map.Entry<StockItem, Integer> entrySet : list.entrySet()){
            StockItem item = entrySet.getKey();
            s = s + item + item.getTotalPrice() + "\n";
            totalCost += item.getTotalPrice();
        }
        return s + "Total cost: " + totalCost;
    }
}
