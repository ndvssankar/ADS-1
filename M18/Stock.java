
class Stock implements Comparable<Stock> {
    private String stockName;
    private double percentageOfChange;

    public Stock(String stockName, double percentageOfChange) {
        this.stockName = stockName;
        this.percentageOfChange = percentageOfChange;
    }

    public String getStockName() {
        return stockName;
    }
     
    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public double getPercentageOfChange() {
        return percentageOfChange;
    }

    public void setPercentageOfChange(double percentageOfChange) {
        this.percentageOfChange = percentageOfChange;
    }

    public String toString() {
        return this.stockName + " " + this.percentageOfChange;
    }

    public int compareTo(Stock that) {
        if (this.percentageOfChange < that.percentageOfChange) return -1;
        if (this.percentageOfChange > that.percentageOfChange) return +1;
        if (this.stockName.compareTo(that.stockName) < 0) return -1;
        if (this.stockName.compareTo(that.stockName) > 0) return +1;
        return 0;
    }
}