import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*
 * @lc app=leetcode id=752 lang=java
 *
 * [752] Open the Lock
 */

// @lc code=start
class WaterBucketSolution {
    int[] pre = new int[100];
    int end = -1;
    WaterBucketSolution(){
        caculate();
    }
    public void caculate() {
      
        int node0  = 0;

        // Set<Integer> visited = new HashSet<>();
        boolean[] visited = new boolean[100];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(node0);
        visited[node0] = true;
        

        while(!queue.isEmpty()){
            int cur = queue.remove();
            List<Integer> nexts =  new ArrayList<>();
            //nexts;  
            //a max 5, b max 3;
            int a = cur / 10, b = cur % 10;
            nexts.add(5 * 10 + b);
            nexts.add(a * 10 + 3);
            nexts.add(10 * a);
            nexts.add(b);
            // a -> b
            // 不是 int x = Math.min(a, a-b);
            // 可以从 a到 b 的水数: 关注 a 能提供多少, b 能承受多少 -> 最小的数
            int x = Math.min(a, 3 - b);
            nexts.add((a - x) * 10 + (b + x));

            // b -> a
            int y = Math.min(b, 5 - a);
            nexts.add((a + y) * 10 + (b - y)); 

            for(int next: nexts){
                if(!visited[next]){
                    visited[next] = true;
                    queue.add(next);
                    //这里也要看一下, 把现在的补充上去
                    pre[next] = cur;
                    if(next / 10 == 4){
                        //有个标志
                        end = next;
                        return;
                    }
                }
            }
        }
        return;
    }
    //Iterable return 一些可以遍历的数据结构  such aslist
    public Iterable<Integer> result(){
        List<Integer> res = new LinkedList<>();
        if(end == -1) return res;

        int last = end;
        // last 不等于 0, 而不是 pre[last]
        while(last != 0){
            res.add(0, last);
            last = pre[last];
        }
        res.add(0, 0);
        return res;
    }

    public static void main(String[] args) {

        System.out.println(new WaterBucketSolution().result());
    }
}
// @lc code=end

