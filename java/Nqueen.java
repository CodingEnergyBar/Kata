public class Solution {
    /*
     * @param n: The number of queens
     * 
     * @return: All distinct solutions
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        dfs(new int[n][n], 0, n, res);
        return res;

    }

    void dfs(int[][] path, int row, int n, List<List<String>> res) {
        // System.out.println("path " + Arrays.deepToString(path));
        if (row == n) {
            res.add(translatePath(path, n));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (checkAtCol(i, row, path, n)) {
                // System.out.println("row " + row);
                // System.out.println("col " + i);
                path[row][i] = 1;
                dfs(path, row + 1, n, res);
                path[row][i] = 0;
            }
        }
    }

    boolean checkAtCol(int col, int row, int[][] path, int n) {
        // System.out.println("checkAtCol path " + Arrays.deepToString(path));

        for (int i = 0; i < row; i++) {
            if (path[i][col] == 1)
                return false;
        }
        // diagnal is not like this
        int col1 = col - 1;
        int col2 = col + 1;
        for (int j = row - 1; j >= 0; j--) {
            if (col1 >= 0)
                if (path[j][col1] == 1)
                    return false;
                else
                    col1--;
            if (col2 < n)
                if (path[j][col2] == 1)
                    return false;
                else
                    col2++;
        }

        // if(row >= 1 && col - 1>=0 &&path[row-1][col-1] == 1 )
        // return false;
        // if(row >= 1 && col +1 < n &&path[row-1][col+1] == 1 )
        // return false;

        return true;
    }

    List<String> translatePath(int[][] path, int n) {
        List<String> res = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            String cur = "";
            for (int j = 0; j < n; j++) {
                if (path[i][j] == 1)
                    cur += "Q";
                else
                    cur += ".";
            }
            res.add(cur);
        }
        return res;

    }

}