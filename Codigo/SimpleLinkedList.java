
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

	public void insertarCabeza(I valor) {
        Node<I> nuevoNodo = new Node<>(valor);
		nuevoNodo.setNext(this.cabeza);
        cabeza = nuevoNodo;
	}
    
    
    
    public void insertarCola(I valor) {
        Node<I> nuevoNodo = new Node<>(valor);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Node<I> actual = this.cabeza;
            while (actual.getNext() != null) {
                actual = actual.getNext();
            }
            actual.setNext(nuevoNodo);
        }
    }




    public int buscar(I valor) {
        Node<I> actual = cabeza;
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
        
        public boolean actualizar(I nuevo, I viejo) {
        Node<I> actual = cabeza;
        while (actual != null) {
            if (actual.getDatos().equals(viejo)) {
                actual.setDatos(nuevo);
                return true;
            }
            actual = actual.getNext();
        }
        return false;
}
    public boolean eliminarNodo(I valor) {
        if (cabeza == null){
            return false;
        }

        if (cabeza.getNext() == null){
            if (cabeza.getDatos().equals(valor)){
                cabeza = null;
                return true;
            }
            return false;
        }

        Node<I> actual = cabeza;
        Node<I> anterior = cabeza.getNext();

        while (actual != null) {
            if (actual.getNext().getDatos().equals(valor)){
                if (anterior!= null){
                    anterior.setNext(null);
                }
                else {
                    anterior.setNext(actual.getNext());
                }
                return true;
            }
            anterior = actual;
            actual = actual.getNext();
        }
          return false;  
    }
        
}

        
    



