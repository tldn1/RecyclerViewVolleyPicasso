package com.tldn1.recyclerviewvolleypicasso;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by X on 12/25/2016.
 */

public class MySingleton {
    private static MySingleton mInstance;
    private static Context mCtx;
    private RequestQueue requestQueue;

    public MySingleton(Context context) {
        mCtx = context;
        requestQueue = getRequestQueue();
    }

    public RequestQueue getRequestQueue(){
        if(requestQueue==null){
            requestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());
        }
        return requestQueue;
    }
    public static synchronized MySingleton getMyInstance(Context context){
        if(mInstance==null){
            mInstance = new MySingleton(context);
        }
        return mInstance;
    }
    public<T> void addToRequestQueue(Request<T> request){
        requestQueue.add(request);
    }
}
