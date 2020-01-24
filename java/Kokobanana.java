class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        if (piles.length > H)
            return -1;
        int start = 1, end = maxValue(piles);

        while (start + 1 < end) {
            System.out.println("start " + start);
            System.out.println("end " + end);
            int mid = (end + start) / 2;
            if (possible(mid, piles, H))
                end = mid;
            else
                start = mid;
        }
        if (possible(start, piles, H))
            return start;
        return end;

    }

    boolean possible(int mid, int[] piles, int H) {
        int sum = 0;
        for (int i = 0; i < piles.length; i++) {
            sum += Math.ceil(piles[i] * 1.0 / mid);
        }
        if (sum <= H)
            return true;
        else
            return false;
    }

    int maxValue(int[] piles) {
        int MAX = Integer.MIN_VALUE;
        for (int i = 0; i < piles.length; i++) {
            if (piles[i] > MAX)
                MAX = piles[i];
        }
        return MAX;
    }
}