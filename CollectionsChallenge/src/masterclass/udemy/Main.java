package masterclass.udemy;

import com.apple.laf.AquaLookAndFeel;

public class Main {
    private static StockList stockList = new StockList();
    public static void main(String[] args) {
        StockItem temp = new StockItem("Pen", 1000, 0.5);
        Chart myChart = new Chart();

        stockList.addStock(temp);
        temp = new StockItem("MacBook Air", 10, 999);
        myChart.addItem(temp, 1);

        stockList.addStock(temp);
        temp = new StockItem("MacBook Pro", 5, 2450);

        stockList.addStock(temp);
        temp = new StockItem("Original iPhone", 3, 1499);

        stockList.addStock(temp);
        System.out.println(stockList.sellStock("Pen", 100));

        temp = new StockItem("Pen", 300, 0.5);
        stockList.addStock(temp);
        myChart.addItem(temp, 150);

        System.out.println(stockList);
        System.out.println();
        System.out.println(myChart);
    }

    public static int sellStock(Chart chart, String item, int quantity){

    }
}
