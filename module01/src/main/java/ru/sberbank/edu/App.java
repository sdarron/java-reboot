package ru.sberbank.edu;

/**
 * Проект для первого домашнего задания Школы Java разработчиков
 * @author Зайцев Денис Николевич
 * @version 1.0
 */
public class App 
{
    public static void main( String[] args ) {

        GreetingImpl impl = new GreetingImpl();
        String hobby = impl.getBestHobby();
        System.out.println( hobby );

        GCD gcd = new GCD();
        int num = gcd.getDivisor(12, 8);
        System.out.println(num);


    }
}
