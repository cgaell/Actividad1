package Actividad1.Actividad1.Codigo;


public class DoubleLinkedList<I> {
    private Node<I> cabeza;
    private Node<I> cola;

    public DoubleLinkedList() {
        this.cabeza = null;
        this.cola = null;
    }
    public DoubleLinkedList(Node<I> cabeza, Node<I> cola) {
        this.cabeza = cabeza;
        this.cola = cola;
    }
    public Node<I> getCabeza() {
        return cabeza;
    }

    public Node<I> getCola() {
        return cola;
    }

    public void insertarCabeza(I datos) {
        Node<I> nuevoNodo = new Node<>(datos, cabeza, null);
        if (cabeza == null) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        } else {
            nuevoNodo.siguiente = cabeza;
            cabeza.anterior = nuevoNodo;
            cabeza = nuevoNodo;

        }
    }
    
    public void insertarCola(I datos) {
        Node<I> nuevoNodo = new Node<>(datos);
        if (cabeza == null) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        } else {
            cola.siguiente = nuevoNodo;
            nuevoNodo.anterior = cola;
            cola = nuevoNodo;
        }
        
    }

    public void mostrarLista() {
        Node<I> actual = cabeza;
        while (actual != null) {
            System.out.print(actual.datos + " ");
            actual = actual.siguiente;
        }
    }
}

