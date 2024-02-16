package myQueue;

/*Since Queue uses Node with generic type,
the Queue also needs to use generic type*/
public class Queue<T> {
    public Node<T> head, tail;
    public Queue(){
        head=null;
        tail=null;
    }

    public void enqueue(T data){
        if (data==null) return;
        if (head==null) {
            head=new Node<>(data);
            tail=head;
        }
        else{
            tail.next=new Node<>(data);
            tail=tail.next;
        }
    }
    public Node<T> dequeue(){
        if (head==null) return null;
        if (head==tail){
            Node<T> dequeued=head;
            head=null;
            tail=null;
            return dequeued;
        }
        else{
            Node<T> dequeued=head;
            head=head.next;
            return dequeued;
        }
    }

    public boolean isEmpty(){
        return (head==null);
    }
}
