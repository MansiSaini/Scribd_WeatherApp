package com.example.mansisaini.scribd_weatherapp.data;

import org.json.JSONObject;

/**
 * Created by mansisaini on 10/31/16.
 */
public class Items implements JsonPopulator
{
    private Condition condition;

    public Condition getCondition()
    {
        return condition;
    }

    @Override
    public void populate(JSONObject data)
    {
        condition = new Condition();
        condition.populate(data.optJSONObject("condition"));

    }
}
