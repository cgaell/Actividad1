package Codigo;
import Codigo.SimpleLinkedList;
import Codigo.DoubleLinkedList;
import Codigo.DoubleCircularLinkedList;
import Codigo.Contacto;
import java.util.*;


public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        limpiar();

        int tipodelista = 0;
        do {
            try {
                System.out.println("--- MENU ---");
                System.out.println("Que quisieras hacer?");
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

                switch (tipodelista) {
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
                System.out.println("---MENU LISTA SIMPLE---");
                System.out.println("0. Regresar al menu principal");
                System.out.println("1. Insertar contacto al principio de la lista");
                System.out.println("2. Insertar contacto al final de la lista");
                System.out.println("3. Buscar contacto");
                System.out.println("4. Borrar contacto");
                System.out.println("5. Actualizar contacto");
                System.out.println("6. Imprimir lista de contactos");
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
                        direccion = scanner.nextLine(); // Usar la variable ya declarada
                        nuevoContacto = new Contacto(nombre, telefono, direccion);
                        lista.insertarCola(nuevoContacto);
                        System.out.println("Contacto agregado");
                        break;
                    case 3:
                        System.out.print("Ingrese el nombre del contacto a buscar: ");
                        String buscarNombre = scanner.nextLine();
                        int posicion = lista.buscar(new Contacto(buscarNombre, "", ""));
                        if (posicion == -1) {
                            System.out.println("Contacto no encontrado.");
                        } else {
                            System.out.println("Contacto encontrado en la posicion: " + posicion);
                        }
                        break;
                    case 4:
                        System.out.println("Ingrese el contacto a eliminar: ");
                        String eliminarNombre = scanner.nextLine();
                        Contacto contactoEliminar = new Contacto(eliminarNombre, "", "");
                        lista.eliminarNodo(contactoEliminar);
                        System.out.println("Contacto eliminado");
                        break;
                    case 5:
                        System.out.println("Ingrese el contacto a actualizar: ");
                        String viejoNombre = scanner.nextLine();
                        System.out.println("Ingrese el nuevo nombre del contacto: ");
                        String nuevoNombre = scanner.nextLine();
                        System.out.println("Ingrese el nuevo telefono del contacto: ");
                        String nuevoTelefono = scanner.nextLine();
                        System.out.println("Ingrese la nueva direccion del contacto: ");
                        String nuevaDireccion = scanner.nextLine();
                        Contacto nuevoContactoActualizado = new Contacto(nuevoNombre, nuevoTelefono, nuevaDireccion);
                        lista.actualizar(new Contacto(viejoNombre, "", ""), nuevoContactoActualizado);
                        break;
                    case 6:
                        lista.mostrarLista();
                        break;
                    default:
                        System.out.println("Elije una opcion valida");
                }
            } catch (Exception e) {
                e.printStackTrace();
                scanner.nextLine();
                opcion = -1;
                System.out.println("Opcion no valida. Intente de nuevo.");
                pausar();
            }
            pausar();
            limpiar();
        } while (opcion != 0);
    }

