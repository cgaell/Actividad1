package Codigo;


public class DoubleLinkedList<Contacto> {
    private Node<Contacto> cabeza;
    private Node<Contacto> cola;

    public DoubleLinkedList() {
        this.cabeza = null;
        this.cola = null;
    }
    public DoubleLinkedList(Node<Contacto> cabeza, Node<Contacto> cola) {
        this.cabeza = cabeza;
        this.cola = cola;
    }
   
    

    public void insertarCabeza(Contacto valor) {
        Node<Contacto> nuevoNodo = new Node<>(valor);
        if (this.cabeza == null) {

            this.cola = nuevoNodo;
            this.cabeza = nuevoNodo;

        } else {
            nuevoNodo.setNext(this.cabeza);
            this.cabeza.setAnterior(nuevoNodo);
            this.cabeza = nuevoNodo;

        }
    }

    public void insertarCola(Contacto valor) {
        Node<Contacto> nuevoNodo = new Node<>(valor);
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
        Node<Contacto> actual = this.cabeza;
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
    Node<Contacto> actual = this.cola;
    while (actual != null) {
        System.out.print(actual.getDatos());
        if (actual.getAnterior() != null) {
            System.out.print(" <-> ");
        }
    }
    System.out.println();
}
public int buscar(Contacto valor) {
    Node<Contacto> actual = this.cabeza;
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

    public boolean actualizar(Contacto viejo, Contacto nuevo) {
        Node<Contacto> actual = this.cabeza;
        while (actual != null) {
            if (actual.getDatos().equals(viejo)) {
                actual.setDatos(nuevo);
                return true;
            }
            actual = actual.getNext();
        }
        return false;
    }
    public void eliminarNodo(Contacto valor) {
        if (cabeza == null) {
            return;
        }
        if (cabeza.getNext() == null) {
            if (cabeza.getNext().equals(valor)) {
                cabeza = null;            
            }
                return;
        }
        Node<Contacto> actual = cabeza;
        Node<Contacto> anterior = null;

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



