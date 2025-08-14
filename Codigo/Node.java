package Actividad1.Actividad1.Codigo;

public class Node<I> {
    I datos;
    Node<I> siguiente;

    public Node(I datos, Node<I> siguiente) {
        this.datos = datos;
        this.siguiente = null;
    }
    public Node(I datos) {
        this.datos = datos;
    }
}
