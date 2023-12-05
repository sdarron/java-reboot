package ru.sberbank.edu;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Travel Service.
 */
public class TravelService {

    // do not change type
    private final List<CityInfo> cities = new ArrayList<>();
    public final static double AVERAGE_RADIUS_OF_EARTH_KM = 6371;

    /**
     * Append city info.
     *
     * @param cityInfo - city info
     * @throws IllegalArgumentException if city already exists
     */
    public void add(CityInfo cityInfo) {
       boolean rez =  cities.add(cityInfo);
        if (rez = false) {
            throw new IllegalArgumentException("City already exists");
        }
    }

    /**
     * remove city info.
     *
     * @param cityName - city name
     * @throws IllegalArgumentException if city doesn't exist
     */
    public void remove(String cityName) {
        cities.remove(cityName);
        boolean rez;
        if (rez = false) {
            throw new IllegalArgumentException("City doesn't exist");
        }
    }

    /**
     * Get cities names.
     */
    public List<String> citiesNames() {

        return cities.stream()
                .map(CityInfo::getName)
                .collect(Collectors.toList());

    }

    /**
     * Get distance in kilometers between two cities.
     * https://www.kobzarev.com/programming/calculation-of-distances-between-cities-on-their-coordinates/
     *
     * @param srcCityName  - source city
     * @param destCityName - destination city
     * @throws IllegalArgumentException if source or destination city doesn't exist.
     */
    public int getDistance(String srcCityName, String destCityName) {
        List <CityInfo> srcCities = cities.stream()
                .filter(city -> city.getName().equals(srcCityName))
                .toList();
        CityInfo srcCity = srcCities.get(0);

        List <CityInfo> destCities = cities.stream()
                .filter(city -> city.getName().equals(destCityName))
                .toList();
        CityInfo destCity = destCities.get(0);

        double latDistance = srcCity.getPosition().getLatitude() - destCity.getPosition().getLatitude();
        double lngDistance = srcCity.getPosition().getLongitude() - destCity.getPosition().getLongitude();

        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(srcCity.getPosition().getLatitude()) * Math.cos(destCity.getPosition().getLatitude())
                * Math.sin(lngDistance / 2) * Math.sin(lngDistance / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return (int) (Math.round(AVERAGE_RADIUS_OF_EARTH_KM * c));
    }

    /**
     * Get all cities near current city in radius.
     *
     * @param cityName - city
     * @param radius   - radius in kilometers for search
     * @throws IllegalArgumentException if city with cityName city doesn't exist.
     */
    public List<String> getCitiesNear(String cityName, int radius) {
        List<String> collect = cities.stream()
                                    .filter( city -> getDistance(cityName, city.getName()) <= radius
                                             && city.getName() !=  cityName  )
                                    .map(CityInfo:: getName)
                                    .collect(Collectors.toList());
        return collect;
    }
}
