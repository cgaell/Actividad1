package Actividad1.Actividad1.Codigo;
import Actividad1.Actividad1.Codigo.LinkedList;

public class Main {
    public static void main(String[] args) {
        // Crear una lista de tipo String
        LinkedList<String> lista = new LinkedList<>();

        // Insertar al inicio
        lista.insertarCabeza("C"); // Lista: C
        lista.insertarCabeza("B"); // Lista: B C
        lista.insertarCabeza("A"); // Lista: A B C

        // Mostrar la lista actual
        System.out.print("Lista después de insertar por cabeza: ");
        lista.mostrarLista(); // Esperado: A B C

        System.out.println();

        // Insertar al final
        lista.insertarCola("D"); // Lista: A B C D
        lista.insertarCola("E"); // Lista: A B C D E

        // Mostrar la lista actual
        System.out.print("Lista después de insertar por cola: ");
        lista.mostrarLista(); // Esperado: A B C D E

        System.out.println();

        // Si implementaste mostrarReversa, puedes probar también:
        // System.out.print("Lista en reversa: ");
        // lista.mostrarReversa(); // Esperado: E D C B A
    }
}
