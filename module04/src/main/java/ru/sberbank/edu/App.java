package ru.sberbank.edu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Проект для домашнего задания #4 Школы Java разработчиков
 * @author Зайцев Денис Николевич
 * @version 1.0
 */
public class App 
{
    public static void main( String[] args ) {
        Integer[] numbers = {15,2,65,21, 8, 9, 4};
        Arrays.sort(numbers, new CustomDigitComparator());
        System.out.println(Arrays.toString(numbers));

        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person( "Masha", "Rostov", 15));
        persons.add(new Person( "Irina", "Moscow", 15));
        persons.add(new Person( "Anna", "Moscow", 15));
        persons.add(new Person( "Irina","Boston", 15));
        persons.add(new Person( "Anna", "Boston", 15));

        Collections.sort(persons);
        System.out.println(persons);
    }
}
