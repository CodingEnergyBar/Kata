package segment;

public class SegmentTree<E> {
    
    private E[] tree;
    private E[] data;
    private Merger<E> merger;

    // 定义线段树中的区间是如何融合的: comparator 也是这个意思 在优先队列里怎么比较
    public SegmentTree(E[] arr, Merger<E> merger) {
        data = (E[]) new Object[arr.length];

        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        tree = (E[]) new Object[4 * arr.length];
        this.merger = merger;
        buildSegmentTree(0, 0, data.length-1); /* 0[0, len) */
    }
    // l -> r in treeIndex
    private void buildSegmentTree(int treeIndex, int l, int r) {
        if(l == r){
            tree[treeIndex] = data[l];
            return;
        }
        // treeIndex???
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        int mid = l + (r - l) / 2;
        buildSegmentTree(leftTreeIndex, l, mid);
        buildSegmentTree(rightTreeIndex, mid+1, r);

        // 和业务相关: 求和 
        // 在E上不一定定义了 E ---> new 一个接口实现
        tree[treeIndex] = merger.merge(tree[leftTreeIndex] , tree[rightTreeIndex]);
    }
    
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    public int getSize() {
        return data.length;
    }
    public E get(int index){
        if(index < 0 || index >= data.length)
            throw new IllegalArgumentException("Index is illegal");
        return data[index];
    }
    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append('[');
        for(int i=0; i< tree.length; i++){
            if(tree[i] != null)
                res.append(tree[i]);
            else
                res.append("null");
            if( i != tree.length - 1)
                res.append(", ");

        }
        res.append("]");

        return res.toString();
    }

    // 已改可以让用户定义, 所以不再这里
    // @Override
    // public E merge(E a, E b) {
    //     // TODO Auto-generated method stub
    //     return 
    //     return null;
    // }

}