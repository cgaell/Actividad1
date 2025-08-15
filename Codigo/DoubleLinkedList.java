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
    public void mostrarReversa() {
    Node<I> actual = cola;
    while (actual != null) {
        System.out.print(actual.datos + " ");
        actual = actual.anterior;
    }
    System.out.println();
}
public void eliminarCabeza() {
        if (cabeza != null) {
            cabeza = cabeza.siguiente;
            if (cabeza != null) {
                cabeza.anterior = null;
            } else {
                cola = null; // Si la lista queda vacía, actualizar cola
            }
        }
    }

    public void eliminarCola() {
        if (cola != null) {
            cola = cola.anterior;
            if (cola != null) {
                cola.siguiente = null;
            } else {
                cabeza = null; // Si la lista queda vacía, actualizar cabeza
            }
        }
    }
    public void buscar(I datos) {
        Node<I> actual = cabeza;
        while (actual != null) {
            if (actual.datos.equals(datos)) {
                System.out.println("Dato encontrado: " + datos);
                return;
            }
            actual = actual.siguiente;
        }
        System.out.println("Dato no encontrado: " + datos);
    }
    

}

