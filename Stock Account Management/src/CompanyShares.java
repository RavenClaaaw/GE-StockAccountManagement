class CompanyShares {
    public String stockSymbol;
    public int numShares;
    public double sharePrice;
    public String dateTime;

    public CompanyShares(String stockSymbol, int numShares, double sharePrice, String dateTime) {
        this.stockSymbol = stockSymbol;
        this.numShares = numShares;
        this.sharePrice = sharePrice;
        this.dateTime = dateTime;
    }
}