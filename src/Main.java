import BinarySearchTree.*;
import myQueue.*;
public class Main {
    public static void main(String[] args) {
        BST tree=new BST();
        tree.insert(50);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);
        tree.insert(25);
        tree.insert(45);
        tree.bfs();

        //Java generic types for use of the data structure with different data types
        Queue<String> patients=new Queue<>();
        patients.enqueue("Misko");
        patients.enqueue("Helga");

    }
}
