import java.util.ArrayList;

public class LeafPath {
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
    static void printLeaf(ArrayList<Integer> path){
for (int i = 0;i<path.size();i++){
    System.out.print(path.get(i) + " -> ");

        }
        System.out.println("NULL");
    }
    static void leafPath(Node root, ArrayList<Integer> path){
        if (root == null){
            return;
        }
        path.add(root.data);
        if (root.left == null && root.right == null){
            printLeaf(path);
        }

        leafPath(root.left,path);
        leafPath(root.right,path);
        path.remove(path.size()-1);
    }


    public static void main(String[] args) {
        int val[]={8,5,3,1,4,6,10,11,14};
        Node root =null;

        for (int i =0; i< val.length;i++){
            root =insert(root,val[i]);

        }
        inOrder(root);
        System.out.println();
        leafPath(root,new ArrayList<>());

    }
}



