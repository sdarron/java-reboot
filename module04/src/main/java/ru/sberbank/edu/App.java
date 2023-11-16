package ru.sberbank.edu;

import java.util.Arrays;

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
    }
}
