package ru.sberbank.edu;

import java.io.*;
import java.nio.file.Paths;

/**
 * Проект для второго домашнего задания Школы Java разработчиков
 * @author Зайцев Денис Николевич
 * @version 1.0
 *
 */
public class App 
{
    public static void main( String[] args ) {

        String str = "";
        String maxStr = "";
        int maxLengthStr = 0;
        int lengthStr = 0;
        int countStr = 0;
        int countSpace = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            while ((str = reader.readLine()) != null) {
                countStr++;
                lengthStr = str.length();
                if ( maxLengthStr < lengthStr) {
                    maxLengthStr = lengthStr;
                    maxStr = str;
                }
                countSpace += str.chars().filter(Character::isWhitespace).count();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileStatistic fileStatistic = new FileStatistic
                .FileStatisticBuilder()
                .withFileName(Paths.get(args[0]).getFileName().toString())
                .withSpaceCount(countSpace)
                .withLineCount(countStr)
                .withLine(maxStr)
                .withOutputFileName("FileStatistic.txt")
                .build();
        fileStatistic.save();
    }
}
