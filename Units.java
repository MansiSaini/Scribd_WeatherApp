package com.example.mansisaini.scribd_weatherapp.data;

import org.json.JSONObject;

/**
 * Created by mansisaini on 10/31/16.
 */
public class Units implements JsonPopulator
{
    //from the units part, we are only interested in temperature
    private String temperature;

    public String getTemperature()
    {
        return temperature;
    }

    @Override
    public void populate(JSONObject data)
    {
        temperature = data.optString("temperature");
    }
}
