public class binarySearch {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }
    static Node insert(Node root,int val){

        if (root == null){
            root = new Node(val);
            return root;
        }
        if (root.data > val){
            root.left = insert(root.left,val);
        }else {
            root.right = insert(root.right,val);
        }
        return root;
    }

    public static void inOrder(Node root){
        if (root == null){
            return;
        }
        inOrder(root.left);
        System.out.println(root.data+" ");
        inOrder(root.right);
    }
    public static boolean search(Node root,int Key){
        if (root == null){
            return false;
        }
        if (root.data == Key){
            return true;
        }
        if (root.data > Key){
            return search(root.left,Key);
        }
        else {
            return search(root.right,Key);
        }
    }



    public static void main(String[] args) {
        int val[]={5,1,3,4,2,7};
        Node root =null;

        for (int i =0; i< val.length;i++){
            root =insert(root,val[i]);

        }
        inOrder(root);
        System.out.print(" ");
        int key = 3;
        if (search(root,key)){
            System.out.println("The Key You Searching For Found ");
        }else {
            System.out.println("The Key You Searching For Not Found");
        }
    }
}
