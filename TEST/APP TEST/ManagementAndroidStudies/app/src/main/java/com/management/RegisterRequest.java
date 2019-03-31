package com.management;

import android.util.Log;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {

    final static private String URL = "http://192.168.1.250:8888/yummy/memb/signUp";
//    final static private String URL = "http://172.30.1.42:8888/yummy/memb/signUp";

    private Map<String, String> parameters;

    public RegisterRequest(String id, String pwd, String nick, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        Log.v(URL.toString(), "REQUEST??");

        parameters = new HashMap<>();

        parameters.put("id", id);
        parameters.put("pwd", pwd);
        parameters.put("nick", nick);
    }

    @Override
    public Map<String, String> getParams() {
        return parameters;
    }
}
