public class Solution {
    /*
     * @param words: a set of words without duplicates
     * 
     * @return: all word squares
     */
    public List<List<String>> wordSquares(String[] words) {
        // write your code here
        List res = new ArrayList<ArrayList<String>>();
        if (words == null || words.length == 0)
            return res;

        dfs(0, words[0].length(), new ArrayList<String>(), words, buildPrefix(words), res);
        return res;

    }

    void dfs(int row, int len, List<String> path, String[] words, Map<String, List<String>> prefixToWords,
            List<List<String>> res) {

        if (row == len) {
            res.add(new ArrayList<String>(path));
            return;
        }

        // get words from path
        // getPrefix:
        String curPrefix = "";
        for (String pre : path) {
            curPrefix += pre.charAt(row);
        }

        // only test the words in the prefix list
        for (String word : prefixToWords.get(curPrefix)) {
            // if(canFillAtRow(word, row, words)){
            // can fill at row
            // check the words excluded

            // path get the word first
            // build the following prefix

            // if current word is word
            // row + 1 -> words[0].length
            boolean isPossible = true;
            for (int i = row + 1; i < len; i++) {
                // next word
                String prefix = "";
                for (String pre : path) {
                    // the row and the char len is coresponding
                    prefix += pre.charAt(i);
                }
                prefix += word.charAt(i);

                if (!prefixToWords.containsKey(prefix)) {
                    isPossible = false;
                    break;
                }
            }
            if (!isPossible)
                continue;

            path.add(word);
            dfs(row + 1, len, path, words, prefixToWords, res);
            path.remove(path.size() - 1);

        }

    }

    // build a prefixes map
    HashMap<String, List<String>> buildPrefix(String[] words) {
        // Mapping methods...
        HashMap<String, List<String>> res = new HashMap();

        for (int i = 0; i < words.length; i++) {
            res.computeIfAbsent("", k -> new ArrayList<String>()).add(words[i]);
            for (int j = 0; j < words[0].length(); j++) {
                // add j+1 the "" also need to be added
                String w = words[i].substring(0, j + 1);
                // provide value for new key which is absent
                // using computeIfAbsent method
                res.computeIfAbsent(w, k -> new ArrayList<String>()).add(words[i]);

            }
        }
        return res;
    }
