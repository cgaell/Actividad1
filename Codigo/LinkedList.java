package Actividad1.Actividad1.Codigo;

import java.util.List;

public class LinkedList<I> {
    private Node<I> cabeza;

    public LinkedList() {
        this.cabeza = null;
    }
    public LinkedList(Node<I> cabeza){
        this.cabeza = cabeza;
    }
    public Node<I> getCabeza() {
        return cabeza;
    }

    public void insertarCabeza(I datos) {
        Node<I> nuevoNodo = new Node<>(datos, cabeza);
        cabeza = nuevoNodo;
        }
    }

