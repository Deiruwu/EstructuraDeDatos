import java.util.Scanner;

public class ListaSimpleCircular {
    static Scanner sc = new Scanner(System.in);  // Scanner para recibir entradas del usuario

    // Clase interna Nodo para representar cada elemento de la lista
    class Nodo {
        int dato;  // Valor almacenado en el nodo
        Nodo puntero;  // Puntero al siguiente nodo

        // Constructor para inicializar el nodo con un valor
        Nodo(int valor) {
            dato = valor;  // Asigna el valor al nodo
            puntero = null; // Inicializa el puntero como nulo
        }
    }

    int tamaño;  // Almacena el tamaño actual de la lista
    Nodo cabeza;  // Referencia al primer nodo de la lista

    // Constructor para inicializar una lista circular vacía
    ListaSimpleCircular() {
        cabeza = null;  // La lista comienza vacía, sin nodos
        tamaño = 0;  // Inicializa el tamaño de la lista a 0
    }

    // Método para insertar un valor en la cabeza de la lista
    void insertarCabeza(int valor) {
        Nodo nuevoNodo = new Nodo(valor);  // Crea un nuevo nodo con el valor dado
        if (cabeza == null) {  // Si la lista está vacía
            cabeza = nuevoNodo;  // El nuevo nodo se convierte en la cabeza
            cabeza.puntero = cabeza;  // El puntero del nuevo nodo apunta a sí mismo
        } else {
            Nodo cola = cabeza;  // Variable temporal para encontrar la cola
            while (cola.puntero != cabeza) {
                cola = cola.puntero;  // Avanza hasta el último nodo
            }
            nuevoNodo.puntero = cabeza;  // El nuevo nodo apunta a la cabeza
            cola.puntero = nuevoNodo;  // El antiguo último nodo apunta al nuevo nodo
            cabeza = nuevoNodo;  // La cabeza ahora es el nuevo nodo
        }
        tamaño++;  // Incrementa el tamaño de la lista
        System.out.println("\n*=========================================================*");
        System.out.println("\tEl valor " + valor + " se agregó a la cabeza de la lista.");
        System.out.println("=========================================================\n");
    }

    // Método para insertar un valor al final de la lista (cola)
    void insertarCola(int valor) {
        Nodo nuevoNodo = new Nodo(valor);  // Crea un nuevo nodo con el valor dado
        if (cabeza == null) {  // Si la lista está vacía
            cabeza = nuevoNodo;  // El nuevo nodo se convierte en la cabeza
            cabeza.puntero = cabeza;  // El puntero del nuevo nodo apunta a sí mismo
        } else {
            Nodo cola = cabeza;  // Variable temporal para encontrar la cola
            while (cola.puntero != cabeza) {
                cola = cola.puntero;  // Avanza hasta el último nodo
            }
            cola.puntero = nuevoNodo;  // El antiguo último nodo apunta al nuevo nodo
            nuevoNodo.puntero = cabeza;  // El nuevo nodo apunta a la cabeza
        }
        tamaño++;  // Incrementa el tamaño de la lista
        System.out.println("\n*=========================================================*");
        System.out.println("\tEl valor " + valor + " se agregó a la cola de la lista.");
        System.out.println("=========================================================\n");
    }

    // Método para eliminar el nodo de la cabeza
    void eliminarCabeza() {
        if (cabeza == null) {  // Verifica si la lista está vacía
            System.out.println("Lista vacía, no se puede eliminar.");  // Muestra un mensaje si no hay elementos
            return;  // Termina la ejecución del método
        }

        // Muestra un mensaje informando la eliminación del valor de la cabeza
        System.out.println("\n*=============================================*");
        System.out.println("\tSe eliminó el valor " + cabeza.dato);
        System.out.println("=============================================\n");

        if (cabeza.puntero == cabeza) {  // Si hay solo un nodo
            cabeza = null;  // La lista queda vacía
        } else {
            Nodo cola = cabeza;  // Variable temporal para encontrar la cola
            while (cola.puntero != cabeza) {
                cola = cola.puntero;  // Avanza hasta el último nodo
            }
            cabeza = cabeza.puntero;  // La cabeza ahora apunta al siguiente nodo
            cola.puntero = cabeza;  // La cola apunta a la nueva cabeza
        }
        tamaño--;  // Decrementa el tamaño de la lista
    }

    // Método para eliminar el nodo de la cola
    void eliminarCola() {
        if (cabeza == null) {  // Verifica si la lista está vacía
            System.out.println("Lista vacía, no se puede eliminar.");  // Muestra un mensaje si no hay elementos
            return;  // Termina la ejecución del método
        }

        if (cabeza.puntero == cabeza) {  // Si hay solo un nodo
            System.out.println("\n*=============================================*");
            System.out.println("\tSe eliminó el valor " + cabeza.dato);
            System.out.println("=============================================\n");
            cabeza = null;  // La lista queda vacía
        } else {
            Nodo cola = cabeza;  // Variable temporal para encontrar la cola
            while (cola.puntero.puntero != cabeza) {  // Busca el penúltimo nodo
                cola = cola.puntero;  // Avanza hasta el penúltimo nodo
            }
            System.out.println("\n*=============================================*");
            System.out.println("\tSe eliminó el valor " + cola.puntero.dato);
            System.out.println("=============================================\n");
            cola.puntero = cabeza;  // El penúltimo nodo ahora apunta a la cabeza
        }
        tamaño--;  // Decrementa el tamaño de la lista
    }

    // Método para imprimir los elementos de la lista
    void printLista() {
        if (cabeza == null) {  // Verifica si la lista está vacía
            System.out.println("\n*=============================================*");
            System.out.println("\tLista vacía");
            System.out.println("=============================================\n");
            return;  // Termina la ejecución del método
        }

        Nodo nodoActual = cabeza;  // Comienza desde la cabeza
        System.out.print("\n*=============================================*\n\t");
        do {
            System.out.print(nodoActual.dato + " ");  // Imprime el valor del nodo actual
            nodoActual = nodoActual.puntero;  // Avanza al siguiente nodo
        } while (nodoActual != cabeza);  // Continúa hasta que regrese a la cabeza
        System.out.println("\n*=============================================*\n");
    }

    // Método principal para ejecutar el programa y manejar el menú
    public static void iniciar() {
        ListaSimpleCircular lista = new ListaSimpleCircular();  // Crea una nueva lista circular vacía

        int opcion = 0;  // Variable para controlar el menú

        // Ciclo para mostrar el menú hasta que el usuario decida salir
        do {
            System.out.println("1.- Insertar en cabeza");
            System.out.println("2.- Insertar en cola");
            System.out.println("3.- Eliminar de la cabeza");
            System.out.println("4.- Eliminar de la cola");
            System.out.println("5.- Ver lista");
            System.out.println("6.- Salir");
            opcion = sc.nextInt();  // Lee la opción del usuario
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el valor a insertar en la cabeza:");  // Solicita el valor a insertar
                    lista.insertarCabeza(sc.nextInt());  // Inserta un valor en la cabeza
                    break;
                case 2:
                    System.out.println("Ingrese el valor a insertar en la cola:");  // Solicita el valor a insertar
                    lista.insertarCola(sc.nextInt());  // Inserta un valor en la cola
                    break;
                case 3:
                    lista.eliminarCabeza();  // Elimina el valor de la cabeza
                    break;
                case 4:
                    lista.eliminarCola();  // Elimina el valor de la cola
                    break;
                case 5:
                    lista.printLista();  // Imprime los elementos actuales de la lista
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
