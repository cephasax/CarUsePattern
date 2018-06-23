package master.imd.ufrn.br.carusepattern.getbehavior.util;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class StringWorker {

    public static HashMap<String,String> hashMapFromString(String hash) {

        Gson gson = new Gson();

        HashMap<String, String> hashh = gson.fromJson(hash, HashMap.class);

        return hashh;
    }

}
