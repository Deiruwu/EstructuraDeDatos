import java.util.Scanner;  // Importa la clase Scanner para recibir entrada desde el teclado
public class Pila {
    static Scanner sc = new Scanner(System.in); // Crea un objeto Scanner estático para leer la entrada

    int[] pila;  // Declara un arreglo que representará la pila
    int cabeza;  // Índice que apunta al último elemento de la pila (la cima)

    // Constructor que inicializa la pila con el tamaño dado
    public Pila(int tamaño) {
        pila = new int[tamaño];  // Crea un arreglo de enteros con el tamaño especificado
        cabeza = -1;  // Inicializa la cabeza de la pila en -1 (pila vacía)
    }

    // Método que verifica si la pila está llena
    boolean lleno() {
        return (cabeza == (pila.length - 1));  // Retorna true si la cabeza está en la última posición
    }

    // Método que verifica si la pila está vacía
    boolean vacio() {
        return (cabeza == -1);  // Retorna true si la cabeza está en -1 (sin elementos)
    }

    // Método para añadir un valor a la pila (push)
    void push(int valor) {
        if (!lleno()) {  // Si la pila no está llena
            cabeza++;  // Incrementa la cabeza para añadir el nuevo valor
            pila[cabeza] = valor;  // Coloca el valor en la nueva posición de la cabeza
            System.out.println("Se añadió " + valor + " en la posición: " + cabeza);  // Muestra el valor y la posición añadida
        } else {
            System.err.println("La pila está llena");  // Muestra un mensaje de error si la pila está llena
        }
    }

    // Método para eliminar el último valor añadido de la pila (pop)
    void pop() {
        if (!vacio()) {  // Si la pila no está vacía
            System.out.println("El elemento que fue eliminado es: " + pila[cabeza]);  // Muestra el valor que se elimina
            cabeza--;  // Decrementa la cabeza para quitar el valor superior de la pila
        } else {
            System.out.println("La pila está vacia");  // Muestra un mensaje si no hay elementos para eliminar
        }
    }

    // Método para mostrar los elementos de la pila
    void verPilar() {
        for (int i = cabeza; i >= 0; i--) {  // Recorre la pila desde la cabeza hasta el fondo
            System.out.print(pila[i] + " ");  // Imprime cada elemento de la pila
        }
        System.out.println();  // Salta a una nueva línea
    }

    // Método principal que ejecuta el programa
    public static void iniciar() {
        Pila pila = new Pila(5);  // Crea una pila con capacidad para 5 elementos

        int opcion = 0;  // Variable para controlar el menú de opciones

        // Ciclo que muestra el menú hasta que el usuario elija salir
        do {
            System.out.println("1.- push");  // Opción para añadir un valor a la pila
            System.out.println("2.- pop");  // Opción para eliminar el último valor añadido
            System.out.println("3.- ver pila");  // Opción para mostrar la pila
            System.out.println("4.- Salir");  // Opción para salir del programa
            opcion = sc.nextInt();  // Lee la opción seleccionada por el usuario
            switch (opcion) {  // Evalúa la opción seleccionada
                case 1:
                    System.out.print("Ingrese el valor: ");  // Pide un valor al usuario
                    pila.push(sc.nextInt());  // Añade el valor a la pila
                    break;
                case 2:
                    pila.pop();  // Elimina el último valor añadido de la pila
                    break;
                case 3:
                    pila.verPilar();  // Muestra los elementos actuales de la pila
                    break;
                default:
                    System.out.println("Opción invalida");  // Muestra un mensaje si la opción no es válida
                    break;
            }
        } while (opcion != 4);  // El ciclo se repite mientras no se elija la opción de salir
    }
}
