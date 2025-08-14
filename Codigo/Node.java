package Actividad1.Actividad1.Codigo;

public class Node<I> {
    I data;
    Node<I> next;

    public Node(I data){
        this.data = data;
        this.next = null;
    }
}
