package seedu.duke;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Storage {
    private static final String filepath = "records.txt";

    public void saveToFile(RecordList list) throws IOException {
        Path path = Paths.get(filepath);

        Path directory = path.getParent();
        if (directory != null && !Files.exists(directory)) {
            Files.createDirectories(directory);
        }

        if (Files.notExists(path)) {
            Files.createFile(path);
        }

        FileWriter fw = new FileWriter(path.toFile());

        for (Record record : list) {
            fw.write(record.toString() + "\n");
        }
        System.out.println("Records saved to file.");
        fw.close();
    }

    public RecordList loadFromFile(String filepath) throws FileNotFoundException {
        File file = new File(filepath);
        Path path = Paths.get(filepath);
        Path directory = path.getParent();
        RecordList list = new RecordList();

        if (directory != null && !Files.exists(directory)) {
            try {
                Files.createDirectories(directory);
            } catch (IOException e) {
                System.out.println("Error creating the directory.");
                return list;
            }
        }

        if (Files.notExists(path)) {
            try {
                Files.createFile(path);
                System.out.println("File created: " + filepath);
            } catch (IOException e) {
                System.out.println("Error creating the file.");
                return list;
            }
        }

        Scanner sc = new Scanner(file);
        while (sc.hasNext()) {
            String line = sc.nextLine().strip();
            if (!line.isEmpty()) {
                list.add(new Record(line));
            }
        }
        System.out.println("Loaded records from file.");

        return list;
    }

    public static String getFilepath() {
        return filepath;
    }
}
