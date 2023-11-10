package ru.sberbank.edu;

/**
 * Класс используется для передачи с статистики файла
 * использует builder pattern
 * @author Зайцев Денис Николевич
 * @version 1.0
 */
public class FileStatistic implements Statistic {
 private int lineCount;
 private int spaceCount;
 private String line;
 private String fileName;
 private String outputFileName;
 private String outputDB;

 private FileStatistic() {
 }

 public static class FileStatisticBuilder {
  private int lineCount;
  private int spaceCount;
  private String line;
  private String fileName;
  private String outputFileName;
  private String outputDB;

  public FileStatisticBuilder withLineCount(int lineCount) {
   this.lineCount = lineCount;
   return this;
  }

  public FileStatisticBuilder withSpaceCount(int spaceCount) {
   this.spaceCount = spaceCount;
   return this;
  }

  public FileStatisticBuilder withLine(String line) {
   this.line = line;
   return this;
  }

  public FileStatisticBuilder withFileName(String fileName) {
   this.fileName = fileName;
   return this;
  }

  public FileStatisticBuilder withOutputFileName(String outputFileName) {
   this.outputFileName = outputFileName;
   return this;
  }

  public FileStatisticBuilder withOutputDB(String outputDB) {
   this.outputDB = outputDB;
   return this;
  }

  public FileStatistic build() {
   FileStatistic fileStatistic = new FileStatistic();
   fileStatistic.fileName = this.fileName;
   fileStatistic.line = this.line;
   fileStatistic.spaceCount = this.spaceCount;
   fileStatistic.lineCount = this.lineCount;
   fileStatistic.outputFileName = this.outputFileName;
   fileStatistic.outputDB = this.outputDB;

   return fileStatistic;
  }
 }

 @Override
 public void save() {
  /**
   * Метод сохраняет данные в файл или базу данных ( сохранение в БД не реализованно)
   * в зависимости от значений атрибутов класса
   * указан outputFileName - сохраняем в файл
   * указан outputDB - сохраняем в базу данных
   */

  if (!this.outputFileName.isEmpty()) {
   String fileData = "File name: " + this.fileName +
                     "; max line: " + this.line +
                     "; count space: " + this.spaceCount +
                     "; count line: " + this.lineCount + "\n";
   SavingToFile saveToFile = new SavingToFile( fileData, this.outputFileName);
   saveToFile.goSave();
  } else if (!this.outputDB.isEmpty()) {
    SavingToDB saveToDB = new SavingToDB();
    saveToDB.goSave();
  }

 }
}
