import java.util.HashMap;
import java.util.Map;

public class Purchase {
    private final Map<String, Integer> products;
    private final Map<String, Integer> purchases = new HashMap<>();

    public Purchase() {
        DataBase dataBase = Data.getInstance();
        products = dataBase.getProducts();
    }

    public void addPurchase(String title, int count) {
        purchases.put(title, purchases.getOrDefault(title, 0) + count);
    }

    public void printPurchases() {
        long sum = 0;
        System.out.println("КОРЗИНА:");
        for (Map.Entry<String, Integer> entryMap : purchases.entrySet()) {
            System.out.println("\t" + entryMap.getKey() + " " + entryMap.getValue()
                    + " шт. в сумме " + (entryMap.getValue() * products.get(entryMap.getKey()) + " руб."));
            sum += (long) entryMap.getValue() * products.get(entryMap.getKey());
        }
        System.out.println("ИТОГО: " + sum);
    }

    public void printShowCase() {
        System.out.println("В МАГАЗИНЕ В НАЛИЧИИ");
        for (Map.Entry<String, Integer> productAndPrice : products.entrySet()) {
            System.out.println(productAndPrice.getKey() + " за " + productAndPrice.getValue() + " руб./шт.");
        }
        System.out.println("Введите два слова: название товара и количество. Или end");
    }
}