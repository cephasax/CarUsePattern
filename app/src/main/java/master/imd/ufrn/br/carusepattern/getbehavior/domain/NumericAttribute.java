package master.imd.ufrn.br.carusepattern.getbehavior.domain;

import master.imd.ufrn.br.carusepattern.getbehavior.util.DoubleUtils;

public class NumericAttribute {

    private double max;
    private double min;

    public NumericAttribute(double max, double min){
        this.max = (double)max;
        this.min = (double)min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    //put value between scale: 0 : 1
    public double normalizeMyValue(double value){
        double d = (value - min) / (max - min);
        if (d < 0){
            d = 0;
        }
        else if(d > 1){
            d = 1;
        }
        return DoubleUtils.round(d, 4);
    }
}
