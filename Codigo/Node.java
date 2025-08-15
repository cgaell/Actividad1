package Actividad1.Actividad1.Codigo;

public class Node<I> {
    I datos;
    Node<I> siguiente;
    Node<I> anterior;

    public Node(I datos, Node<I> siguiente, Node<I> anterior) {
        this.datos = datos;
        this.siguiente = null;
        this.anterior = null;
    }
    public Node(I datos) {
        this.datos = datos;
        
    }
}
