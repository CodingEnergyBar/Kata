public class Solution {
    /**
     * @param s: Roman representation
     * @return: an integer
     */
    public int romanToInt(String s) {
        // Symbol I V X L C D M
        // Value 1 5 10 50 100 500 1000
        // "V", 5,
        // "X",10,
        // "L",50,
        // "C",100,
        // "D",500,
        // "M",1000

        // ROMAN TO INTEGER NEED SOME COMPARE
        // SIMULATION TEST

        // Map<Character, Integer> hash = new HashMap<Character, Integer>(){
        // {
        // put('I', 1);
        // // put("V", 5);
        // // put("X",10);
        // // put("L",50);
        // // put("C",100);
        // // put("D",500);
        // // put("M",1000);
        // }
        // };

        // Intialize hash map in java put....
        // get some understadning of the parameter in
        // inner list/??
        // List<Integer> list=Arrays.asList(1, 2, 3);
        // List<List<String>> csvList = new ArrayList<List<String>>();
        // instead of list<arraylist>// could change to list<vector> later

        Map<Character, Integer> hash = new HashMap<>();

        hash.put('I', 1);
        hash.put('V', 5);
        hash.put('X', 10);
        hash.put('L', 50);
        hash.put('C', 100);
        hash.put('D', 500);
        hash.put('M', 1000);

        int res = 0;
        // string only have length() instead of size()
        for (int i = 0; i < s.length() - 1; i++) {
            char c = s.charAt(i);
            boolean isNeg = false;

            char ch2 = s.charAt(i + 1);
            if (hash.get(c) < hash.get(ch2)) {
                isNeg = true;
            }

            int cur = hash.get(c);
            if (isNeg)
                cur = -cur;
            res += cur;
            System.out.println(res);
        }
        res += hash.get(s.charAt(s.length() - 1));

        System.out.println(res);

        return res;
        // hash.put()

        // write your code here
    }
}