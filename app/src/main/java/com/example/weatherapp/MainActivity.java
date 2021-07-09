package com.example.weatherapp;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {

    EditText etCity, etCountry;
    TextView tvResult;
    private final String url= "http://api.openweathermap.org/data/2.5/weather";
    private final String appid= "8649b30824950b17b156b6426dd22ed3";
    DecimalFormat df= new DecimalFormat("#.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etCity=findViewById(R.id.etCity);
        etCountry=findViewById(R.id.etCountry);
        tvResult=findViewById(R.id.tvResult);

    }

    public void getWeatherDetails(View view) {

        String tempUrl="";
        String city= etCity.getText().toString().trim();
        String country= etCountry.getText().toString().trim();
        if(city.equals("")){
            Toast.makeText(this, "enter the city name", Toast.LENGTH_SHORT).show();
        }else{
            if(country.equals("")) {
                tempUrl = url + "?q=" + city + "," + country + "&appid" + appid;
            }else{
                tempUrl = url + "?q=" + city + "&appid" + appid;

            }

            StringRequest stringRequest= new StringRequest(Request.Method.POST, tempUrl, new Response.Listener<String>(){
                @Override
                public void onResponse(String response){
                    
                    
                }
            }, new Response.ErrorListener(){
                @Override
                public void onErrorResponse(VolleyError error){
                    Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                    
                }
            });

        }

    }
}