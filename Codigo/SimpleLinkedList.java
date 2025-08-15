
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
}


