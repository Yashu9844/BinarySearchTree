public class Valid {
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
        System.out.print(root.data+" ");
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
    static void Range(Node root,int k1,int k2){
        if (root == null){
            return;
        }
        if (root.data >= k1 && root.data <= k2){
            Range(root.left,k1,k2);
            System.out.print(root.data + " ");
            Range(root.right,k1,k2);

        } else if (root.data < k1) {
            Range(root.left,k1,k2);

        }
        else{
            Range(root.right,k1,k2);
        }
    }

    public static Node findIs(Node root){
        while (root.left != null){
            root = root.left;
        }
        return root;


    }

    public static boolean validBST(Node root,Node min,Node max){
        if (root == null){
            return true;
        }
        if (min != null && root.data<= min.data){
            return false;
        } else if (max != null && root.data >= max.data) {
            return false;

        }
        return validBST(root.left,min,root) && validBST(root.right,root,max);
    }


    public static void main(String[] args) {
        int val[]={8,5,3,6,10,11,14};

        Node root =null;

        for (int i =0; i< val.length;i++){
            root =insert(root,val[i]);

        }
        inOrder(root);
        System.out.println();

        if (validBST(root,null,null)){
            System.out.println("Valid binary Search Tree");
        }
        else {
            System.out.println("Not an Valid Binary Search Tree");
        }


    }
}


