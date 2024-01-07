public class DeleteNode {
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
 public static Node delete(Node root,int val){
        if (root.data > val){
            root.left = delete(root.left, val);
        } else if (root.data < val) {
            root.right = delete(root.right,val);
            
        }
        else{
            //First Case
            if (root.left == null &&  root.right == null){
                return null;
            }
            //Second Case
            if (root.left == null){
                return root.right;
                
            } else if (root.right == null) {
                return root.left;

            }
           Node Is = findIs(root.right);
            root.data = Is.data;
            root.right = delete(root.right,Is.data);


        }

        return  root;
     }

    public static Node findIs(Node root){
        while (root.left != null){
            root = root.left;
        }
        return root;

     
 }


    public static void main(String[] args) {
        int val[]={8,5,3,1,4,6,10,11,14};
        Node root =null;

        for (int i =0; i< val.length;i++){
            root =insert(root,val[i]);

        }
        inOrder(root);
        System.out.println();

      root =delete(root,5);

        inOrder(root);


    }
}


