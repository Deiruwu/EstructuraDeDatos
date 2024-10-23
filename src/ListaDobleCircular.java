import java.util.Scanner;

public class ListaDobleCircular {
    static Scanner sc = new Scanner(System.in);  // Scanner para recibir entradas del usuario

    // Clase interna Nodo para representar cada elemento de la lista
    class Nodo {
        int dato;  // Valor almacenado en el nodo
        Nodo punteroCabeza;  // Puntero al nodo anterior
        Nodo punteroCola;  // Puntero al nodo siguiente

        // Constructor para inicializar el nodo con un valor
        Nodo(int valor) {
            dato = valor;  // Asigna el valor al nodo
            punteroCabeza = null;  // Inicializa punteroCabeza como null
            punteroCola = null;  // Inicializa punteroCola como null
        }
    }

    Nodo cabeza;  // Referencia al primer nodo de la lista
    int tamaño;  // Almacena el tamaño actual de la lista

    // Método para insertar un nodo al inicio (cabeza) de la lista
    void insertarCabeza(int valor) {
        Nodo nuevoNodo = new Nodo(valor);  // Crea un nuevo nodo con el valor dado
        if (cabeza == null) {  // Si la lista está vacía
            cabeza = nuevoNodo;  // El nuevo nodo se convierte en la cabeza
            cabeza.punteroCabeza = cabeza;  // El punteroCabeza apunta a sí mismo
            cabeza.punteroCola = cabeza;  // El punteroCola apunta a sí mismo
        } else {  // Si la lista no está vacía
            Nodo ultimo = cabeza.punteroCabeza;  // Obtiene el último nodo
            nuevoNodo.punteroCola = cabeza;  // El nuevo nodo apunta a la cabeza
            nuevoNodo.punteroCabeza = ultimo;  // El nuevo nodo apunta al último nodo
            ultimo.punteroCola = nuevoNodo;  // El último nodo ahora apunta al nuevo nodo
            cabeza.punteroCabeza = nuevoNodo;  // Actualiza el punteroCabeza de la cabeza
            cabeza = nuevoNodo;  // Actualiza la cabeza al nuevo nodo
        }
        tamaño++;  // Incrementa el tamaño de la lista
        System.out.println("\n*=========================================================*");
        System.out.println("\tEl valor " + valor + " se agregó como cabeza de la lista.");
        System.out.println("=========================================================\n");
    }

    // Método para insertar un nodo al final (cola) de la lista
    void insertarCola(int valor) {
        Nodo nuevoNodo = new Nodo(valor);  // Crea un nuevo nodo con el valor dado
        if (cabeza == null) {  // Si la lista está vacía
            cabeza = nuevoNodo;  // El nuevo nodo se convierte en la cabeza
            cabeza.punteroCabeza = cabeza;  // El punteroCabeza apunta a sí mismo
            cabeza.punteroCola = cabeza;  // El punteroCola apunta a sí mismo
        } else {  // Si la lista no está vacía
            Nodo ultimo = cabeza.punteroCabeza;  // Obtiene el último nodo
            ultimo.punteroCola = nuevoNodo;  // El último nodo apunta al nuevo nodo
            nuevoNodo.punteroCabeza = ultimo;  // El nuevo nodo apunta al antiguo último nodo
            nuevoNodo.punteroCola = cabeza;  // El nuevo nodo apunta a la cabeza
            cabeza.punteroCabeza = nuevoNodo;  // Actualiza el punteroCabeza de la cabeza
        }
        tamaño++;  // Incrementa el tamaño de la lista
        System.out.println("\n*=========================================================*");
        System.out.println("\tEl valor " + valor + " se agregó como cola de la lista.");
        System.out.println("=========================================================\n");
    }

