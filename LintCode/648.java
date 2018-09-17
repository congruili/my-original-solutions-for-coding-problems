// 648. Unique Word Abbreviation

public class ValidWordAbbr {
    /*
    * @param dictionary: a list of words
    */
    HashMap<String, Integer> wordMap, abbrMap;
    
    public ValidWordAbbr(String[] dictionary) {
        // do intialization if necessary
        wordMap = new HashMap<>();
        abbrMap = new HashMap<>();
        
        for (String s: dictionary) {
            String abbr = getAbbr(s);
            wordMap.put(s, wordMap.getOrDefault(s, 0) + 1);
            abbrMap.put(abbr, abbrMap.getOrDefault(abbr, 0) + 1);
        }
    }

    /*
     * @param word: a string
     * @return: true if its abbreviation is unique or false
     */
    public boolean isUnique(String word) {
        // write your code here
        // (null == null) is true
        return wordMap.get(word) == abbrMap.get(getAbbr(word));
    }
    
    private String getAbbr(String s) {
        if (s.length() <= 2) {
            return s;
        }
        
        return "" + s.charAt(0) + (s.length() - 2) + s.charAt(s.length() - 1);
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param = obj.isUnique(word);
 */