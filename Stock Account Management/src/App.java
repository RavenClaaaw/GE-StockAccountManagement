import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter No. Of Stocks:- ");
        int numStocks = scanner.nextInt();

        String[] stockNames = new String[numStocks];
        int[] numShares = new int[numStocks];
        double[] sharePrices = new double[numStocks];

        for (int i = 0; i < numStocks; i++) {
            System.out.println("\nStock " + (i + 1) + ":");
            System.out.print("STOCK NAME: ");
            stockNames[i] = scanner.next();
            System.out.print("NUMBER OF SHARES: ");
            numShares[i] = scanner.nextInt();
            System.out.print("PRICE OF SHARE: ");
            sharePrices[i] = scanner.nextDouble();
        }

        System.out.println("\nStock Report:");
        double totalValue = 0;
        for (int i = 0; i < numStocks; i++) {
            double value = numShares[i] * sharePrices[i];
            System.out.printf("%-10s %-10d %-10.2f %-10.2f\n", stockNames[i], numShares[i], sharePrices[i], value);
            totalValue += value;
        }
        System.out.printf("\nTotal value of all stocks: Rs. %.2f\n", totalValue);
    }
}
