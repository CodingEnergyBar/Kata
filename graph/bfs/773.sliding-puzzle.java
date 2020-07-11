import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
 * @lc app=leetcode id=773 lang=java
 *
 * [773] Sliding Puzzle
 */

// @lc code=start
class Solution {
    int[][] dirs = new int[][]{{0,1}, {0, -1}, {1,0}, {-1, 0}};

    public int slidingPuzzle(int[][] board) {
        int curInt = boardToInt(board);
        int[][] targetBoard = {{1,2,3},{4,5,0}};
        int targretInt = boardToInt(targetBoard);
        if(curInt == targretInt){
            return 0;
        }
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> visited = new HashMap<>();
        queue.add(curInt);
        visited.put(curInt, 0);

        while(!queue.isEmpty()){
            curInt =  queue.remove();
            List<Integer> nexts =  getNexts(curInt);
            for(Integer next: nexts){
                if(!visited.containsKey(next)){
                    queue.add(next);
                    visited.put(next, visited.get(curInt) + 1);
                    if(next == targretInt)
                        return visited.get(next);
                }
            }
        }
        return -1;
    }
    List<Integer> getNexts(Integer cur){
        List<Integer> res = new ArrayList<>();
        int[][] curBoard = intToboard(cur);
        int zero = 0, tmp = cur;
        
        // 从低往高弄会好一点: 每次找最后一位
        for(int i = 5; i >=0 ; i--){
            int curBit =  tmp % 10;
            if(curBit == 0){
                zero = i;
                break;
            }
            tmp = tmp / 10;
        }
    
        // x --> / y --> %
        int zx =  zero / 3, zy = zero % 3;

        for(int i=0 ; i< dirs.length; i++){
            int nx = zx + dirs[i][0], ny = zy + dirs[i][1];
            if(inArea(nx, ny)){
                swap(curBoard, nx, ny, zx, zy);
                res.add(boardToInt(curBoard));
                swap(curBoard, nx, ny, zx, zy);
            }
        }
        return res;
    }
    void swap(int[][] board, int x, int y, int a, int b){
        int tmp = board[x][y];
        board[x][y] =  board[a][b];
        board[a][b] = tmp;
    }
    boolean inArea(int x, int y){
        return x >=0 && y>=0 && x < 2 && y < 3;
    }
    // int to other 的时候都是从低往高好弄一点
    int[][] intToboard(int cur){
        int tmp = cur;
        int[][] board = new int[2][3];
        for(int i =5 ; i >= 0; i--){
            board[i/3][i%3] = tmp % 10;
            tmp = tmp / 10;
        }
        return board;
    }
    

    int boardToInt(int[][] board){
        int res = 0;
        //从 0 到 5 一点点往上推
        for(int i= 0; i < 6; i++){
            res = res* 10 + board[ i/3 ][ i%3 ];
        }
        return res;
    }

    // public static void main(String[] args) {
    //     // int[][] board = {{1,2,3},{4,5,0}};
    //     int[][] board = {{4,1,2},{5,0,3}};
    //     int res = new Solution2().slidingPuzzle(board);
    //     System.out.println(res);
    //     // System.out.println(Arrays.deepToString(new Solution2().intToboard(boardInt)));
    // }
}

// @lc code=end

