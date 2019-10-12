class Solution {
    public int[][] highFive(int[][] items) {
        // comparator how to write
        Comparactor<Integer> cmp = new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        };

        // HashMap<Integer, ArrayList<Integer>> scores = new HashMap();
        HashMap<Integer, Queue<Integer>> idToscores = new HashMap();
        List<Integer> ids = new ArrayList();

        // for (int i = 0; i < items.length; i++) {
        // int id = items[i][0];
        // int s = items[i][1];
        // if (!scores.containsKey(id)) {
        // scores.put(id, new ArrayList<Integer>());
        // }
        // scores.get(id).add(s);
        // }

        // new writing
        for (int[] item : items) {
            int id = item[0];
            int score = item[1];
            if (!idToscores.containsKey(id)) {
                ids.add(id);
                idToscores.put(id, new PriorityQueue<Integer>((a, b) -> {
                    return b - a;
                }));
            }
            Queue rank = idToscores.get(id);
            rank.add(score);
            if(rank.size()>5){
                rank.poll();
            }
        }
      
        // hashmap's key need to be sorted as well;
        ids.sort((a, b) -> a - b);

        int[][] res = new int[ids.size()][2];


        for (int i=0; i<ids.size();i++) {
            int id = ids.get(i);

            Queue<Integer> rank = idToscores.get(id);

            int topFive = 0;
            for (int i = 0; i < 5; i++) {
                topFive += rank.poll();
            }

            res[i] = new int[] { id, topFive / 5 };
         
        }
        return res;

    }
}