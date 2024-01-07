public class SizeOfLargestBST {
    public static class Node {
        int data;
        SizeOfLargestBST.Node left;
        SizeOfLargestBST.Node right;

        Node(int data) {
            this.data = data;
            this.left= this.right= null;
        }
    }

    static class Info {
        boolean isBST;
        int size;
        int min;
        int max;

        Info(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }
    public  static int maxBST =0;
    public static Info largestBSt(Node root){

        if (root == null){
            return new Info(true , 0 ,Integer.MAX_VALUE,Integer.MIN_VALUE);
        }

    Info leftSide = largestBSt(root.left);
    Info rightSide = largestBSt(root.right);
    int size = leftSide.size + rightSide.size + 1;
    int min = Math.min(root.data,Math.min(leftSide.min,rightSide.min));
    int max = Math.max(root.data,Math.max(leftSide.max,rightSide.max));

    if (root.data <= leftSide.max || root.data >= rightSide.min){
        return new Info(false,size,min,max);
    }
    if (leftSide.isBST && rightSide.isBST){
        maxBST =Math.max(maxBST,size);
        return  new Info(true,size,min,max);


    }
    return  new Info(false,size,min,max);

    }

    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(20);
        root.right=new Node(60);
        root.right.left = new Node(45);
        root.right.right =new Node(70);
        root.right.right.left = new Node(65);
        root.right.right.right = new Node(80);


        Info info = largestBSt(root);
        System.out.println("The size od the tree "+ maxBST);
    }}

