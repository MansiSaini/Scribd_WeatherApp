package com.example.mansisaini.scribd_weatherapp.service;

import com.example.mansisaini.scribd_weatherapp.data.Channel;

/**
 * Created by mansisaini on 10/31/16.
 */
public interface WeatherServiceCallback
{
    void serviceSuccess (Channel channel);

    //an exception which tells why service failed
    void serviceFailure (Exception exception);

}
