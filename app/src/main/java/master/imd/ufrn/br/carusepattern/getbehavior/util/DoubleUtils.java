package master.imd.ufrn.br.carusepattern.getbehavior.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.ThreadLocalRandom;

public class DoubleUtils {

    public static double randomDouble() {
        double min = 0;
        double max = 1;

        double random = ThreadLocalRandom.current().nextDouble(min, max);

        return round(random, 4);
    }

    public static double round(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
