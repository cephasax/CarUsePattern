package master.imd.ufrn.br.carusepattern;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import master.imd.ufrn.br.carusepattern.getbehavior.domain.ReadingFromCar;
import master.imd.ufrn.br.carusepattern.getbehavior.web.GetBehaviorWebService;

public class Home extends AppCompatActivity {

    private EditText vehicleIdTxt;
    private TextView classTxtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        vehicleIdTxt = (EditText)findViewById(R.id.editTxtVehicleId);
        classTxtView = (TextView)findViewById(R.id.textClass);
    }

    public void findVehicleData(View view){



        String vId = vehicleIdTxt.getText().toString();

        GetBehaviorWebService getBehaviorWebService = new GetBehaviorWebService(this);
        getBehaviorWebService.getReadingsFromOneCar(vId);
        //sincronyze problem
        //Log.d("AQUIIIIII", String.valueOf(getBehaviorWebService.getReadingsFromCar().size()));
        /*int sizeReadings = getBehaviorWebService.getReadingsFromCar().size();
        String lastClass = getBehaviorWebService.getReadingsFromCar().get(sizeReadings - 1).getElement().getPredictedValue();*/

        classTxtView.setText("jose");

    }
}
