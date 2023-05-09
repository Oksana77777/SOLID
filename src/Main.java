import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        var purchase = new Purchase();
        purchase.printShowCase();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String line = scanner.nextLine();
            if ("end".equals(line)) break;
            String[] parts = line.split(" ");
            String product = parts[0];
            int count = Integer.parseInt(parts[1]);
            purchase.addPurchase(product, count);
        }

        purchase.printPurchases();
    }
}