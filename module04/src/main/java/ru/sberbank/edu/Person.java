package ru.sberbank.edu;

import java.util.Objects;

public class Person implements Comparable<Person>{
    String name;
    String city;
    Integer age;


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

    @Override
    public int compareTo(Person o) {
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