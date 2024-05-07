package app.salesianos.wordQualifier;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordQualifier {
    private Map<Character, List<String>> wordByInitial;

    public WordQualifier(){
        wordByInitial   = new HashMap<>();
    }

    public Map<Character, List<String>> getWordByInitial(){
        return wordByInitial;
    }

    public void setWordByInitial(Map<Character, List<String>> wordByInitial){
        this.wordByInitial = wordByInitial;
    }

    
}
