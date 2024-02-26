import AdelsonVelskyLandis.AVL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIAVL extends JFrame implements ActionListener {
    AVL avl;
    JPanel north, center;
    JButton insert, delete;
    JTextField data;
    public GUIAVL(){
        setTitle("AVL Tree");
        setSize(600,400);
        setLayout(new BorderLayout());
        avl=new AVL(); //Self-balancing BST
        north=new JPanel();
        center=new JPanel();
        insert=new JButton("Insert");
        delete=new JButton("Delete");
        delete.addActionListener(this);
        data=new JTextField(10);
        north.add(data);
        north.add(insert);
        north.add(delete);
        insert.addActionListener(this);
        add(north,BorderLayout.NORTH);
        add(center,BorderLayout.CENTER);
        setVisible(true);
        setResizable(false);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==insert){
            avl.insert(Integer.parseInt(data.getText()));
            avl.drawAVL(center.getGraphics(),300,50);
        }
        if (e.getSource()==delete){ //Delete the node with the given value
            avl.delete(Integer.parseInt(data.getText()));  //Delete the node with the given value
            avl.drawAVL(center.getGraphics(),300,50); //Redraw the tree
        }
    }

    public static void main(String[] args) {
        GUIAVL window=new GUIAVL();
    }
}
