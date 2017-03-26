/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salab3;

import java.util.Observer;
import java.util.Observable;

/**
 *
 * @author Raam
 */
public class StatisticsDisplay implements Observer, DisplayElement {
    private float maxTemp = 0.0f;
    private float minTemp = 200;
    private float tempSum= 0.0f;
    private float temp;
    private int numReadings;
    
    public StatisticsDisplay(Observable observable) {
        observable.addObserver(this);
    }
    
    @Override
    public void update(Observable observable, Object arg) {
        
        if(observable instanceof WeatherData) {
        WeatherData weatherData = (WeatherData) observable;
        temp = weatherData.getTemperature();
        tempSum += temp;
        numReadings++;
        if (temp > maxTemp) {
            maxTemp = temp;
        }
        if (temp < minTemp) {
            minTemp = temp;
        }
        display();
        }
    }
    
    @Override
    public void display() {
        System.out.println("Avg/Max/Min temperature = " + (tempSum / numReadings) + "/" + maxTemp + "/" + minTemp);
    }
}
