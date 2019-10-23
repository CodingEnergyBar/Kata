import java.util.ArrayList;
import java.util.List;

public class Factorization {
    /**
     * @param n an integer
     * @return a list of combination
     */
     public static void main(String[] args) {
         Factorization test =  new Factorization();
         System.out.println( test.getFactors(15));

    }

    /**
     * @param n an integer
     * @return a list of combination
     */
//    public List<List<Integer>> getFactors(int n) {
//        // write your code here
//        List<List<Integer>> result = new ArrayList<List<Integer>>();
//        helper(result, new ArrayList<Integer>(), n, 2);
//        return result;
//    }

//    public void helper(List<List<Integer>> result, List<Integer> item, int n, int start) {
//        if (n == 1) {
//            if (item.size() > 1) {
//                result.add(new ArrayList<Integer>(item));
//            }
//            return;
//        }
//
//        for (int i = start; i <= n; ++i) {
//            if (n % i == 0) {
//                item.add(i);
//                helper(result, item, n / i, i);
//                item.remove(item.size()-1);
//            }
//        }
//
//        if (n >= start) {
//            item.add(n);
//            helper(result, item, 1, n);
//            item.remove(item.size() - 1);
//        }
     /**
         * @param n: An integer
         * @return: a list of combination
         */
        public List<List<Integer>> getFactors(int n) {
            // write your code here
            List<List<Integer>> rst = new ArrayList<>();
            dfs(rst, new ArrayList<>() , n);
            return rst;
        }

        private void dfs(List<List<Integer>> rst, List<Integer> list, int n){
            for (int i = list.isEmpty()?2:list.get(list.size() - 1);i <= Math.sqrt(n); i++){
                list.add(i);
                if (n % i == 0) {
                    int tmp = n / i;
                    list.add(tmp);
                    rst.add(new ArrayList(list));
                    list.remove(list.size() - 1);
                    if (tmp > list.get(list.size() - 1)) {
                        dfs(rst, list, tmp);
                    }
                }
                list.remove(list.size() - 1);
            }
        }
}
