package app.salesianos.wordQualifier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordQualifier {
    private Map<Character, List<String>> wordByInitial;

    public WordQualifier() {
        wordByInitial = new HashMap<>();
    }

    public Map<Character, List<String>> getWordByInitial() {
        return wordByInitial;
    }

    public void setWordByInitial(Map<Character, List<String>> wordByInitial) {
        this.wordByInitial = wordByInitial;
    }

    public void addWord(String word) {
        String sanitizedWord = sanitizeWord(word);
        char initial = sanitizedWord.charAt(0);
        if (!wordByInitial.containsKey(initial)) {
            wordByInitial.put(initial, new ArrayList<>());
        }
        wordByInitial.get(initial).add(sanitizedWord);
    }

    private String sanitizeWord(String word) {
        return word.toLowerCase().trim();
    }

    public Set<Character> getInitials() {
        return wordByInitial.keySet();
    }

    public List<String> getWordsByInitial(char initial) {
        return wordByInitial.getOrDefault(initial, new ArrayList<String>());
    }

}
