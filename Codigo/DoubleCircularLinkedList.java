package Actividad1.Actividad1.Codigo;


public class DoubleCircularLinkedList<I> {
    private Node<I> cabeza;
    private Node<I> cola;

    public DoubleCircularLinkedList() {
        this.cabeza = null;
        this.cola = null;
    }

    public void insertarCabeza(I valor) {
        Node<I> nuevoNodo = new Node<>(valor);
        if (cabeza == null) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
            cabeza.setNext(cola);
            cabeza.setAnterior(cola);
            cola.setNext(cabeza);
            cola.setAnterior(cabeza);
        } else {
            nuevoNodo.setNext(cabeza);
            nuevoNodo.setAnterior(cola);
            cabeza.setAnterior(nuevoNodo);
            cola.setNext(nuevoNodo);
            cabeza = nuevoNodo;
        }
    }

    public void insertarCola(I valor) {
        Node<I> nuevoNodo = new Node<>(valor);
        if (cabeza == null) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
            cabeza.setNext(cabeza);
            cabeza.setAnterior(cabeza);
        } else {
            nuevoNodo.setAnterior(cola);
            nuevoNodo.setNext(cabeza);
            cola.setNext(nuevoNodo);
            cabeza.setAnterior(nuevoNodo);
            cola = nuevoNodo;
        }
    }

    public void mostrarLista() {
        if (cabeza == null) return;

        Node<I> actual = cabeza;
        do {
            System.out.print(actual.getDatos());
            actual = actual.getNext();
            if (actual != cabeza) {
                System.out.print(" <-> ");
            }
        } while (actual != cabeza);
        System.out.println();
    }

    public void mostrarReversa() {
        if (cola == null) return;

        Node<I> actual = cola;
        do {
            System.out.print(actual.getDatos());
            actual = actual.getAnterior();
            if (actual != cola) {
                System.out.print(" <-> ");
            }
        } while (actual != cola);
        System.out.println();
    }

    public int buscar(I valor) {
        if (cabeza == null) return -1;

        Node<I> actual = cabeza;
        int posicion = 1;
        do {
            if (actual.getDatos().equals(valor)) {
                System.out.println("Dato encontrado: " + valor);
                return posicion;
            }
            actual = actual.getNext();
            posicion++;
        } while (actual != cabeza);

        return -1;
    }

    public boolean actualizar(I viejo, I nuevo) {
        if (cabeza == null) return false;

        Node<I> actual = cabeza;
        do {
            if (actual.getDatos().equals(viejo)) {
                actual.setDatos(nuevo);
                return true;
            }
            actual = actual.getNext();
        } while (actual != cabeza);

        return false;
    }

    public void borrar(I valor) {
        if (cabeza == null) return;

        Node<I> actual = cabeza;

        do {
            if (actual.getDatos().equals(valor)) {
                if (actual == cabeza && actual == cola) { 
                    // Único nodo
                    cabeza = null;
                    cola = null;
                } else {
                    actual.getAnterior().setNext(actual.getNext());
                    actual.getNext().setAnterior(actual.getAnterior());

                    if (actual == cabeza) {
                        cabeza = actual.getNext();
                    }
                    if (actual == cola) {
                        cola = actual.getAnterior();
                    }
                }
                return;
            }
            actual = actual.getNext();
        } while (actual != cabeza);
    }
}

    