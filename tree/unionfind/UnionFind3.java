package unionfind;

// 第4版: 基于 size 的优化
class UnionFind3 implements UF{
    int[] parent;
    int[] sz;
    UnionFind3(int size){
        parent = new int[size];
        sz = new int[size];
        // 初始的 id 值是编号
        for(int i=0; i<size;i++)
        {
            parent[i] = i;
            sz[i] = 1; //1个单元
        }
    }
    @Override
	public boolean isConnected(int p, int q) {
        return find(p) == find(q);
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
       if(sz[pRoot] > sz[qRoot]){
           parent[qRoot] = pRoot;
           sz[pRoot] += sz[qRoot];
       }else{
           parent[pRoot] = qRoot;
           sz[qRoot] += sz[pRoot];
       }
    }
    // how to find the rank?
    private int find(int p){
        while(parent[p]!= p){
            p = parent[p];
        }
        return p;
    }
}


