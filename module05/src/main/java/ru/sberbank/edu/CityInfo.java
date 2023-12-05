package ru.sberbank.edu;

/**
 * City info
 */
public class CityInfo {

    private String name;
    private GeoPosition position;

    /**
     * Ctor.
     *
     * @param name     - city name
     * @param position - position
     */
    public CityInfo(String name, GeoPosition position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GeoPosition getPosition() {
        return position;
    }

    public void setPosition(GeoPosition position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "CityInfo{" +
                "name='" + name + '\'' +
                ", position=" + position +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CityInfo cityInfo)) return false;

        if (getName() != null ? !getName().equals(cityInfo.getName().toUpperCase()) : cityInfo.getName().toUpperCase() != null) return false;
        return getPosition() != null ? getPosition().equals(cityInfo.getPosition()) : cityInfo.getPosition() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getPosition() != null ? getPosition().hashCode() : 0);
        return result;
    }
}