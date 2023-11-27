package ru.sberbank.edu;

/**
 * Geo position.
 */
public class GeoPosition {

    /**
     * Широта в радианах.
     */
    private double latitude;

    /**
     * Долгота в радианах.
     */
    private double longitude;

    /**
     * Ctor.
     *
     * @param latitudeGradus  - latitude in gradus
     * @param longitudeGradus - longitude in gradus
     *                        Possible values: 55, 55(45'07''), 59(57'00'')
     */
    public GeoPosition(String latitudeGradus, String longitudeGradus) {
        latitude = convertDegreesToRadians(latitudeGradus);
        longitude = convertDegreesToRadians(longitudeGradus);
    }

    private double convertDegreesToRadians(String gradus) {
        double minutes = 0.0;
        double seconds = 0.0;
        String[] latitudes1 = gradus.split("\\(");
        double degrees = Double.valueOf(latitudes1[0]);
        if (latitudes1.length > 1) {
            String[] latitudes2 = latitudes1[1].split("'");
            minutes = latitudes2.length > 0 ? Double.valueOf(latitudes2[0]) : 0.0;
            seconds = latitudes2.length > 1 ? Double.valueOf(latitudes2[1]) : 0.0;
        }

        double angle = degrees + minutes / 60.0 + seconds / 3600.0;
        return Math.toRadians(angle);
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public String toString() {
        return "GeoPosition{latitude=" + this.latitude + ", longitude=" + this.longitude + "}";}

}