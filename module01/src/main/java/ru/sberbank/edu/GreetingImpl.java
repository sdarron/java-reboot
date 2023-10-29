package ru.sberbank.edu;

/**
 * Класс содержит информацию про автора.
 * @author Зайцев Денис Николаевич
 * @version 1.0
 */
public class GreetingImpl implements Greeting {
    String BestHobby = "Sport";
    /**
     * Метод возвращает название моего шлюбимого хобби
     * @return строка, содержащее название моего любимого хобби
     */
    public String getBestHobby(){
        return BestHobby;
    }

}
