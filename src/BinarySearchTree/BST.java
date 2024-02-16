package BinarySearchTree;
import myQueue.*;

import java.util.Vector;

public class BST {
    Node root;
    public BST(){
        root=null;
    }
    public void insert(int d){
        if (root==null)
            root=new Node(d); //Create the new root
        else
            root.insert(d); //run insert on existing root
    }
    public void inorder(){
        if (root!=null)
            root.inorder();
        System.out.println();
    }
    public void preorder(){
        if (root!=null)
            root.preorder();
        System.out.println();
    }
    public void postorder(){
        if (root!=null)
            root.postorder();
        System.out.println();
    }

    public void bfs(){
        //Create a Queue that contains BinarySearchTreee.Node as data
        Queue<Node> q=new Queue<>();
        q.enqueue(root);
        while(!q.isEmpty()){
            q.enqueue(q.head.data.left);
            q.enqueue(q.head.data.right);
            System.out.print(q.dequeue().data.data+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        BST b=new BST();
        b.insert(50);
        b.insert(42);
        b.insert(-5);
        b.insert(45);
        b.insert(90);
        b.insert(80);
        b.insert(99);
        b.inorder();
        b.preorder();
        b.postorder();
    }
}
