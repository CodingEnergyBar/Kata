package unionfind;

// 第4版: 基于 rank 的优化
public class UnionFind4 implements UF{
    int[] parent;
    int[] rank;
    public UnionFind4(int size){
        parent = new int[size];
        rank = new int[size];
        // 初始的 id 值是编号
        for(int i=0; i<size;i++)
        {
            parent[i] = i;
            rank[i] = 1; //层数也是以
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
        // 这里记录的 root: 每次搞的是 root 的 rank
        if(rank[pRoot] < rank[qRoot]){
            //维护 p 和 q 的
            parent[pRoot] = qRoot;
            // rank[pRoot] = 
        }else if(rank[pRoot] > rank[qRoot]){
            parent[qRoot] = pRoot;
            // rank[qRoot] = rank[pRoot]; 不对, 因为不用管非根节点的 rank 
            //!!!rank 只针对根节点
        }else{
            parent[pRoot] = qRoot;
            rank[qRoot]  +=1 ; //相等的时候最夸张
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


