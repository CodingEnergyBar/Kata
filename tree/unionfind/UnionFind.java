package unionfind;

import java.util.ArrayList;
import java.util.TreeMap;

class Node {
    Boolean isWord;
    TreeMap<Character, Node> nexts;

    Node() {
        isWord = false;
        nexts = new TreeMap<>();
    }
}

// 第一版
class UnionFind implements UF{
    int[] id;
    UnionFind(int size){
        id = new int[size];
        // 初始的 id 值是编号
        for(int i=0; i<size;i++)
            id[i] = i;
    }
    @Override
	public boolean isConnected(int p, int q) {
        return find(p) == find(q);
	}

	@Override
	public int quickFind(int p) {
		return 0;
	}

	@Override
	public int getSize() {
		return id.length;
    }

    public void unionElements(int p, int q){
        int pId = find(p);
        int qId = find(q);
        if(pId == qId)
            return;
        //重点: 感觉数组很强大
        for(int i=0; i<id.length; i++){
            if(id[i] == pId)
                id[i] = qId;
        }
    }

    private int find(int p){
        if(p < id.length)
            throw new IllegalArgumentException("p is out of bound");
        return id[p];
    }

}


