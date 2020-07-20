package bst;



class Main{

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] values = new int[] {  5, 3, 2, 4, 6 };
        for (int v : values) {
            bst.add(v);
        }
        bst.preOrdernNR();
        bst.preOrder();
        
    }
}
