
package Codigo;

public class SimpleLinkedList<Contacto> {
	private Node<Contacto> cabeza;

	public SimpleLinkedList() {
		this.cabeza = null;
	}

	public SimpleLinkedList(Node<Contacto> cabeza){
		this.cabeza = cabeza;
	}

	public Node<Contacto> getCabeza() {
		return cabeza;
	}

	public void insertarCabeza(Contacto valor) {
        Node<Contacto> nuevoNodo = new Node<>(valor);
		nuevoNodo.setNext(this.cabeza);
        cabeza = nuevoNodo;
	}
    
    
    
    public void insertarCola(Contacto valor) {
        Node<Contacto> nuevoNodo = new Node<>(valor);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Node<Contacto> actual = this.cabeza;
            while (actual.getNext() != null) {
                actual = actual.getNext();
            }
            actual.setNext(nuevoNodo);
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

    public int buscar(Contacto valor) {
        Node<Contacto> actual = cabeza;
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

        public boolean actualizar(Contacto nuevo, Contacto viejo) {
        Node<Contacto> actual = cabeza;
        while (actual != null) {
            if (actual.getDatos().equals(viejo)) {
                actual.setDatos(nuevo);
                return true;
            }
            actual = actual.getNext();
        }
        return false;
}
    public boolean eliminarNodo(Contacto valor) {
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

        Node<Contacto> actual = cabeza;
        Node<Contacto> anterior = cabeza.getNext();

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

        
    



