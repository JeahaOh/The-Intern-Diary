package com.management;

import android.util.Log;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class HomeRequest extends StringRequest {

//    final static private String URL = "http://192.168.1.250:8888/yummy/memb/signUp";
    final static private String URL = "http://172.30.1.42:8888/yummy/";

    public HomeRequest(Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        Log.v(URL.toString(), "REQUEST??");
    }
}
