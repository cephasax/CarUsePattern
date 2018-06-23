package master.imd.ufrn.br.carusepattern.getbehavior.domain;


import master.imd.ufrn.br.carusepattern.getbehavior.util.DoubleUtils;

public class CountAndMean {

    private Double totalValue;
    private int count;
    private Double mean;

    public CountAndMean(){
        this.totalValue = 0.0;
        this.count = 0;
        this.mean = 0.0;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Double getMean() {
        return mean;
    }

    public void setMean(Double mean) {
        this.mean = mean;
    }

    public void increaseTotalValue(Double value){
        this.totalValue += value;
    }

    public void increaseCount(){
        this.count++;
    }

    public void calcMid(){
        if(this.count > 0) {
            this.mean = DoubleUtils.round(this.totalValue / this.count, 4);
        }
        else{
            this.mean = 0.0;
        }
    }
}
