package master.imd.ufrn.br.carusepattern.getbehavior.web;

import java.text.ParseException;

import master.imd.ufrn.br.carusepattern.getbehavior.domain.ReadingFromCar;
import master.imd.ufrn.br.carusepattern.getbehavior.util.ReadingFromCarUtils;
import master.imd.ufrn.br.carusepattern.getbehavior.util.StringWorker;

public class ReadingFromCarCallback implements Callback{

    private ReadingFromCar finalRfc;

    public ReadingFromCarCallback(){

    }

    @Override
    public void volleyCallback(String data) {
        try {

            finalRfc = ReadingFromCarUtils.makeReadingFromResponseString(data);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public synchronized ReadingFromCar getFinalRfc() {
        return finalRfc;
    }

    public void setFinalRfc(ReadingFromCar finalRfc) {
        this.finalRfc = finalRfc;
    }
}
