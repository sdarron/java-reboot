package ru.sberbank.edu;

import java.time.LocalDateTime;

public class WeatherInfo {

    private String city;

    /**
     * Short weather description
     * Like 'sunny', 'clouds', 'raining', etc
     */
    private String shortDescription;

    /**
     * Weather description.
     * Like 'broken clouds', 'heavy raining', etc
     */
    private String description;

    /**
     * Temperature.
     */
    private double temperature;

    /**
     * Temperature that fells like.
     */
    private double feelsLikeTemperature;

    /**
     * Wind speed.
     */
    private double windSpeed;

    /**
     * Pressure.
     */
    private double pressure;

    /**
     * Expiry time of weather info.
     * If current time is above expiry time then current weather info is not actual!
     */
    private LocalDateTime expiryTime;

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getFeelsLikeTemperature() {
        return feelsLikeTemperature;
    }

    public void setFeelsLikeTemperature(double feelsLikeTemperature) {
        this.feelsLikeTemperature = feelsLikeTemperature;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public LocalDateTime getExpiryTime() {

        return expiryTime;
    }

    public void setExpiryTime(LocalDateTime expiryTime) {

        this.expiryTime = expiryTime;
    }

    @Override
    public String toString() {
        return "WeatherInfo{" +
                "city='" + city + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", description='" + description + '\'' +
                ", temperature=" + temperature +
                ", feelsLikeTemperature=" + feelsLikeTemperature +
                ", windSpeed=" + windSpeed +
                ", pressure=" + pressure +
                ", expiryTime=" + expiryTime +
                '}';
    }
}
