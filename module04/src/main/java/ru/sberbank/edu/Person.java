package ru.sberbank.edu;

import java.util.Objects;


public class Person implements Comparable<Person>{
    String name;
    String city;
    Integer age;

    Person(String name, String city, Integer age){
       this.name = name;
       this.city = city;
       this.age = age;
    }


    public String getCity() {
        return city;
    }

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Person person = (Person) o;
        return Objects.equals(name.toUpperCase(), person.name.toUpperCase())
                && Objects.equals(city.toUpperCase(), person.city.toUpperCase())
                && Objects.equals(age, person.age);
    }

    @Override
    public int hashCode() {
        return 31 * name.toUpperCase().hashCode() * city.toUpperCase().hashCode() * age;
    }

    /**
     *  Сортировка сначала по полю `city`, а затем по полю `name`.
     */
    @Override
    public int compareTo(Person o) {
        if (!this.city.equalsIgnoreCase(o.city))
            return this.city.compareTo(o.city);
        if (!this.name.equalsIgnoreCase(o.name))
            return this.name.compareTo(o.name);
        return 0;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", age=" + age +
                '}';
    }
}
