package Actividad1.Actividad1.Codigo;
import java.util.*;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        limpiar();

        int tipodelista;
        do {
            try {
                System.out.println("--- MENU ---");
                System.out.println("Que tipo de lista usaras?");
                System.out.println("1. Usar Lista Simple");
                System.out.println("2. Usar Lista Doble");
                System.out.println("3. Usar Lista Circular");
                System.out.println("4. Ejemplos Lista Simple");
                System.out.println("5. Ejemplos Lista Doble");
                System.out.println("6. Ejemplos Lista Circular");
                System.out.println("7. Salir");
                System.out.print("Seleccione una opcion:  ");
                tipodelista= scanner.nextInt();
                scanner.nextLine();

                switch (args) {
                    case 1:
                        limpiar();
                        menuListaSimple();

                    case 2:
                        limpiar();
                        menuListaDoble();
                        break;

                    case 3:
                        limpiar();
                        menuListaCircular();
                        break;

                    case 4:
                        limpiar();
                        ejemplosListaSimple();
                        break;

                    case 5:
                        limpiar();
                        ejemplosListaDoble();
                        break;

                    case 6:
                        limpiar();
                        ejemplosListaCircular();
                        break;

                    case 7:
                        System.out.println("Adiosss...");
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Opcion no valida");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese un numero valido.");
                scanner.nextLine(); // Limpiar el buffer
            }
        } while (tipodelista != 7);

    }

    private static void menuListaSimple(){
        SimpleLinkedList<Contacto> lista = new SimpleLinkedList<>();
        int opcion = 0;
        do {
            try{
                System.out.println("---MENU LISTA SIMPLE");
                System.out.println("0. Regresar al menu principal");
                System.out.println("1. Insertar elemento al principio de la lista");
                System.out.println("2. Insertar elemento al final de la lista");
                System.out.println("3. Buscar elemento");
                System.out.println("4. Borrar elemento");
                System.out.println("5. Actualizar elemento");
                System.out.println("6. Imprimir lista");
                System.out.print("Seleccione una opcion: ");
                opcion = scanner.nextInt();
                scanner.nextLine();


                switch (opcion) {
                    case 0:
                        limpiar();
                        break;
                    case 1:
                        System.out.print("Ingrese el nombre del contacto: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Ingrese el telefono del contacto: ");
                        String telefono = scanner.nextLine();
                        System.out.println("Ingrese la direccion del contacto: ");
                        String direccion = scanner.nextLine();
                        Contacto nuevoContacto = new Contacto(nombre, telefono, direccion);
                        lista.insertarCabeza(nuevoContacto);
                        System.out.println("Contacto agregado");
                        break;
                    case 2:
                        System.out.print("Ingrese el nombre del contacto: ");
                        nombre = scanner.nextLine();
                        System.out.print("Ingrese el telefono del contacto: ");
                        telefono = scanner.nextLine();
                        System.out.println("Ingrese la direccion del contacto: ");
                        String direccion = scanner.nextLine();
                        nuevoContacto = new Contacto(nombre, telefono, direccion);
                        lista.insertarCola(nuevoContacto);
                        break;
                    case 3:
                        System.out.print("Ingrese el nombre del contacto a buscar: ");
                        String buscarNombre = scanner.nextLine();
                        int posicion = lista.buscar(new Contacto(buscarNombre, ""));
                        if (posicion == -1) {
                            System.out.println("Contacto no encontrado.");
                        } else {
                            System.out.println("Contacto encontrado en la posicion: " + posicion);
                        }
                        break;
                    case 4:
                        // Implementar borrar elemento
                        break;
                    case 5:
                        // Implementar actualizar elemento
                        break;
                    case 6:
                        lista.mostrarLista();
                        break;
                    default:
                        System.out.println("Opcion no valida");
                }
            }
        }
    }
}