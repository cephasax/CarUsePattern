package master.imd.ufrn.br.carusepattern.getbehavior.web;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

import master.imd.ufrn.br.carusepattern.getbehavior.dao.ReadingFromCarDao;
import master.imd.ufrn.br.carusepattern.getbehavior.domain.ReadingFromCar;
import master.imd.ufrn.br.carusepattern.getbehavior.util.ReadingFromCarUtils;
import master.imd.ufrn.br.carusepattern.getbehavior.util.StringWorker;

import static android.content.ContentValues.TAG;

public class CarUserPatternWeb {

    private static String getBehaviorService = "http://177.20.148.51:8080/ImdP-Server/api/v1/getbehavior/rfc";
    private  static String carData = "/vehicle/last/?";
    private static  RequestQueue queue;

    private static ReadingFromCarDao readingFromCarDao;

    private static void common(Context context){
        // Instantiate the RequestQueue.
        queue = Volley.newRequestQueue(context);
    }

    public static void getLastReadingFromCar(final Context context, String vehicleId) throws JSONException {
        common(context);

        String vehicleIdParam = "vehicleId=";

        StringBuilder sb = new StringBuilder();
        sb.append(getBehaviorService);
        sb.append(carData);
        sb.append(vehicleIdParam);
        sb.append(vehicleId);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                sb.toString(),
                new JSONObject(),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("TAG", response.toString());

                            ReadingFromCarCallback rfcc = new ReadingFromCarCallback();
                            rfcc.volleyCallback(response.toString());

                            try {
                                readingFromCarDao = new ReadingFromCarDao(context);
                                if(!readingFromCarDao.isAlreadyInDataBase(rfcc.getFinalRfc().getIdReadingFromCar())){
                                    readingFromCarDao.insertOrUpdate(rfcc.getFinalRfc());
                                }
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("TAG", error.getMessage(), error);
                    }
        });
        queue.add(jsonObjectRequest);
    }

}
