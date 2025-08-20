package Codigo;

public class Queue<T> {
    public static final int CAPACITY = 1000;

    private T[] datos;
    private int size = 0;

    public Queue() {
        datos = (T[]) new Object[CAPACITY];
    }



    public boolean isEmpty() {
        return (this.size == 0);
    }

    public int size() {
        return (this.size);
    }

    public void push(T doc) {
        // agrega en el tope de la cola el valor correspondiente
        this.datos[this.size] = doc;
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