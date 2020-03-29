public class Solution {
    /**
     * @param init_state: the initial state of chessboard
     * @param final_state: the final state of chessboard
     * @return: return an integer, denote the number of minimum moving
     */
    public int minMoveStep(int[][] init_state, int[][] final_state) {
        // # write your code here
        String init = toString(init_state);
        String end = toString(final_state);
        
        // getNextStatus("283104765");
        Queue<String> queue = new LinkedList(){};
        HashSet<String> visited =  new HashSet();
        
        queue.add(init);
        visited.add(init);
        
        int step = 0;
        while(!queue.isEmpty()){
            // System.out.println(queue.toString());
            int size = queue.size();
           
            for(int i=0; i< size; i++){
                String cur = queue.poll();
                if(cur.equals(end))
                    return step;
                for(String next: getNextStatus(cur)){
                    if(!visited.contains(next)){
                        visited.add(next);
                        queue.offer(next);
                    }
                }
            }
             step++;
        }
        
        return -1;
    }
    
    String toString(int [][] state){
        StringBuilder  res= new StringBuilder();
        for(int i=0;i<3;i++){
            for(int j=0 ; j< 3; j++){
                // string builder use append
                 res.append(state[i][j]);
            }
        }
        // string builder to string...
        return res.toString();
    }
    
    ArrayList<String> getNextStatus(String s){
         ArrayList<String> res = new ArrayList();
        //  // this array should not be here
        // char[] array = s.toCharArray();
        
        // string indexOf
        int zeroIndex = s.indexOf('0');
        
        int x = zeroIndex / 3;
        int y = zeroIndex % 3;
        
        // int[] dx = new int[]{0,0,1,-1};
        // you can write like this.
        int[] dx = {0,0,1,-1};
        int[] dy = new int[]{1,-1,0,0};
        
        for(int i=0; i < 4; i++){
            
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || ny < 0 || nx > 2 || ny > 2){
                continue;
            }
            // swap 
            int newIndex =  nx  * 3 + ny;
             
            char[] array = s.toCharArray();
            char tmp = array[zeroIndex];
            array[zeroIndex] = array[newIndex];
            array[newIndex] = tmp;
            // char to string is new String 
            res.add(new String(array));
        }
        System.out.println(res.toString());
        return res;
        
    }
}