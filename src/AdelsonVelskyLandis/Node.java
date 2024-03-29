package AdelsonVelskyLandis;

import java.awt.*;

public class Node {
    int data, balance, depth;
    Node left, right;
    public Node(int d){
        data=d;
        left=null;
        right=null;
        balance=0;
        depth=0;
    }

    public void drawNode(Graphics g, int x , int y){
        if (left!=null){
            g.drawLine(x+10,y+10, x-30, y+50);
            left.drawNode(g, x-40,y+40);
        }
        if (right!=null){
            g.drawLine(x+10,y+10, x+50, y+50);
            right.drawNode(g, x+40, y+40);
        }
        g.setColor(Color.CYAN);
        g.fillRect(x,y,20,20);
        String s=Integer.toString(this.data);
        g.setColor(Color.BLACK);
        g.drawString(s, x+10-g.getFontMetrics().stringWidth(s)/2,y+10);
        String s2=Integer.toString(this.depth)+" "+Integer.toString(this.balance);
        g.drawString(s2, x+10-g.getFontMetrics().stringWidth(s2)/2,y);

    }

    private void updateDepthBalance(){
        if (left!=null && right!=null){
            depth=Math.max(left.depth, right.depth)+1;
            balance=right.depth - left.depth;
        }
        else if (left!=null){
            depth=left.depth+1;
            balance=-left.depth-1;
        }
        else if (right!=null){
            depth= right.depth+1;
            balance= right.depth + 1;
        }
        else {
            balance=0;
            depth=0;
        }
    }
    public void insert(int d, Node parent){
        if (d>data){
            if (right==null)
                right=new Node(d);
            else{
                right.insert(d, this);
            }
        }
        if (d<data){
            if (left==null){
                left=new Node(d);
            }
            else{
                left.insert(d, this);
            }
        }
        updateDepthBalance();
        rebalance(parent);

    }

    public void rebalance(Node parent){
        if (balance>1){  //If leaning to the right
            if (right.balance>0){ //if this.right is leaning to the right
                this.leftRotation(parent);
            }
            else { //if this.right is leaning to the left
                this.rightLeftRotation(parent);
            }
        }
        else if (balance<-1){ //If leaning to the left
            if (left.balance==-1){ // if this.left is leaning to the left
                this.rightRotation(parent);
            }
            else {//If this.left is leaning to the right
                this.leftRightRotation(parent);
            }
        }
    }

    public Node deleteMax(Node parent){
        if (right==null){
            if (parent.data<this.data){
                parent.right=this.left;
            }
            else{
                parent.left=this.left;
            }
            this.left=null; //since this is a replacement node, we want to cut off its connection to the tree.
            parent.updateDepthBalance();
            this.updateDepthBalance();
            return this;
        }
        else{
            Node temp = right.deleteMax(this);
            parent.updateDepthBalance(); //Update parent balance and depth
            this.rebalance(parent); //If there is a disbalance, call appropriate rotation
            return temp;
        }
    }

    public Node deleteMin(Node parent){
        if (left==null){
            if (parent.data<this.data){
                parent.right=this.right;
            }
            else{
                parent.left=this.right;
            }
            this.right=null; //since this is a replacement node, we want to cut off its connection to the tree.
            parent.updateDepthBalance();
            this.updateDepthBalance();
            return this;
        }
        else{
            Node temp = left.deleteMin(this);  //temp stores the result from the recursive call
            parent.updateDepthBalance(); //Update parent balance and depth
            this.rebalance(parent); //If there is a disbalance, call appropriate rotation
            return temp;
        }
    }

    public Node delete(int target, Node parent){
        return null; //placeholder
        //Implement the delete method
        //If the target is found
        //check if the node has 0, 1, or 2 children
        //If the node has 0 children, simply remove the node
        //If the node has 1 child, replace the node with its child
        //If the node has 2 children, replace the node with the maximum node in the left subtree or the minimum node in the right subtree
        //depending on the balance of the tree
        //Call updateDepthBalance and rebalance on the parent of the deleted node

        //if target is not found, call delete on the appropriate child, unless the child is null
    }


    public void rightRotation(Node parent){
        if (parent.data<this.data){
            parent.right=this.left;
        }
        else{
            parent.left=this.left;
        }
        this.left=this.left.right;
        this.updateDepthBalance();
        if (parent.data<this.data){
            parent.right.right=this;
            parent.right.updateDepthBalance();
        }
        else {
            parent.left.right=this;
            parent.left.updateDepthBalance();
        }
        parent.updateDepthBalance();
    }

    public void leftRotation(Node parent){
        if (parent.data<this.data){
            parent.right=this.right;
        }
        else{
            parent.left=this.right;
        }
        this.right=this.right.left;
        this.updateDepthBalance();
        if (parent.data<this.data){
            parent.right.left=this;
            parent.right.updateDepthBalance();
        }
        else {
            parent.left.left=this;
            parent.left.updateDepthBalance();
        }
        parent.updateDepthBalance();
    }
    public void leftRightRotation(Node parent){
        if (parent.data<this.data){
            parent.right=this.left.right;
        }
        else {
            parent.left=this.left.right;
        }
        this.left.right=this.left.right.left;
        this.left.updateDepthBalance();
        if (parent.data<this.data){
            parent.right.left=this.left;
            this.left=parent.right.right;
            this.updateDepthBalance();
            parent.right.right=this;
            parent.right.updateDepthBalance();
        }
        else {
            parent.left.left=this.left;
            this.left=parent.left.right;
            this.updateDepthBalance();
            parent.left.right=this;
            parent.left.updateDepthBalance();
        }
        parent.updateDepthBalance();
    }
    public void rightLeftRotation(Node parent){
        if (parent.data<this.data){
            parent.right=this.right.left;
        }
        else {
            parent.left=this.right.left;
        }
        this.right.left=this.right.left.right;
        this.right.updateDepthBalance();
        if (parent.data<this.data){
            parent.right.right=this.right;
            this.right=parent.right.left;
            this.updateDepthBalance();
            parent.right.left=this;
            parent.right.updateDepthBalance();
        }
        else {
            parent.left.right=this.right;
            this.right=parent.left.left;
            this.updateDepthBalance();
            parent.left.left=this;
            parent.left.updateDepthBalance();
        }
        parent.updateDepthBalance();
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
