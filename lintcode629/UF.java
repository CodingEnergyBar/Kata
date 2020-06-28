/*
 * @Author: xiuming.x 
 * @Date: 2020-08-03 16:46:40 
 * @Last Modified by: xiuming.x
 * @Last Modified time: 2020-08-03 16:52:30
 */
package lintcode629;

public class UF {
    int[] p;

    public UF(int size) {
        p = new int[size];
        for (int i = 0; i < size; i++) {
            p[i] = i;
        }
    }

    boolean isConnected(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
         return aRoot == bRoot;
    }

    int find(int i) {
        if (p[i] != i) {
            p[i] = find(p[i]);
        }
        return p[i];
    }

    void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot != bRoot) {
            p[aRoot] = bRoot;
        }
    }

}