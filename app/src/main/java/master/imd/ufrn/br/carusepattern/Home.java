package master.imd.ufrn.br.carusepattern;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.ParseException;

import master.imd.ufrn.br.carusepattern.getbehavior.dao.ReadingFromCarDao;
import master.imd.ufrn.br.carusepattern.getbehavior.domain.ReadingFromCar;
import master.imd.ufrn.br.carusepattern.getbehavior.util.DateParser;
import master.imd.ufrn.br.carusepattern.getbehavior.web.CarUserPatternWeb;

public class Home extends AppCompatActivity {

    private EditText vehicleIdTxt;
    private TextView classTxtView;
    private TextView dataTextView;
    private TextView txtClassDesc;
    private ImageView imgClass;

    private boolean wifiConnected = false;
    private boolean mobileConnected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        vehicleIdTxt = (EditText)findViewById(R.id.editTxtVehicleId);
        classTxtView = (TextView)findViewById(R.id.textClass);
        dataTextView = (TextView)findViewById(R.id.textData);
        txtClassDesc = (TextView)findViewById(R.id.txtClassDesc);
        imgClass = (ImageView)findViewById(R.id.imgClass);

        classTxtView.setText("");
        dataTextView.setText("");
        txtClassDesc.setText("");
        imgClass.setImageResource(R.drawable.car);
    }

    public void findVehicleData(View view){

        String vId = vehicleIdTxt.getText().toString();

        //verify connection
        verifyConnection();

        //if connected to internet, try send any reading
        if(wifiConnected || mobileConnected){
            try {
                CarUserPatternWeb.getLastReadingFromCar(getApplicationContext(), vId);
            } catch (Exception e) {
                e.printStackTrace();
                Log.e("ERRO: ", vId);
            }
        }

        ReadingFromCarDao readingFromCarDao = new ReadingFromCarDao(this);
        ReadingFromCar rfc = null;
        try {
             rfc = readingFromCarDao.getLastRecord(vId);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if(rfc != null) {
            putDataOnView(rfc);
        }
        else{
            txtClassDesc.setText("no data on Database yet :/ , sorry");
        }
    }

    private void verifyConnection(){
        final ConnectivityManager connMgr = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connMgr != null) {
            NetworkInfo wifiInfo = connMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            NetworkInfo mobileInfo = connMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

            wifiConnected = wifiInfo != null && wifiInfo.isConnected();
            mobileConnected = mobileInfo != null && mobileInfo.isConnected();
        }
    }

    private void putDataOnView(ReadingFromCar rdf){
        dataTextView.setText(DateParser.dateToString(rdf.getElement().getDate()));

        switch (rdf.getElement().getPredictedValue()){
            case "cluster1":{
                imgClass.setImageResource(R.drawable.f1);
                classTxtView.setText("high use");
                txtClassDesc.setText("high use of automobile resources");
                break;
            }
            case "cluster2":{
                imgClass.setImageResource(R.drawable.f2);
                classTxtView.setText("mid use");
                txtClassDesc.setText("mid use of automobile resources");
                break;
            }
            case "cluster3":{
                imgClass.setImageResource(R.drawable.f3);
                classTxtView.setText("low use");
                txtClassDesc.setText("low use of automobile resources");
                break;
            }
        }
    }

}
