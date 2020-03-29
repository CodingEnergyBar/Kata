public class TwoSum {
    /**
     * @param number: An integer
     * @return: nothing
     */
    
    private HashMap<Integer, Integer> map;
    
    TwoSum(){
        // hashmap 
        // Collections.
        map = new HashMap();
    }
    public void add(int number) {
        // write your code here
        if( map.get(number) == null){
            map.put(number , 1);
        }else{
            map.put(number, map.get(number)+1);
        }
    }

    /**
     * @param value: An integer
     * @return: Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        // write your code here
        for (Integer key : map.keySet()){
            Integer val1 = key;
            Integer val2 = value - key;
            if(val1 == val2){
                if(map.get(val1) > 1)
                    return true;
            }else{
                if(map.get(val2) != null){
                    return true;
                }
            }
        }
        return false;
        
    }
}