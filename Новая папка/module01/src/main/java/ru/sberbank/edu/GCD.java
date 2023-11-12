package ru.sberbank.edu;


/**
 * Класс возврощает наибольший общий делитель 2х чисел. (Алгоримт Евклида)
 * @author Зайцев Денис Николаевич
 * @version 1.0
 */
public class GCD implements CommonDivisor {
    /**
     * Метод возвращения наибольшего общего делителя 2х чисел. (Алгоримт Евклида)
     * @param firstNumber - первое число
     * @param secondNumber - второе число
     * @return возвращает значение наибольшего общего делителя 2х чисел
     */
    public int getDivisor(int firstNumber, int secondNumber){
       int gcd = 1;
       for (int i = 1; i <= firstNumber && i <= secondNumber; i++) {
           if (firstNumber % i == 0 && secondNumber % i == 0) {
               gcd = i;
           }
       }
       return gcd;
   }
}
