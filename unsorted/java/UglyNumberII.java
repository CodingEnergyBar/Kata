public class Solution {
    /**
     * @param n: An integer
     * @return: return a integer as description.
     */
    public int nthUglyNumber(int n) {
        // write your code here
        if (n == 0) {
            return 0;
        }
        PriorityQueue<Long> min = new PriorityQueue();

        HashSet<Long> hash = new HashSet();

        min.add(Long.valueOf(1));
        hash.add(Long.valueOf(1));

        // we don't use hash size as the condition as it is not robust
        // while(hash.size() < n){
        // Integer cur = min.peek();
        // factor(cur,2,min, hash);
        // factor(cur,3,min, hash);
        // factor(cur,5,min, hash);
        // }
        // we use n, doing n poll()
        Long res = Long.valueOf(1);
        for (int i = 0; i < n; i++) {
            // !!! every time only find the cur min
            res = min.poll();
            factor(res, Long.valueOf(2), min, hash);
            factor(res, Long.valueOf(3), min, hash);
            factor(res, Long.valueOf(5), min, hash);
        }

        return res.intValue();

    }

    public void factor(Long num, Long factor, PriorityQueue<Long> min, HashSet<Long> pool) {
        Long factored = num * factor;
        if (!pool.contains(factored)) {
            pool.add(factored);
            min.add(factored);
        }

    }
}