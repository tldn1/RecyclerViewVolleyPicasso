package com.tldn1.recyclerviewvolleypicasso.Background;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.tldn1.recyclerviewvolleypicasso.Model.SomethingModel;
import com.tldn1.recyclerviewvolleypicasso.MySingleton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by X on 12/25/2016.
 */

public class BackgroundTask {
    String url = "http://10.0.3.2/Display/DisplaySomething.php";
    Context context;
    ArrayList<SomethingModel> arrayList = new ArrayList<>();

    public BackgroundTask(Context context) {
        this.context = context;
    }

    public ArrayList<SomethingModel> getList(){

    JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.POST, url, (String) null, new Response.Listener<JSONArray>() {
        @Override
        public void onResponse(JSONArray response) {
            int count = 0;
            while (count < response.length()){
                try {
                    JSONObject JO  = response.getJSONObject(count);
                    SomethingModel somethingModel = new SomethingModel(JO.getString("image"),JO.getString("title"));
                    count++;
                    arrayList.add(somethingModel);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
        }
    });
        MySingleton.getMyInstance(context).addToRequestQueue(jsonArrayRequest);
        return arrayList;
    }
}