private static void menuListaDoble(){
        DoubleLinkedList<Contacto> lista = new DoubleLinkedList<>();
        int opcion = 0;
        do {
            try{
                System.out.println("---MENU LISTA DOBLE---");
                System.out.println("0. Regresar al menu principal");
                System.out.println("1. Insertar contacto al principio de la lista");
                System.out.println("2. Insertar contacto al final de la lista");
                System.out.println("3. Buscar contacto");
                System.out.println("4. Borrar contacto");
                System.out.println("5. Actualizar contacto");
                System.out.println("6. Imprimir lista de contactos");
                System.out.println("7. Imprimir lista de contactos en reversa");
                System.out.print("Seleccione una opcion: ");
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 0:
                        System.out.println("Regresando al menu principal...");
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
                        direccion = scanner.nextLine(); // Usar la variable ya declarada
                        nuevoContacto = new Contacto(nombre, telefono, direccion);
                        lista.insertarCola(nuevoContacto);
                        System.out.println("Contacto agregado");
                        break;
                    case 3:
                        System.out.print("Ingrese el nombre del contacto a buscar: ");
                        String buscarNombre = scanner.nextLine();
                        int posicion = lista.buscar(new Contacto(buscarNombre, "", ""));
                        if (posicion == -1) {
                            System.out.println("Contacto no encontrado.");
                        } else {
                            System.out.println("Contacto encontrado en la posicion: " + posicion);
                        }
                        break;
                    case 4:
                        System.out.println("Ingrese el contacto a eliminar: ");
                        String eliminarNombre = scanner.nextLine();
                        Contacto contactoEliminar = new Contacto(eliminarNombre, "", "");
                        lista.eliminarNodo(contactoEliminar);
                        System.out.println("Contacto eliminado");
                        pausar();
                        break;

                    case 5:
                        System.out.println("Ingrese el contacto a actualizar: ");
                        String viejoNombre = scanner.nextLine();
                        System.out.println("Ingrese el nuevo nombre del contacto: ");
                        String nuevoNombre = scanner.nextLine();
                        System.out.println("Ingrese el nuevo telefono del contacto: ");
                        String nuevoTelefono = scanner.nextLine();
                        System.out.println("Ingrese la nueva direccion del contacto: ");
                        String nuevaDireccion = scanner.nextLine();
                        Contacto actualizadoContacto = new Contacto(nuevoNombre, nuevoTelefono, nuevaDireccion);
                        lista.actualizar(new Contacto(viejoNombre, "", ""), actualizadoContacto);
                        break;      

                    case 6:
                        lista.mostrarLista();
                        pausar();
                        break;

                    case 7:
                        lista.mostrarReversa();
                        pausar();
                        break;
                    default:
                        opcion = -1;
                        System.out.println("Opcion no valida");
                        pausar();
                        
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    scanner.nextLine();
                    opcion = -1;
                    System.out.println("Opcion no valida. Intente de nuevo.");
                    pausar();
                }
                pausar();
                limpiar();
            } while ((opcion!= 0));
                
        }
        private static void menuListaCircular(){
        DoubleCircularLinkedList<Contacto> lista = new DoubleCircularLinkedList<>();
        int opcion = 0;
        do {
            try{

                System.out.println("---MENU LISTA CIRCULAR---");
                System.out.println("0. Regresar al menu principal");
                System.out.println("1. Insertar contacto al principio de la lista");
                System.out.println("2. Insertar contacto al final de la lista");
                System.out.println("3. Buscar contacto en la lista");
                System.out.println("4. Eliminar contacto de la lista");
                System.out.println("5. Actualizar contacto en la lista");
                System.out.println("6. Mostrar lista");
                System.out.println("7. Mostrar lista en orden inverso");
                System.out.print("Seleccione una opcion: ");
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 0:
                    System.out.println("Regresando al menu principal...");
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
                        direccion = scanner.nextLine(); // Usar la variable ya declarada
                        nuevoContacto = new Contacto(nombre, telefono, direccion);
                        lista.insertarCola(nuevoContacto);
                        System.out.println("Contacto agregado");
                        break;
                    case 3:
                    System.out.print("Ingrese el nombre del contacto a buscar: ");
                        String buscarNombre = scanner.nextLine();
                        int posicion = lista.buscar(new Contacto(buscarNombre, "", ""));
                        if (posicion == -1) {
                            System.out.println("Contacto no encontrado.");
                        } else {
                            System.out.println("Contacto encontrado en la posicion: " + posicion);
                        }
                        break;
                    case 4:
                    System.out.println("Ingrese el contacto a eliminar: ");
                        String eliminarNombre = scanner.nextLine();
                        Contacto contactoEliminar = new Contacto(eliminarNombre, "", "");
                        lista.eliminarNodo(contactoEliminar);
                        System.out.println("Contacto eliminado");
                        pausar();
                        break;
                    case 5:
                        System.out.println("Ingrese el contacto a actualizar: ");
                        String viejoNombre = scanner.nextLine();
                        System.out.println("Ingrese el nuevo nombre del contacto: ");
                        String nuevoNombre = scanner.nextLine();
                        System.out.println("Ingrese el nuevo telefono del contacto: ");
                        String nuevoTelefono = scanner.nextLine();
                        System.out.println("Ingrese la nueva direccion del contacto: ");
                        String nuevaDireccion = scanner.nextLine();
                        Contacto actualizadoContacto = new Contacto(nuevoNombre, nuevoTelefono, nuevaDireccion);
                        lista.actualizar(new Contacto(viejoNombre, "", ""), actualizadoContacto);
                        break;
                    case 6:
                     lista.mostrarLista();
                     System.out.println("(vuelve a la cabeza)");
                        pausar();
                        break;
                    case 7:
                    lista.mostrarReversa();
                    System.out.println("(vuelve a la cola)");
                        pausar();
                        break;
                    default:
                    opcion = -1;
                    System.out.println("Opcion no valida");
                    pausar();

                }
            } catch (Exception e) {
                e.printStackTrace();
                scanner.nextLine();
                opcion = -1;
                System.out.println("Opcion no valida");
                pausar();
            }
            pausar();
            limpiar();
        } while (opcion != 0);
    }
    private static void pausar() {
        System.out.println("");
        System.out.println("");
        System.out.println("Presiona Enter para poder continuar");
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void limpiar() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    private static void ejemplosListaSimple() {
        DataTypeExamples ejemplo = new DataTypeExamples();
        ejemplo.ejemploListaSimple();
        pausar();
        limpiar();
    }

    private static void ejemplosListaDoble() {
        DataTypeExamples ejemplo = new DataTypeExamples();
        ejemplo.ejemploListaDoble();
        pausar();
        limpiar();
    }

    private static void ejemplosListaCircular() {
        DataTypeExamples ejemplo = new DataTypeExamples();
        ejemplo.ejemploListaCircular();
        pausar();
        limpiar();
    }

}
