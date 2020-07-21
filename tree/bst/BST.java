package bst;

import java.util.Stack;

public class BST <E extends Comparable<E>>{

    class Node {
        E e;
        Node left;
        Node right;

        Node(E e){
            this.e = e;
            left = null;
            right = null;
        }
    }
    Node root;
    int size;
    BST(){
        root = null;
        size = 0;
    }

    public void add(E e){
        if(root == null){
            root = new Node(e);
            return;
        }
        root = add(root, e);
    }
    // e 可能是 root 的孩子, 也可能就是root
    private Node add( Node cur, E e){
        // 先保证 cur != null
        if(cur == null){
            return new Node(e); 
        }
        // 为什么返回的是左孩子的根呢
        if(e.compareTo(cur.e) > 0){
            cur.right = add(cur.right, e);     
        }else if(e.compareTo(cur.e) < 0){
            cur.left = add(cur.left, e);
        }
        // 这里把 根节点也返回了, 把左孩子改写之后
        return cur;
    }

    public Boolean contains(E e){
        return contains(root, e);
    }

    public void preOrder(){
        preOrder(root);
    }
    // 前序遍历以node为根的二分搜索树, 递归算法
    private void preOrder(Node node) {

        if (node == null)
            return;
        System.out.println(node.e);
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
            System.out.println(cur.e);
            stack.push(cur.right);
            stack.push(cur.left);
           
        }
    }


    public E removeMax(){
        // 并没有利用 maximum, 去删除, 还是要删除, 因为要 parent
        E ret = maximum();
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

    public E maximum() {
        return maximum(root);
    }

    private E maximum(BST<E>.Node cur) {
        if(cur.right != null)
            return  maximum(cur.right);
        return cur.e;
    }

    private Boolean contains(Node cur, E e) {
        if(cur == null)
            return false;
        if(e.compareTo(cur.e) > 0){
            return contains(cur.right, e);
        }
        else if(e.compareTo(cur.e) < 0){
            return contains(cur.left, e);
        }
        return true;
    }
   
    
}