package ru.sberbank.edu;

import java.util.ArrayList;

/**
 * Проект для третьего домашнего задания Школы Java разработчиков
 * @author Зайцев Денис Николевич
 * @version 1.0
 */
public class App 
{
    public static void main( String[] args ) {
        CustomArrayImpl<String> list = new CustomArrayImpl<>();
        ArrayList<String> list2 = new ArrayList<>();
        CustomArrayImpl<String> list1 = new CustomArrayImpl<>();
        int num = list.size();
        boolean empty = list.isEmpty();
        boolean sec1 = list.add("test");
        boolean sec3 = list.add("test1");
        boolean sec4 = list.add("test2");
        boolean sec2 = list.addAll(list1);
        String str = list.get(0);
        String str1 = list.set(0,"test3");
        list.remove(1);
        list.remove("test");
        boolean sec5 = list.contains("test");
        list.ensureCapacity(5);
        int cap = list.getCapacity();
        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
        list.reverse();
        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
        System.out.println(cap);
    }
}
