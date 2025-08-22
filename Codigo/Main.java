package Codigo;

import java.util.*;

public class Main {

    // Creamos las estructuras de datos para el historial y los procesos
    private static Stack<SimpleLinkedList<String>> historial = new Stack<>();
    private static Queue<SimpleLinkedList<String>> procesosEnCola = new Queue<>();

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

       // Ciclo del menu principal, en caso de que el usuario no haga caso o quiera hacer otra accion, se repetira indefinidamente hasta que quiera salir
        while (1 > 0) {
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
                    System.out.println("No encontre esa opcion, Ingrese algo nuevamente");
            }
        }
    }


    private static void realizarProceso(Scanner scanner) {
    int cantidad = 0;
    // Pedir cuántos procesos se van a agregar
    while (true) {
        System.out.print("¿Cuántos procesos deseas agregar?: ");
        try {
            cantidad = Integer.parseInt(scanner.nextLine());
            if (cantidad < 1) {
                System.out.println("Debes ingresar un número mayor a 0");
                continue;
            }
            break;
        } catch (NumberFormatException e) {
            System.out.println("Oye, no acepto otra cosa que no sea números");
        }
    }

    // Bucle para ingresar los nombres de los procesos
    for (int i = 1; i <= cantidad; i++) {
        System.out.print("Ingresa el nombre del proceso " + i + ": ");
        String proceso = scanner.nextLine();

        // Crear la lista enlazada para el proceso
        SimpleLinkedList<String> procesoLista = new SimpleLinkedList<>();
        procesoLista.insertarCabeza(proceso);

        // Guardar en historial y en la cola
        historial.push(procesoLista);
        procesosEnCola.push(procesoLista); // aquí usamos push() porque es Queue

        System.out.println("Proceso '" + proceso + "' añadido al historial y a la cola");
    }
    System.out.println(); // salto de línea al terminar
}

    
    private static void ejecutarProceso() {
    try {
        SimpleLinkedList<String> procesoLista = procesosEnCola.pop();
        if (procesoLista != null) {
            System.out.println("Ejecutando proceso: " + procesoLista.getCabeza().getDatos());
        }
        System.out.println();
    } catch (Exception e) {
        System.out.println("Error al ejecutar el proceso: " + e.getMessage());
        System.out.println();
    }
}
    
       private static void mostrarHistorial() {
    if (historial.isEmpty()) {
        System.out.println("No hay procesos");
    } else {
        System.out.println("=== Historial de procesos ===");
        // Recorremos la pila "temporalmente" sacando cada elemento
        Stack<SimpleLinkedList<String>> temp = new Stack<>();

        try {
            while (!historial.isEmpty()) {
                SimpleLinkedList<String> proceso = historial.pop();
                proceso.mostrarLista();
                temp.push(proceso); // guardamos en temporal para no perder el historial
            }

            // Volvemos a llenar la pila original
            while (!temp.isEmpty()) {
                historial.push(temp.pop());
            }
        } catch (Exception e) {
            System.out.println("Error al mostrar historial: " + e.getMessage());
        }
    }
    System.out.println();
}

    
    private static void deshacerUltimoProceso() {
        try {
            // Eliminamos el ultimo ingreso del usuario de la lista enlazada
            SimpleLinkedList<String> procesoDeshecho = historial.pop();
            System.out.println("Ultimo proceso eliminado: " + procesoDeshecho.getCabeza().getDatos());
        } catch (Exception e) {
            System.out.println("Error al eliminar el proceso: " + e.getMessage());
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
                }
                System.out.println();
            } else {
                System.out.println("No hay procesos en segundo plano");
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println("Error al mostrar los procesos: " + e.getMessage());
        }
    }
    
}