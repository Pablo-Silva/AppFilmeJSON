package com.example.shootingstars.appfilmejson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MainActivity extends AppCompatActivity {


    private TextView textJson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textJson = findViewById(R.id.textView);
    }

    public void downloadJSON(View view){
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = Constantes.URL_SERVER;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        textJson.setText(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        textJson.setText("Falha ao pegar o JSON");
                    }
                });

        queue.add(stringRequest);
    }

    public void downloadGSON(View view) {
        GsonBuilder builder = new GsonBuilder();
        final Gson gson = builder.create();

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = Constantes.URL_SERVER;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Filme filme = gson.fromJson(response,Filme.class);
                        textJson.setText(filme.toString());
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        textJson.setText("Falha ao pegar JSON");
                    }
                });

        queue.add(stringRequest);
    }
}
