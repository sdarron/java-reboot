package ru.sberbank.edu;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * A class for saving data to the file
 * @author Зайцев Денис Николевич
 * @version 1.0
 */

public class SavingToFile implements SaveStatistic {

    String data;
    String outputFileName;
    public SavingToFile(String data, String outputFileName){
        this.data = data;
        this.outputFileName = outputFileName;
    }

    @Override
    public void goSave() {
        try (BufferedWriter writerFile = new BufferedWriter(new FileWriter(this.outputFileName))) {
            writerFile.write( this.data );
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
