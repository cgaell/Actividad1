package Codigo;

public class DataTypeExamples {
    
    public void ejemploListaSimple() {
        SimpleLinkedList<String> listaCadena = new SimpleLinkedList<>();
        listaCadena.insertarCabeza("Arturo");
        listaCadena.insertarCola("Betty");
        listaCadena.insertarCabeza("Carlos");
        listaCadena.insertarCola("Diana");

        System.out.println("Lista Simple de Cadena:");
        listaCadena.mostrarLista();
        System.out.println(" ");
   
        SimpleLinkedList<Integer> listaEnteros = new SimpleLinkedList<>();
        listaEnteros.insertarCabeza(10);
        listaEnteros.insertarCabeza(20);
        listaEnteros.insertarCabeza(30);
        listaEnteros.insertarCola(40);

        System.out.println("Lista Simple de Numeros Enteros:");
        listaEnteros.mostrarLista();
        System.out.println(" ");

        SimpleLinkedList<Double> listaNumeroDoble = new SimpleLinkedList<>();
        listaNumeroDoble.insertarCabeza(11.11);
        listaNumeroDoble.insertarCola(22.22);
        listaNumeroDoble.insertarCabeza(33.33);
        listaNumeroDoble.insertarCabeza(44.44);

        System.out.println("Lista Simple de Numeros Dobles:");
        listaNumeroDoble.mostrarLista();

    }

    public void ejemploListaDoble() {
        DoubleLinkedList<String> listaCadena = new DoubleLinkedList<>();
        listaCadena.insertarCabeza("A");
        listaCadena.insertarCabeza("B");
        listaCadena.insertarCabeza("C");
        listaCadena.insertarCola("D");

        System.out.println("Lista Simple de Cadena (Izq a Der):");
        listaCadena.mostrarLista();
        System.out.println("Lista Simple de Cadena (Der a Izq):");
        listaCadena.mostrarReversa();
        System.out.println(" ");
   
        DoubleLinkedList<Integer> listaEnteros = new DoubleLinkedList<>();
        listaEnteros.insertarCabeza(10);
        listaEnteros.insertarCola(20);
        listaEnteros.insertarCabeza(30);
        listaEnteros.insertarCola(40);

        System.out.println("Lista Simple de Numeros Enteros (Izq a Der):");
        listaEnteros.mostrarLista();
        System.out.println("Lista Simple de Numeros Enteros (Der a Izq):");
        listaEnteros.mostrarReversa();
        System.out.println(" ");

        DoubleLinkedList<Double> listaNumeroDoble = new DoubleLinkedList<>();
        listaNumeroDoble.insertarCabeza(11.11);
        listaNumeroDoble.insertarCola(22.22);
        listaNumeroDoble.insertarCabeza(33.33);
        listaNumeroDoble.insertarCola(44.44);

        System.out.println("Lista Simple de Numeros Dobles (Izq a Der):");
        listaNumeroDoble.mostrarLista();
        System.out.println("Lista Simple de Numeros Enteros (Der a Izq):");
        listaNumeroDoble.mostrarReversa();

    }

    public void ejemploListaCircular() {
        DoubleCircularLinkedList<String> listaCadena = new DoubleCircularLinkedList<>();
        listaCadena.insertarCabeza("A");
        listaCadena.insertarCabeza("B");
        listaCadena.insertarCabeza("C");
        listaCadena.insertarCola("D");

        System.out.println("Lista Circular Doble de Cadena:");
        listaCadena.mostrarLista();
        listaCadena.mostrarReversa();
        System.out.println(" ");

        DoubleCircularLinkedList<Integer> listaEnteros = new DoubleCircularLinkedList<>();
        listaEnteros.insertarCabeza(10);
        listaEnteros.insertarCola(20);
        listaEnteros.insertarCabeza(30);
        listaEnteros.insertarCola(40);

        System.out.println("Lista Circular Doble de Numeros Enteros:");
        listaEnteros.mostrarLista();
        listaEnteros.mostrarReversa();
        System.out.println(" ");

        DoubleCircularLinkedList<Double> listaNumeroDoble = new DoubleCircularLinkedList<>();
        listaNumeroDoble.insertarCabeza(11.11);
        listaNumeroDoble.insertarCola(22.22);
        listaNumeroDoble.insertarCabeza(33.33);
        listaNumeroDoble.insertarCola(44.44);

        System.out.println("Lista Circular de Numeros Dobles:");
        listaNumeroDoble.mostrarLista();
        listaNumeroDoble.mostrarReversa();

    }
}
