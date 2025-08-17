package Codigo;


public class DoubleCircularLinkedList<Contacto> {
    private Node<Contacto> cabeza;
    private Node<Contacto> cola;

    public DoubleCircularLinkedList() {
        this.cabeza = null;
        this.cola = null;
    }

    public void insertarCabeza(Contacto valor) {
        Node<Contacto> nuevoNodo = new Node<>(valor);
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

    public void insertarCola(Contacto valor) {
        Node<Contacto> nuevoNodo = new Node<>(valor);
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

        Node<Contacto> actual = cabeza;
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

        Node<Contacto> actual = cola;
        do {
            System.out.print(actual.getDatos());
            actual = actual.getAnterior();
            if (actual != cola) {
                System.out.print(" <-> ");
            }
        } while (actual != cola);
        System.out.println();
    }

    public int buscar(Contacto valor) {
        if (cabeza == null) return -1;

        Node<Contacto> actual = cabeza;
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

    public boolean actualizar(Contacto viejo, Contacto nuevo) {
        if (cabeza == null) return false;

        Node<Contacto> actual = cabeza;
        do {
            if (actual.getDatos().equals(viejo)) {
                actual.setDatos(nuevo);
                return true;
            }
            actual = actual.getNext();
        } while (actual != cabeza);

        return false;
    }

    public void eliminarNodo(Contacto valor) {
        if (cabeza == null) return;

        Node<Contacto> actual = cabeza;

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

    