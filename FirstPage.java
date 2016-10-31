package com.example.mansisaini.scribd_weatherapp;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mansisaini.scribd_weatherapp.data.Channel;
import com.example.mansisaini.scribd_weatherapp.data.Items;
import com.example.mansisaini.scribd_weatherapp.service.WeatherServiceCallback;
import com.example.mansisaini.scribd_weatherapp.service.YahooWeatherService;

public class FirstPage extends AppCompatActivity implements WeatherServiceCallback {

    private TextView temperatureTextView;
    private TextView conditionTextView;
    private TextView locationTextView;

    private YahooWeatherService service;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);


        temperatureTextView = (TextView)findViewById(R.id.TemperatureTextView);
        conditionTextView = (TextView)findViewById(R.id.ConditionTextView);
        locationTextView = (TextView)findViewById(R.id.LocationTextView);

        service = new YahooWeatherService(this);
        dialog = new ProgressDialog(this);
        dialog.setMessage("Give us a minute...");
        dialog.show();

        Bundle bundle = getIntent().getExtras();

        String user_input = bundle.getString("city");
        service.refreshWeather(user_input);
    }

    @Override
    public void serviceSuccess(Channel channel)
    {
        dialog.hide();

        Items item = channel.getItems();

        //this displays the temperature onto screen:
        temperatureTextView.setText(item.getCondition().getTemperature() + "\u00B0" + channel.getUnits().getTemperature());
        conditionTextView.setText(item.getCondition().getDescription());
        locationTextView.setText(service.getLocation());
    }

    @Override
    public void serviceFailure(Exception exception)
    {
        dialog.hide();
        Toast.makeText(this, exception.getMessage(), Toast.LENGTH_LONG).show();
    }

}
