package Codigo;

public class Queue<T> {
    
    private SimpleLinkedList<T> datos;
    

    public Queue() {
        this.datos = new SimpleLinkedList<>();
    }



    public boolean isEmpty() {
        return (this.datos.getCabeza() == null);
    }

    public int size() {
        return (this.size);
    }

    public void push(T com) {
        // agrega en el tope de la cola el valor correspondiente
        this.datos[this.size] = com;
        // aumenta el tamaño de la cola
        this.size++;
    }

    public T pop() throws Exception {
        T resultado = null;
        if (this.isEmpty()) {
            throw new Exception("La cola está vacía");
        }
        resultado = this.datos[0];
        for (int i=0;i<this.size-1;i++){
   
            this.datos[i]=this.datos[i+1];
        }

        this.datos[this.size - 1] = null; // Garbage collector

        this.size--;
        return resultado;
    }

    public T peek() throws Exception {
        T resultado = null;
        if (this.isEmpty()) {
            throw new Exception("La cola está vacía");
        }
        resultado = this.datos[0];
        return resultado;
    }
}