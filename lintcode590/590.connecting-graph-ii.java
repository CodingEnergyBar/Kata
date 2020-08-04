package lintcode590;

public class ConnectingGraph3 {
    /**
     * @param a: An integer
     * @param b: An integer
     * @return: nothing
     */
    int p[];
    int componentSize;
    public ConnectingGraph3(int n) {
        // initialize your data structure here.
        // because of label 1-n
        p = new int[n+1];
        componentSize = n;
        for(int i=0; i<=n; i++){
            p[i] = i;
        }
    }
    
    public void connect(int a, int b) {
        // write your code here
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot != bRoot){
            p[aRoot] = bRoot;
            componentSize--;
        }

    }
    
    public int find(int i){
        if(p[i] != i){
            p[i] = find(p[i]);
        }
        return p[i];
    }

    /**
     * @return: An integer
     */
    public int query() {
        // write your code here
        return componentSize;
    }
    
    
}