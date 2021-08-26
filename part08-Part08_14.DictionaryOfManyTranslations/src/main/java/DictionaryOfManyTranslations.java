import java.util.ArrayList;
import java.util.HashMap;

public class DictionaryOfManyTranslations {

    private HashMap<String, ArrayList<String>> translations = new HashMap<>();

    // adds the translation for the word and preserves the old translations.
    public void add(String word, String translation) {
        ArrayList<String> translationsOfWord = translations.getOrDefault(word, new ArrayList<>());

        translationsOfWord.add(translation);
        translations.put(word, translationsOfWord);
    }

    // returns a list of the translations added for the word.
    // If the word has no translations, the method should return an empty list.
    public ArrayList<String> translate(String word) {
        return translations.getOrDefault(word, new ArrayList<>());
    }

    // removes the word and all its translations from the dictionary.
    public void remove(String word) {
        translations.remove(word);
    }
}
