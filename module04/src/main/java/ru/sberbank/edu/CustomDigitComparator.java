package ru.sberbank.edu;

import java.util.Comparator;
/**
 *  Класс определяет следующий порядок сравнения:
 *  Сначала сравниваем по возрастанию четные числа, затем нечетные
 */
public class CustomDigitComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        if (o1 % 2 == 0 && o2 % 2 != 0) {
            return -1;
        } else if (o1 % 2 != 0 && o2 % 2 == 0) {
            return 1;
        } else {
            return o1.compareTo(o2);
        }
    }
}
