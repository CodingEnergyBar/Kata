class Solution {
    public int[][] highFive(int[][] items) {
        // comparator how to write

        HashMap<Integer, ArrayList<Integer>> scores = new HashMap();
        for (int i = 0; i < items.length; i++) {
            int id = items[i][0];
            int s = items[i][1];
            if (!scores.containsKey(id)) {
                scores.put(id, new ArrayList<Integer>());
            }
            scores.get(id).add(s);
        }
        int[][] res = new int[scores.size()][2];

        int j = 0;
        for (Integer id : scores.keySet()) {

            ArrayList<Integer> rank = scores.get(id);
            rank.sort((a, b) -> {
                return b - a;
            });
            int topFive = 0;
            for (int i = 0; i < 5; i++) {
                topFive += rank.get(i);
            }

            res[j] = new int[] { id, topFive / 5 };
            j++;
        }
        return res;

    }
}