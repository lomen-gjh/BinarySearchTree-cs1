package AdelsonVelskyLandis;

import java.awt.*;

public class AVL {
    Node root;
    public AVL(){
        root=null;
    }
    public void insert(int d){
        if (root==null)
            root=new Node(d);
        else
        {
            Node fakeParent=new Node(-1000);
            fakeParent.right=root;
            root.insert(d,fakeParent);
            root=fakeParent.right;
        }
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
    public void drawAVL(Graphics g,int x, int y){
        g.clearRect(0,0,600,400);
        if (root!=null){
            root.drawNode(g,x,y);
        }
    }
}
