package master.imd.ufrn.br.carusepattern.getbehavior.web;

import android.content.Context;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.util.ArrayList;

import master.imd.ufrn.br.carusepattern.getbehavior.domain.ReadingFromCar;
import master.imd.ufrn.br.carusepattern.getbehavior.util.ReadingFromCarUtils;
import master.imd.ufrn.br.carusepattern.getbehavior.util.StringWorker;


public class GetBehaviorWebService {

    private String getBehaviorService;
    private RequestQueue queue;
    private ArrayList<ReadingFromCar> readingsFromCar;
    private String carData;
    private Context context;

    public GetBehaviorWebService(Context context) {
        this.context = context;
        common(context);
        this.getBehaviorService = "http://177.20.148.51:8080/ImdP-Server/api/v1/getbehavior/rfc";
        this.carData = "/vehicle/";
        this.readingsFromCar = new ArrayList<ReadingFromCar>();
    }

    private void common(Context context){
        // Instantiate the RequestQueue.
        this.queue = Volley.newRequestQueue(context);
    }

    public void getReadingsFromOneCar(String vId){
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(getBehaviorService+carData+vId, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Gson gson = new Gson();
                for(int i = 0; i < response.length(); i++) {
                    try {
                        ReadingFromCar r = new ReadingFromCar();
                        r = gson.fromJson(response.get(i).toString(), ReadingFromCar.class);
                        readingsFromCar.add(r);
                        Log.d(String.valueOf(i), readingsFromCar.get(i).toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Volley", error.toString());
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this.context);
        requestQueue.add(jsonArrayRequest);
    }

    public String getGetBehaviorService() {
        return getBehaviorService;
    }

    public void setGetBehaviorService(String getBehaviorService) {
        this.getBehaviorService = getBehaviorService;
    }

    public ArrayList<ReadingFromCar> getReadingsFromCar() {
        return readingsFromCar;
    }

    public void setReadingsFromCar(ArrayList<ReadingFromCar> readingsFromCar) {
        this.readingsFromCar = readingsFromCar;
    }
}
