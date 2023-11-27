package ru.sberbank.edu;

import java.util.List;


/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args ) {

        TravelService service = new TravelService();
        service.add(new CityInfo("Moscow", new GeoPosition("55(45'21'')", "37(36'56'')")));
        service.add(new CityInfo("Rostov", new GeoPosition("47(13'52'')", "39(43'23'')")));
        service.add(new CityInfo("Saint Petersburg", new GeoPosition("59(57'00'')", "30(19'00'')")));
        int road = service.getDistance("Moscow", "Rostov");
        int road2 = service.getDistance("Moscow", "Saint Petersburg");
        int radius = 800;
        String centerCity = "Moscow";
        List<String> city = service.getCitiesNear(centerCity, radius);
        List<String> city2 = service.citiesNames();
        System.out.println(city2.toString());
        System.out.println("Города рядом с " + centerCity + " в радиусе " + radius +" км: " +  city.toString());
        System.out.println("Moscow - Rostov " + road);
        System.out.println("Moscow - Saint Petersburg " + road2);

    }
}
