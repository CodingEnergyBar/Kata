package avl;

import java.util.Stack;

public class AVLTree <K extends Comparable<K>, V>{

    class Node {
        K key;
        V value;
        Node left;
        Node right;
        int height, balanceFactor;

        Node(K k, V v){
            this.key = k;
            this.value = v;
            this.height = 1;
            left = null;
            right = null;
        }
    }
    Node root;
    int size;
    
    AVLTree(){
        root = null;
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty() {   
        return size == 0;
    }

    public void add(K k, V v){
        root = add(root, k, v);
    }
    // e 可能是 root 的孩子, 也可能就是root
    private Node add( Node cur, K k, V v){
        // 先保证 cur != null
        if(cur == null){
            size++;
            return new Node(k, v); 
        }
        // 为什么返回的是左孩子的根呢
        if(k.compareTo(cur.key) > 0){
            cur.right = add(cur.right, k, v);     
        }else if(k.compareTo(cur.key) < 0){
            cur.left = add(cur.left, k, v);
        }
        // 这里把 根节点也返回了, 把左孩子改写之后
        cur.height = Math.max(getHeight(cur.left), getHeight(cur.right)) + 1;
        return cur;
    }

    private int getHeight(Node cur){
        if(cur == null)
            return 0;
        return cur.height;
    }

    public Boolean contains(K k){
        return contains(root, k);
    }

    public void preOrder(){
        preOrder(root);
    }
    // 前序遍历以node为根的二分搜索树, 递归算法
    private void preOrder(Node node) {

        if (node == null)
            return;
        System.out.println(node.key);
        preOrder(node.left);
        preOrder(node.right);
    }

    //非递归 二分搜索树的前序遍历 non-recursive
    public void preOrdernNR() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node cur = stack.pop();
            if(cur == null)
                 continue;
            System.out.println(cur.key);
            stack.push(cur.right);
            stack.push(cur.left);
           
        }
    }

    public K removeMax(){
        // 并没有利用 maximum, 去删除, 还是要删除, 因为要 parent
        K ret = maximum();
        if(root != null)
            root = removeMax(root);
        return ret;
    }
    //删除以 cur 为根的 最小节点
    //返回新的根
    private Node removeMax(Node root){
        Node ret;
        if(root.right != null)
            root.right = removeMax(root.right);
        // 找到了要删除的节点
        ret = root.left;
        root = null;
        return ret;
    }

    public K maximum() {
        return maximum(root);
    }

    private K maximum(AVLTree<K, V>.Node cur) {
        if(cur.right != null)
            return  maximum(cur.right);
        return cur.key;
    }

    private Boolean contains(Node cur, K e) {
        if(cur == null)
            return false;
        if(e.compareTo(cur.key) > 0){
            return contains(cur.right, e);
        }
        else if(e.compareTo(cur.key) < 0){
            return contains(cur.left, e);
        }
        return true;
    }


    // 返回以node为根节点的二分搜索树中，key所在的节点
    private Node getNode(Node node, K key) {

        if (node == null)
            return null;

        if (key.equals(node.key))
            return node;
        else if (key.compareTo(node.key) < 0)
            return getNode(node.left, key);
        else // if(key.compareTo(node.key) > 0)
            return getNode(node.right, key);
    }

    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }


    public void set(K key, V newValue){
        Node node = getNode(root, key);
        if(node == null)
            throw new IllegalArgumentException(key + " doesn't exist!");

        node.value = newValue;
    }


    private int getBalanceFactor(Node cur) {
        if (cur == null)
            return 0;
        return getHeight(cur.left) - getHeight(cur.right);
    }


    public boolean isBalanced() {
        return isBalanced(root);
    }
    
    // 判断以Node为根的二叉树是否是一棵平衡二叉树，递归算法
    private boolean isBalanced (Node cur){
        if(cur == null) 
            return true;
        int balanceFactor = getBalanceFactor(cur);
        if(Math.abs(balanceFactor) > 1)
            return false;
        return isBalanced(cur.left)
        && isBalanced(cur.right);
    }
    
   
}