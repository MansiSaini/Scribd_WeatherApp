package com.example.mansisaini.scribd_weatherapp.data;

import org.json.JSONObject;

/**
 * Created by mansisaini on 10/31/16.
 */
public class Channel implements JsonPopulator
{
    private Units units;
    private Items items;

    //getters and setters:
    public Units getUnits ()
    {
        return units;
    }

    public Items getItems()
    {
        return items;
    }

    @Override
    public void populate (JSONObject data)
    {
        //matches from query from Yahoo API
        units = new Units();
        units.populate(data.optJSONObject("units"));

        items = new Items();
        items.populate(data.optJSONObject("item"));
    }

}
