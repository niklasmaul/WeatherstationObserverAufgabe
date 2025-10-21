package de.niklasmaul;

public class Weatherstation extends Subject{

    private int temperature, humidity;

    public Weatherstation(int temperature, int humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        sendNotification();
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
        sendNotification();
    }
}
