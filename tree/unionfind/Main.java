package unionfind;

import java.util.Random;

class Main{

    static double testUF(UF uf, int m) {
        int size = uf.getSize();
        double startTime, endTime;
        Random random = new Random();
        startTime = System.nanoTime();
        for(int i=0; i<m; i++){
            int p = random.nextInt(size);
            int q = random.nextInt(size);
            uf.unionElements(p, q);
        }
        for (int i = 0; i < m; i++) {
            int p = random.nextInt(size);
            int q = random.nextInt(size);
            uf.isConnected(p, q);
        }
        endTime = System.nanoTime();
        return (endTime-startTime)/1000000000.0;
    }
    public static void main(String[] args) {
        int size = 100000;
        int m = 100000;
        UnionFind1 uf1 = new UnionFind1(size);
        System.out.println("UnionFind1: " + testUF(uf1, m) + " s");
        UnionFind2 uf2 = new UnionFind2(size);
        System.out.println("UnionFind2 :" + testUF(uf2, m) + " s");
    }
}