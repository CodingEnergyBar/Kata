public class ValidWordAbbr {
    /*
    * @param dictionary: a list of words
    */
    
    
    Map<String, Integer> dict =  new HashMap();
    HashSet<String> original = new HashSet();
    //  Map<String, Integer> dict =  new HashMap();
    // Map<String, Integer> original = new HashMap();
    
    public ValidWordAbbr(String[] dictionary) {
        // do intialization if necessary
        
        for(String s: dictionary){
            String abbr = getAbrr(s);
            if(!original.contains(s))
             dict.put(abbr, dict.getOrDefault(abbr, 0) + 1);
            
            original.add(s);
        }
    }
    
    String getAbrr(String s){
        
        if(s.length()<=2){
            return s;
        }
        // String.valueOf translate integer to string
        return ""+s.charAt(0) + (s.length()-2) + s.charAt(s.length()-1);
    }

    /*
     * @param word: a string
     * @return: true if its abbreviation is unique or false
     */
     
     // when there is word in dict, if there is no other word
    public boolean isUnique(String word) {
        // write your code here
        // System.out.println(dict.toString());
        if(original.contains(word) && dict.getOrDefault(getAbrr(word), 0) == 1 ){
            return true;
        }
        return !dict.containsKey(getAbrr(word));
    }
    
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param = obj.isUnique(word);
 */