package leetcode638;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=638 lang=java
 *
 * [638] Shopping Offers
 */

// @lc code=start
class Solution {
    List<Integer> price;
    List<Integer> targets;
    List<List<Integer>> offers;
    int itemSize;

    int res = Integer.MAX_VALUE;
    //visited?
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
 
        this.price = price;
        this.targets = needs;
        this.offers = new ArrayList<>(special);
        // add buyding the item respectively
        this.itemSize = this.price.size();
        for(int i=0; i < itemSize; i++){
            List<Integer> singleItemRule = getEmptyList() ;
            singleItemRule.set(i, 1);
            //price
            singleItemRule.add(this.price.get(i));
            offers.add(singleItemRule);
        }


        if (fullFillTarget(this.targets))
            return 0;

        dfs(targets, 0);
        return res;
    }
    //! exactly certain items as given
    void dfs(List<Integer> target, int curPrice) {
        // valid(targets, offer);
        // for(Integer target: targets){
        //     if(target < 0)
        // }
        for(List<Integer> offer: this.offers){
            List<Integer> nextTarget = getNextTarget(offer, target);
            int nextPrice = curPrice + offer.get(itemSize);
            
            if(fullFillTarget(nextTarget)){
                if(nextPrice < res)
                    res = nextPrice;
            }else if(isValid(nextTarget)){
                dfs(nextTarget, nextPrice);
            }
        }
    }
    //不对:物品是一个一个来满足的 选择当前的 offer 的时候是否可以, 只能恰好的情况
    //valid 的情况是所有商品的 volumne < required one
    // void dfs(List<Integer> cur, int pos, int curPrice){
    //   while (pos < itemSize && cur.get(pos) >= targets.get(pos))
    //         pos++;
    //   if(pos == itemSize){
    //       if(curPrice < res)
    //             res = curPrice;
    //       return;
    //   }
     

    private boolean fullFillTarget(List<Integer> nextTarget) {
        for(int i=0 ; i< itemSize; i++){
            if(nextTarget.get(i) != 0)
                return false;
        }
        return true;
    }

    private boolean isValid(List<Integer> nextTarget) {
        for(Integer target: nextTarget){
            if(target < 0)
                return false;
        }
        return true;
    }

    private List<Integer> getNextTarget(List<Integer> offer, List<Integer> target) {
        List<Integer> res = getEmptyList();
        for(int i=0 ; i<itemSize; i++){
            res.set(i, target.get(i) - offer.get(i));
        }
        return res;
    }

    List<Integer> getEmptyList(){
        List<Integer> list  = new ArrayList<Integer>();
        for(int i=0; i<itemSize; i++){
            list.add(0);
        }
        return list;
    }
    boolean fullFillNeeds(List<Integer> cur){
          for(int i =0; i< itemSize; i++){
            if(cur.get(i) < targets.get(i))
                return false;
        }
        return false;
    }

    public static void main(String[] args) {
       List<Integer> price = Arrays.asList(new Integer[]{2,5});
       List<List<Integer>> special = new ArrayList<>();
       special.add(Arrays.asList(new Integer[] { 3, 0, 5 }));
       special.add(Arrays.asList(new Integer[] { 1, 2, 10 }));
       List<Integer> needs =  Arrays.asList(new Integer[]{3,2});
      System.out.println(new Solution().shoppingOffers(price, special, needs));
    }
}
// @lc code=end

