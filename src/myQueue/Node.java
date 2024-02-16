package myQueue;

//Node class utilizes Java generic type
public class Node<T> {
    public T data;
    Node<T> next; //The neighbor will also have the same generic data type
    public Node(T data){
        this.data=data;
        next=null;
    }
}
