package masterclass.udemy;

import java.util.Map;

public class Main {
    private static StockList stockList = new StockList();

    public static void main(String[] args) {

        StockItem temp = new StockItem("bread",  100, 0.86);
        stockList.addStock(temp);

        temp = new StockItem("cake", 7,1.10);
        stockList.addStock(temp);

        temp = new StockItem("car", 2,12.50);
        stockList.addStock(temp);

        temp = new StockItem("chair",  10, 62.0);
        stockList.addStock(temp);

        temp = new StockItem("cup", 200, 0.50);
        stockList.addStock(temp);
        temp = new StockItem("cup", 7,0.45) ;
        stockList.addStock(temp);

        temp = new StockItem("door", 4, 72.95 );
        stockList.addStock(temp);

        temp = new StockItem("juice", 36, 2.50);
        stockList.addStock(temp);

        temp = new StockItem("phone", 35, 96.99);
        stockList.addStock(temp);

        temp = new StockItem("towel", 80, 2.40);
        stockList.addStock(temp);

        temp = new StockItem("vase", 40, 8.76);
        stockList.addStock(temp);

        System.out.println(stockList);

        Cart timsBasket = new Cart("Tim");

        System.out.println(sellItem(timsBasket, "car", 1));
        System.out.println(timsBasket);

        sellItem(timsBasket, "car", 1);
        System.out.println(timsBasket);

        sellItem(timsBasket, "juice", 4);
        sellItem(timsBasket, "cup", 12);
        sellItem(timsBasket, "bread", 1);
        System.out.println(timsBasket);

//        System.out.println(stockList);

        Cart basket = new Cart("customer");
        sellItem(basket, "cup", 100);
        sellItem(basket, "juice", 5);
        removeItem(basket, "cup", 1);
        System.out.println(basket);

        removeItem(timsBasket, "car", 1);
        removeItem(timsBasket, "cup", 9);
        removeItem(timsBasket, "car", 1);
        System.out.println("cars removed: " + removeItem(timsBasket, "car", 1));  // should not remove any

        System.out.println(timsBasket);

        // remove all items from timsBasket
        removeItem(timsBasket, "bread", 1);
        removeItem(timsBasket, "cup", 3);
        removeItem(timsBasket, "juice", 4);
        removeItem(timsBasket, "cup", 3);
        System.out.println(timsBasket);

        System.out.println("\nDisplay stock list before and after checkout");
        System.out.println(basket);
        System.out.println(stockList);
        checkOut(basket);
        System.out.println(basket);
        System.out.println(stockList);

        StockItem car = stockList.getList().get("car");
        if(car != null) {
            car.adjustStock(2000);
        }
        if(car != null) {
            stockList.get("car").adjustStock(-1000);
        }

        System.out.println(stockList);


        checkOut(timsBasket);
        System.out.println(timsBasket);

    }


    public static void checkOut(Cart cart) {
        // loop through the list of items in cart
        for (Map.Entry<StockItem, Integer> entrySet : cart.getList().entrySet()){
            stockList.sellStock(entrySet.getKey().getName(), entrySet.getValue());
        }
        cart.clearCart();
    }

    public static int sellItem(Cart chart, String name, int quantity){
            StockItem item = stockList.get(name);
            if (item == null) {
                System.out.println("We don't sell " + name);
                return 0;
            }
            //first reserve the item
            if (stockList.reserveStock(name, quantity) != 0){
                return chart.addToCart(item, quantity); // then add to the cart
            }
            return 0;
    }


    public static int removeItem(Cart cart, String name, int quantity){
            StockItem item = stockList.get(name);
            // check if the item is in the shopping cart
            if (item == null) {
                System.out.println(name + " is not in shopping cart");
                return 0;
            }
                if (cart.removeFromCart(item, quantity) != 0){
                    stockList.unreserveStock(name, quantity);
                    return quantity;

            }
        return 0;
    }

}
