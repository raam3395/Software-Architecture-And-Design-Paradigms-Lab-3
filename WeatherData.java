/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salab3;

import java.util.Observable;

/**
 *
 * @author Raam
 */
public class WeatherData extends Observable{
    private float temperature;
    private float humidity;
    private float pressure;
    
    public WeatherData(){
    }
    
    public void measurementsChanged() {
        setChanged();
        notifyObservers();
    }
       
    public void setMeasurements(float temperature, float humidity, float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }

}
