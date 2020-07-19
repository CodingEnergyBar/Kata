package unionfind;

import java.util.TreeMap;
// 第2版
class UnionFind2 implements UF{
    int[] parent;
    UnionFind2(int size){
        parent = new int[size];
        // 初始的 id 值是编号
        for(int i=0; i<size;i++)
            parent[i] = i;
    }
    @Override
	public boolean isConnected(int p, int q) {
        return find(p) == find(q);
	}

	@Override
	public int quickFind(int p) {
        
		return parent[p];
	}

	@Override
	public int getSize() {
		return parent.length;
    }

    public void unionElements(int p, int q){
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot == qRoot)
            return;
        parent[p] = q;
    }

    private int find(int p){
        while(parent[p]!= p){
            p = parent[p];
        }
        return p;
    }

}


