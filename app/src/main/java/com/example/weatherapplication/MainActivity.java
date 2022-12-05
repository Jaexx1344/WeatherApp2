package com.example.weatherapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText etCity, etCountry;
    TextView tvResult;
    private final String url="http://api.openweathermap.org/data/2.5/weather";
    private final String appid="96cd966c0fda10b8db21b31cffb9adac";
    DecimalFormat dec = new DecimalFormat( "#.##");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etCity = findViewById(R.id.etCity);
        etCountry = findViewById(R.id.etCountry);
        tvResult = findViewById(R.id.tvResult);
    }

    public void WeatherInfo(View view) {
        String tempUrl="";
        String city = etCity.getText().toString().trim();
        String country = etCountry.getText().toString().trim();
        if(city.equals("")) {
            tvResult.setText("Pole miasto nie może być puste!");
        }else {
            if(!country.equals("")){
                tempUrl = url + "?q" + city + "," + country + "&appid=" + appid;
        }else {
                tempUrl = url +"?q" + city + "&appid=" + appid;
            }
            StringRequest stringRequest = new StringRequest(Request.Method.POST, tempUrl, new Response.Listener<String>() {
            @Override
                    public void onResponse(String response){
            }

            }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"", Toast.LENGTH_SHORT).show();
            }
        });
    }
}}