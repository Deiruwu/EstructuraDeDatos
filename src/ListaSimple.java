import java.util.Scanner;

public class ListaSimple {
    static Scanner sc = new Scanner(System.in);  // Scanner para recibir entradas del usuario

    // Clase interna Nodo para representar cada elemento de la lista
    class Nodo {
        int dato;  // Valor almacenado en el nodo
        Nodo puntero;  // Puntero al siguiente nodo

        // Constructor para inicializar el nodo con un valor
        Nodo(int valor) {
            dato = valor;
        }
    }

    int tamaño;  // Almacena el tamaño actual de la lista
    Nodo cabeza;  // Referencia al primer nodo de la lista
    Nodo cola;  // Referencia al último nodo de la lista

    // Constructor para inicializar una lista vacía
    ListaSimple() {
        cabeza = null;  // La lista comienza vacía, sin nodos
        tamaño = 0;  // Inicializa el tamaño de la lista a 0
    }

    // Método para insertar un valor al inicio de la lista
    void insertarCabeza(int valor) {
        Nodo nuevoNodo = new Nodo(valor);  // Crea un nuevo nodo con el valor dado
        if (cabeza == null && cola == null) {  // Si la lista está vacía

            // Muestra un mensaje de inserción cuando no hay datos previos
            System.out.println("\n*===================================================================================*");
            System.out.println("\tNo habían datos en la lista. El valor " + valor + " se inserta");
            System.out.println("===================================================================================\n");

            cabeza = nuevoNodo;  // El nuevo nodo se convierte en la cabeza
            cola = nuevoNodo;  // El nuevo nodo también es la cola
            tamaño++;  // Incrementa el tamaño de la lista

            return;  // Termina la ejecución del método
        }

        // Muestra un mensaje de inserción cuando ya hay datos
        System.out.println("\n*=========================================================*");
        System.out.println("\tEl valor " + valor + " se inserta al inicio de la lista");
        System.out.println("=========================================================\n");

        nuevoNodo.puntero = cabeza;  // El nuevo nodo apunta al nodo que era la cabeza
        cabeza = nuevoNodo;  // El nuevo nodo se convierte en la nueva cabeza
        tamaño++;  // Incrementa el tamaño de la lista
    }

    // Método para insertar un valor al final de la lista
    void insertarCola(int valor) {
        Nodo nuevoNodo = new Nodo(valor);  // Crea un nuevo nodo con el valor dado
        if (cabeza == null && cola == null) {  // Si la lista está vacía

            cabeza = nuevoNodo;  // El nuevo nodo se convierte en la cabeza
            cola = nuevoNodo;  // El nuevo nodo también es la cola
            tamaño++;  // Incrementa el tamaño de la lista
            return;  // Termina la ejecución del método
        }

        // Muestra un mensaje de inserción al final de la lista
        System.out.println("\n*=========================================================*");
        System.out.println("\tEl valor " + valor + " se agregó al final de la lista");
        System.out.println("=========================================================\n");

        cola.puntero = nuevoNodo;  // El último nodo apunta al nuevo nodo
        cola = nuevoNodo;  // El nuevo nodo se convierte en la cola
        tamaño++;  // Incrementa el tamaño de la lista
    }

    // Método para eliminar el primer nodo de la lista
    void eliminarCabeza() {
        if (cabeza == null) {  // Verifica si la lista está vacía
            System.out.println("Lista vacía");  // Muestra un mensaje si no hay elementos
            return;  // Termina la ejecución del método
        }

        // Muestra un mensaje informando la eliminación del valor de la cabeza
        System.out.println("\n*=====================================================*");
        System.out.println("\tSe eliminó el valor " + cabeza.dato);
        System.out.println("=====================================================\n");

        cabeza = cabeza.puntero;  // La cabeza ahora apunta al siguiente nodo
        tamaño--;  // Decrementa el tamaño de la lista
    }

    // Método para eliminar el último nodo de la lista
    void eliminarCola() {
        if (cabeza == null && cola == null) {  // Verifica si la lista está vacía
            System.out.println("Lista vacía");  // Muestra un mensaje si no hay elementos
            return;  // Termina la ejecución del método
        }

        Nodo actual = cabeza;  // Empieza desde la cabeza para recorrer la lista

        // Recorre hasta encontrar el penúltimo nodo
        while (actual.puntero != cola) {
            actual = actual.puntero;
        }

        // Muestra un mensaje informando la eliminación del valor de la cola
        System.out.println("\n*=====================================================*");
        System.out.println("\tSe eliminó el valor " + cola.dato);
        System.out.println("=====================================================\n");

        cola = actual;  // El penúltimo nodo se convierte en la nueva cola
        cola.puntero = null;  // La nueva cola no apunta a ningún nodo
        tamaño--;  // Decrementa el tamaño de la lista
    }

    // Método para imprimir los elementos de la lista en orden inverso usando recursión
    void printLista(Nodo nodo) {
        if (nodo == null) {  // Condición base: si el nodo es nulo, se detiene
            return;  // Termina la recursión
        } else {
            printLista(nodo.puntero);  // Llama recursivamente con el siguiente nodo
            System.out.print(nodo.dato + " ");  // Imprime el valor del nodo actual
        }
    }

    // Método principal para ejecutar el programa y manejar el menú
    public static void iniciar() {
        ListaSimple lista = new ListaSimple();  // Crea una nueva lista vacía

        int opcion = 0;  // Variable para controlar el menú

        // Ciclo para mostrar el menú hasta que el usuario decida salir
        do {
            System.out.println("1.- insertar cabeza");
            System.out.println("2.- insertar cola");
            System.out.println("3.- eliminar cabeza");
            System.out.println("4.- eliminar cola");
            System.out.println("5.- ver lista");
            System.out.println("6.- Salir");
            opcion = sc.nextInt();  // Lee la opción del usuario

            switch (opcion) {
                case 1:
                    lista.insertarCabeza(sc.nextInt());  // Inserta un valor en la cabeza
                    break;
                case 2:
                    lista.insertarCola(sc.nextInt());  // Inserta un valor en la cola
                    break;
                case 3:
                    lista.eliminarCabeza();  // Elimina el valor de la cabeza
                    break;
                case 4:
                    lista.eliminarCola();  // Elimina el valor de la cola
                    break;
                case 5:
                    // Imprime los elementos actuales de la lista en orden inverso
                    System.out.print("\n*=====================================================*\n\t");
                    lista.printLista(lista.cabeza);
                    System.out.println("\n*=====================================================*\n");
                    break;
                case 6:
                    System.out.println("Saliendo...");  // Mensaje de salida
                    break;
                default:
                    System.out.println("Opción inválida");  // Manejo de opción inválida
                    break;
            }
        } while (opcion != 6);  // El ciclo se repite hasta que el usuario seleccione la opción de salir
    }
}
