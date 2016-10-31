package com.example.mansisaini.scribd_weatherapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private String city_name;
    private Button weather_button;
    private EditText city;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weather_button = (Button) findViewById(R.id.button_weather);
        weather_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, FirstPage.class);
                city = (EditText) findViewById(R.id.editText_city);
                city_name = city.getText().toString();


                Bundle bundle = new Bundle();

                bundle.putString("city", city_name);

                intent.putExtras(bundle);

                startActivity(intent);
            }
        });
    }
}
