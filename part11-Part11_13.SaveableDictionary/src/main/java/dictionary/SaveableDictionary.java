package dictionary;

import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

public class SaveableDictionary {

    private final HashMap<String, String> dictionary;
    private String fileName;

    public SaveableDictionary() {
        this.dictionary = new HashMap<>();
    }

    public SaveableDictionary(String file) {
        this();
        this.fileName = file;
    }

    public void add(String word, String translation) {
        if (!dictionary.containsKey(word)) {
            dictionary.put(word, translation);
            dictionary.put(translation, word);
        }
    }

    public void delete(String word) {
        dictionary.remove(dictionary.get(word));
        dictionary.remove(word);
    }

    public String translate(String word) {
        return dictionary.get(word);
    }

    public boolean load() {
        try {
            Files.lines(Paths.get(fileName))
                    .map(l -> l.split(":"))
                    .forEach(parts -> add(parts[0], parts[1]));
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    public boolean save() {
        PrintWriter writer;
        ArrayList<String> savedKeys = new ArrayList<>();

        try {
            writer = new PrintWriter(fileName);
        } catch (Exception e) {
            return false;
        }

        dictionary.keySet().forEach(word -> {
            if (savedKeys.contains(word)) return;

            String translation = translate(word);
            writer.println(word + ":" + translation);

            savedKeys.add(word);
            savedKeys.add(translation);
        });

        writer.close();

        return true;
    }
}
