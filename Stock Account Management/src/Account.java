import java.util.Scanner;

public class Account {
    public double totalAmount = 0;
    public int numStocks;
    public String[] stockNames;
    public int[] numShares;
    public double[] sharePrices;

    Account(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter No. Of Stocks:- ");
        numStocks = scanner.nextInt();

        stockNames = new String[numStocks];
        numShares = new int[numStocks];
        sharePrices = new double[numStocks];

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
        totalAmount = totalValue;
    }

    public boolean debit(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("ENTER AMOUNT TO DEBIT:- ");
        int value = scanner.nextInt();
        scanner.nextLine();

        if(totalAmount < value){ 
            System.out.println("ERROR:- Insufficient Balance"); 
            return false; 
        }
        else{ 
            totalAmount -= value; 
            return true;
        }
    }
}
