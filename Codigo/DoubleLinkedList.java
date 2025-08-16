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
   
    

    public void insertarCabeza(I valor) {
        Node<I> nuevoNodo = new Node<>(valor);;
        if (this.cabeza == null) {

            this.cola = nuevoNodo;
            this.cabeza = nuevoNodo;

        } else {
            nuevoNodo.setNext(this.cabeza);
            this.cabeza.setAnterior(nuevoNodo);
            this.cabeza = nuevoNodo;

        }
    }
    
    public void insertarCola(I valor) {
        Node<I> nuevoNodo = new Node<>(valor);
        if (this.cabeza == null) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        } else {
            nuevoNodo.setAnterior(this.cola);
            this.cola.setNext(nuevoNodo);
            this.cola = nuevoNodo;
        }
        
    }

    public void mostrarLista() {
        Node<I> actual = this.cabeza;
        while (actual != null) {
            System.out.print(actual.getDatos());
            if (actual.getNext() != null) {
                System.out.print(" <-> ");
            }
            actual = actual.getNext();
        }
        System.out.println();
    }


    public void mostrarReversa() {
    Node<I> actual = this.cola;
    while (actual != null) {
        System.out.print(actual.getDatos());
        if (actual.getAnterior() != null) {
            System.out.print(" <-> ");
        }
    }
    System.out.println();
}
public int buscar( I valor) {
    Node<I> actual = this.cabeza;
    int posicion = 1;
    while (actual != null) {
        if (actual.getDatos().equals(valor)) {
            System.out.println("Dato encontrado: " + valor);
            return posicion;
        }
        actual = actual.getNext();
        posicion++;
    }
    return -1;
}

    public boolean actualizar(I viejo, I nuevo) {
        Node<I> actual = this.cabeza;
        while (actual != null) {
            if (actual.getDatos().equals(viejo)) {
                actual.setDatos(nuevo);
                return true;
            }
            actual = actual.getNext();
        }
        return false;
    }
    public void borrar(I valor) {
        if (cabeza == null) {
            return;
        }
        if (cabeza.getNext() == null) {
            if (cabeza.getDatos().equals(valor)) {
                cabeza = null;            
            }
                return;
        }
        Node<I> actual = cabeza;
        Node<I> anterior = null;

        while (actual != null) {
            if (actual.getDatos().equals(valor)) {
                if (anterior != null) {
                    anterior.setNext(actual.getNext());
                }
                return;
            }
            anterior = actual;
            actual = actual.getNext();
        }
    }
}



