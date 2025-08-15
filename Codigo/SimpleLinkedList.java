
package Actividad1.Actividad1.Codigo;

public class SimpleLinkedList<I> {
	private Node<I> cabeza;

	public SimpleLinkedList() {
		this.cabeza = null;
	}

	public SimpleLinkedList(Node<I> cabeza){
		this.cabeza = cabeza;
	}

	public Node<I> getCabeza() {
		return cabeza;
	}

	public void insertarCabeza(I datos) {
        Node<I> nuevoNodo = new Node<>(datos);
		nuevoNodo.siguiente = cabeza;
        cabeza = nuevoNodo;
	}
    public void insertarCola(I datos) {
        Node<I> nuevoNodo = new Node<>(datos);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Node<I> actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
    }
    public void eliminarCabeza() {
        if (cabeza != null) {
            cabeza = cabeza.siguiente;
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
    public void mostrarLista() {
        Node<I> actual = cabeza;
        while (actual != null) {
            System.out.print(actual.datos + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }
}


