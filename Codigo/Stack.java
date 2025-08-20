package Codigo;

public class Stack<T> {
     //asignar la capacidad del arreglo en la pila
    //en este caso es infinito
    public static final int CAPACITY = 1000;


    //inicializar atributos
    private T[] datos;
    private int size = 0;
    public String entrada = "2 + 3 * 4";

    //constructor para inicializar la pila
    public Stack() {
        this.datos = (T[]) new Object[this.CAPACITY];
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }

    public void push(T valor) {
        this.datos[this.size] = valor;
        this.size++;
    }
    
    public T pop() throws Exception {
        T resultado = null;

        //si está vacía la pila regresa una excepción 
        if (this.isEmpty()) {
            throw new Exception("La Pila está vacía");
        }

        this.size--;
        resultado = this.datos[this.size];
        this.datos[this.size] = null; //Garbage collector

        return resultado;
    }

    public void show() {
        for (int i = size - 1; i >= 0; i--) {
            System.out.print(this.datos[i] + " ");
        }
        System.out.println();
    }

    public T peek() throws Exception {

        //si está vacía la pila regresa una excepción
        if (this.isEmpty()) {
            throw new Exception("La Pila está vacía");
        }

        return this.datos[this.size - 1];
    }

}