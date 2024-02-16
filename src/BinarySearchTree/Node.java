package BinarySearchTree;

public class Node {
    int data;
    Node left, right;
    public Node(int d){
        data=d;
        left=null;
        right=null;
    }
    public void insert(int d){
        if (d>data){
            if (right==null)
                right=new Node(d);
            else{
                right.insert(d);
            }
        }
        if (d<data){
            if (left==null){
                left=new Node(d);
            }
            else{
                left.insert(d);
            }
        }
    }
    public void inorder(){
        if (left!=null)
            left.inorder();
        System.out.print(data+" ");
        if (right!=null)
            right.inorder();
    }
    public void preorder(){
        System.out.print(data+" ");
        if (left!=null)
            left.preorder();
        if (right!=null)
            right.preorder();
    }
    public void postorder(){
        if (left!=null)
            left.postorder();
        if (right!=null)
            right.postorder();
        System.out.print(data+" ");
    }
}
