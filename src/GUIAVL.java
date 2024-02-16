import AdelsonVelskyLandis.AVL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIAVL extends JFrame implements ActionListener {
    AVL avl;
    JPanel north, center;
    JButton insert;
    JTextField data;
    public GUIAVL(){
        setTitle("AVL Tree");
        setSize(600,400);
        setLayout(new BorderLayout());
        avl=new AVL(); //Self-balancing BST
        north=new JPanel();
        center=new JPanel();
        insert=new JButton("Insert");
        data=new JTextField(10);
        north.add(data);
        north.add(insert);
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
    }

    public static void main(String[] args) {
        GUIAVL window=new GUIAVL();
    }
}
