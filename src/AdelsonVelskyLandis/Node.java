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
        g.setColor(Color.WHITE);
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
        updateDepthBalance();
        //if disbalance then apply appropriate rotation
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
