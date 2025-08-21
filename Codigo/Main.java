package Codigo;

import java.util.*;

public class Main {

    // Creamos las estructuras de datos para el historial y los procesos
    private static Stack<SimpleLinkedList<String>> historial = new Stack<>();
    private static Queue<SimpleLinkedList<String>> procesosEnCola = new Queue<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

       // Ciclo del menu principal, en caso de que el usuario no haga caso o quiera hacer otra accion, se repetira indefinidamente hasta que quiera salir
        while (true) {
            System.out.println("=== HOLA USUARIO ===");
            System.out.println("1. Realizar proceso");
            System.out.println("2. Ejecutar proceso");
            System.out.println("3. Mostrar historial de procesos");
            System.out.println("4. Deshacer último proceso");
            System.out.println("5. Mostrar procesos");
            System.out.println("6. Salir");
            System.out.print("Ingrese una opción: ");
            
            
            try {
                opcion = Integer.parseInt(scanner.nextLine());

                if (opcion < 1 || opcion > 6) {
                    System.out.println("Escribe del 1 al 6, los demas no hacen nada");
                    System.out.println();
                    continue; 
                }

            } catch (NumberFormatException e) {
                System.out.println("Oye, no acepto otra cosa que no sea numeros");
                System.out.println();
                continue; 
            }

            switch (opcion) {
                case 1:
                    realizarProceso(scanner);
                    break;
                case 2:
                    ejecutarProceso();
                    break;
                case 3:
                    mostrarHistorial();
                    break;
                case 4:
                    deshacerUltimoProceso();
                    break;
                case 5:
                    mostrarProcesos();
                    break;
                case 6:
                    System.out.println("Gracias por usarme");
                    scanner.close();
                    return; 
                default:
                    System.out.println("No encontre esa opcion, Ingrese algo nuevamente.");
            }
        }
    }


    private static void realizarProceso(Scanner scanner) {
        System.out.print("Ingrese el nombre del proceso: ");
        String proceso = scanner.nextLine();
        
        // Agregamos lo ingresado dentro de la lista enlazada
        SimpleLinkedList<String> procesoLista = new SimpleLinkedList<>();
        procesoLista.insertarCabeza(proceso);

        // Guardamos el proceso dentro de la fila y de la pila
        historial.push(procesoLista); 
        procesosEnCola.push(procesoLista); 
        
        System.out.println("Proceso '" + proceso + "' añadido al historial y a la cola.");
        System.out.println();
    }

    // 2. Ejecutar proceso
    private static void ejecutarProceso() {
        try {
            // Creamos la lista enlazada para el proceso en ejecución en la cual quitara y almacenara los datos
            SimpleLinkedList<String> procesoLista = procesosEnCola.pop();
            System.out.println("Ejecutando proceso: " + procesoLista.getCabeza().getDatos());
            System.out.println();
        } catch (Exception e) {
            System.out.println("Error al ejecutar el proceso: " + e.getMessage());
            System.out.println();
        }
    }

    
    private static void mostrarHistorial() {
        System.out.println("Historial de procesos:");
        historial.show(); // Muestra las listas enlazadas
        System.out.println();
    }

    
    private static void deshacerUltimoProceso() {
        try {
            // Eliminamos el ultimo ingreso del usuario de la lista enlazada
            SimpleLinkedList<String> procesoDeshecho = historial.pop();
            System.out.println("Último proceso deshecho: " + procesoDeshecho.getCabeza().getDatos());
        } catch (Exception e) {
            System.out.println("Error al deshacer el proceso: " + e.getMessage());
            System.out.println();
        }
    }

    private static void mostrarProcesos() {
        System.out.println("Procesos en cola:");
        try {
            // Revisa si la fila no esta vacía
            if (!procesosEnCola.isEmpty()) {
                // Muestra los procesos que estan dentro de la cola
                Node<SimpleLinkedList<String>> actual = procesosEnCola.datos.getCabeza();
                while (actual != null) {
                    actual.getDatos().mostrarLista(); 
                    actual = actual.getNext();
                    System.out.println();
                }
            } else {
                System.out.println("No hay procesos en la cola.");
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println("Error al mostrar los procesos: " + e.getMessage());
        }
    }
}
