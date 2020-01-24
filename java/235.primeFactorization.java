public class Solution {
    /**
     * @param num: An integer
     * @return: an integer array
     */
    public List<Integer> primeFactorization(int num) {
        // write your code here
        List<Integer> res = new ArrayList();
        int i;
        for (i = 2; i * i <= num; i++) {
            while (num % i == 0) {
                num = num / i;
                res.add(i);
            }
        }
        System.out.println("num " + num);
        if (num != 1)
            res.add(num);

        return res;

    }
}