    // Método para eliminar el primer nodo de la lista (cabeza)
    void eliminarCabeza() {
        if (cabeza == null) {  // Verifica si la lista está vacía
            System.out.println("Lista vacía");  // Muestra un mensaje si no hay elementos
            return;  // Termina la ejecución del método
        } else if (cabeza.punteroCola == cabeza) {  // Si solo hay un nodo
            System.out.println("\n*=========================================================*");
            System.out.println("\tSe eliminó el único nodo de la lista: " + cabeza.dato);
            System.out.println("=========================================================\n");
            cabeza = null;  // Elimina la cabeza
        } else {  // Si hay más de un nodo
            System.out.println("\n*=========================================================*");
            System.out.println("\tSe eliminó la cabeza: " + cabeza.dato);
            System.out.println("=========================================================\n");
            Nodo cola = cabeza.punteroCabeza;  // Obtiene el último nodo
            cabeza = cabeza.punteroCola;  // La cabeza ahora apunta al siguiente nodo
            cabeza.punteroCabeza = cola;  // Actualiza el punteroCabeza del nuevo nodo cabeza
            cola.punteroCola = cabeza;  // El último nodo apunta al nuevo nodo cabeza
        }
        tamaño--;  // Decrementa el tamaño de la lista
    }

    // Método para eliminar el último nodo de la lista (cola)
    void eliminarCola() {
        if (cabeza == null) {  // Verifica si la lista está vacía
            System.out.println("Lista vacía");  // Muestra un mensaje si no hay elementos
            return;  // Termina la ejecución del método
        } else if (cabeza.punteroCola == cabeza) {  // Si solo hay un nodo
            System.out.println("\n*=========================================================*");
            System.out.println("\tSe eliminó el único nodo de la lista: " + cabeza.dato);
            System.out.println("=========================================================\n");
            cabeza = null;  // Elimina la cabeza
        } else {  // Si hay más de un nodo
            System.out.println("\n*=========================================================*");
            System.out.println("\tSe eliminó la cola: " + cabeza.punteroCabeza.dato);
            System.out.println("=========================================================\n");
            Nodo penultimo = cabeza.punteroCabeza.punteroCabeza;  // Obtiene el penúltimo nodo
            penultimo.punteroCola = cabeza;  // El penúltimo nodo apunta a la cabeza
            cabeza.punteroCabeza = penultimo;  // Actualiza el punteroCabeza de la cabeza
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
        Nodo nodo = cabeza;  // Comienza desde la cabeza
        System.out.print("\n*=============================================*\n\t");
        do {
            System.out.print(nodo.dato + " ");  // Imprime el valor del nodo actual
            nodo = nodo.punteroCola;  // Avanza al nodo siguiente
        } while (nodo != cabeza); // Continúa hasta que regrese a la cabeza
        System.out.println("\n*=============================================*\n");
    }

    // Método principal para ejecutar el programa y manejar el menú
    public static void iniciar() {
        ListaDobleCircular lista = new ListaDobleCircular();  // Crea una nueva lista doble circular vacía

        int opcion;  // Variable para controlar el menú

        // Ciclo para mostrar el menú hasta que el usuario decida salir
        do {
            System.out.println("1.- Insertar cabeza");
            System.out.println("2.- Insertar cola");
            System.out.println("3.- Eliminar cabeza");
            System.out.println("4.- Eliminar cola");
            System.out.println("5.- Ver lista");
            System.out.println("6.- Salir");
            opcion = sc.nextInt();  // Lee la opción del usuario

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese valor para insertar en cabeza:");  // Solicita el valor a insertar en la cabeza
                    lista.insertarCabeza(sc.nextInt());  // Inserta un valor en la cabeza
                    break;
                case 2:
                    System.out.println("Ingrese valor para insertar en cola:");  // Solicita el valor a insertar en la cola
                    lista.insertarCola(sc.nextInt());  // Inserta un valor en la cola
                    break;
                case 3:
                    lista.eliminarCabeza();  // Elimina el nodo en la cabeza
                    break;
                case 4:
                    lista.eliminarCola();  // Elimina el nodo en la cola
                    break;
                case 5:
                    System.out.print("\nLista: ");  // Mensaje previo a mostrar la lista
                    lista.printLista();  // Imprime la lista
                    break;
                case 6:
                    System.out.println("Saliendo...");  // Mensaje al salir del programa
                    break;
                default:
                    System.out.println("Opción inválida");  // Mensaje si la opción es inválida
                    break;
            }
        } while (opcion != 6);  // Continúa hasta que el usuario elija salir
    }
}
