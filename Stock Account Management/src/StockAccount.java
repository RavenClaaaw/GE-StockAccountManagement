import java.util.Scanner;
import java.util.Map;
import java.time.LocalDateTime;
import java.util.HashMap;

public class StockAccount {
    private Map<String, CompanyShares> companySharesMap;

    StockAccount(){
        companySharesMap = new HashMap<>();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StockAccount stockAccount = new StockAccount();

        while(true) {
            System.out.print("1. BUY \n2. SELL \n3. Report\nENTER: ");

            int option = scanner.nextInt();
            scanner.nextLine();
            if (option == 1) {
                System.out.print("Enter Stock Symbol: ");
                String stockSymbol = scanner.next();
                System.out.print("Enter No. Of Shares: ");
                int numShares = scanner.nextInt();
                System.out.print("Enter Share Price: ");
                double sharePrice = scanner.nextDouble();
                String dateTime = LocalDateTime.now().toString();
                stockAccount.buy(stockSymbol, numShares, sharePrice, dateTime);
            } else if (option == 2) {
                stockAccount.sell();
            } else {
                stockAccount.printReport();
            }
        }
    }

    public void buy(String stockSymbol, int numShares, double sharePrice, String dateTime) {
        CompanyShares companyShares = companySharesMap.get(stockSymbol);

        if (companyShares == null) {
            companyShares = new CompanyShares(stockSymbol, numShares, sharePrice, dateTime);
            companySharesMap.put(stockSymbol, companyShares);
        } else {
            companyShares.numShares += numShares;
            companyShares.dateTime = dateTime;
        }
    }

    public void sell() {
        Scanner scanner = new Scanner(System.in);
        
        display();
        System.out.print("ENTER STOCK SYMBOL:- ");
        String stockSymbol = scanner.nextLine();

        System.out.print("ENTER STOCK SHARES:- ");
        int sharesToSell = scanner.nextInt(); 

        CompanyShares companyShares = companySharesMap.get(stockSymbol);

        if (companyShares != null && companyShares.numShares >= sharesToSell) {
            companyShares.numShares -= sharesToSell;
            companyShares.dateTime = LocalDateTime.now().toString();

            if (companyShares.numShares == 0) {
                companySharesMap.remove(stockSymbol);
            }
        }
    }

    public void printReport() {
        System.out.println("Stock Report:");
        double totalValue = 0;

        for (CompanyShares companyShares : companySharesMap.values()) {
            double value = companyShares.numShares * companyShares.sharePrice;
            System.out.printf("%-10s %-10d %-10.2f %-10.2f\n", companyShares.stockSymbol, companyShares.numShares, companyShares.sharePrice, value);
            totalValue += value;
        }
        System.out.printf("\nTotal Value: Rs %.2f\n", totalValue);
    }

    public void display(){
        System.out.println("AVAILABLE STOCKS:- ");
        System.out.println(companySharesMap.keySet());
    }
}