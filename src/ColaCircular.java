import java.util.Scanner;

public class ColaCircular {
    static Scanner sc = new Scanner(System.in);  // Scanner para recibir entradas del usuario

    int[] cola;  // Arreglo que representa la cola
    int elementos;  // Número de elementos en la cola
    int front;  // Índice del frente de la cola
    int rear;  // Índice de la parte trasera de la cola
    final int TAMAÑO;  // Capacidad máxima de la cola

    // Constructor para inicializar la cola circular con un tamaño dado
    ColaCircular(int tamaño){
        cola = new int[tamaño];  // Crear arreglo con el tamaño dado
        elementos = 0;  // Inicializa el número de elementos en 0
        front = 0;  // Inicializa el índice del frente en 0
        rear = 0;  // Inicializa el índice trasero en 0
        TAMAÑO = cola.length;  // Define la capacidad máxima de la cola
    }

    // Método para insertar un valor en la cola circular
    void insertar(int valor){
        if (!lleno()) {  // Verifica si la cola no está llena
            cola[front] = valor;  // Inserta el valor en la posición de 'front'

            // Muestra un mensaje informando la inserción del valor
            System.out.println("\n*=====================================================*");
            System.out.println("\tSe insertó el valor " + valor + " en la posición " + front);
            System.out.println("=====================================================\n");

            front++;  // Incrementa el índice del frente
            if (front == TAMAÑO) {  // Si el índice llega al final, lo reinicia a 0
                front = 0;
            }
            elementos++;  // Incrementa el número de elementos en la cola
        } else {
            // Muestra un mensaje de error si la cola está llena
            System.out.println("Pila llena");
        }
    }

    // Método para eliminar un valor de la cola circular
    void eliminar(){
        if (!vacio()) {  // Verifica si la cola no está vacía

            // Muestra un mensaje informando la eliminación del valor
            System.out.println("\n*=====================================================*");
            System.out.println("\tSe eliminó el valor " + cola[rear] + " de la posición " + rear);
            System.out.println("=====================================================\n");

            rear++;  // Incrementa el índice trasero
            if (rear == TAMAÑO) {  // Si el índice trasero llega al final, lo reinicia a 0
                rear = 0;
            }
            elementos--;  // Decrementa el número de elementos en la cola
        } else {
            // Muestra un mensaje de error si la cola está vacía
            System.out.println("Pila vacía, no se pueden eliminar elementos");
        }
    }

    // Método para imprimir los elementos actuales en la cola circular
    void printCola(){
        if (vacio()) {  // Verifica si la cola está vacía
            System.out.println("Cola vacía");  // Muestra un mensaje si no hay elementos
            return;  // Termina el método
        }

        int i = rear;  // Comienza desde el índice trasero

        // Muestra los elementos de la cola
        System.out.print("\n*========================*\n\t");
        for (int count = 0; count < elementos; count++) {  // Recorre el número de elementos en la cola
            System.out.print(cola[i] + " ");  // Imprime el valor en la posición actual
            i++;  // Incrementa el índice
            if (i == TAMAÑO) {  // Si llega al final, lo reinicia a 0
                i = 0;
            }
        }
        System.out.println("\n*========================*\n");  // Formato final de la salida
    }

    // Método para verificar si la cola circular está llena
    boolean lleno(){
        return (elementos == TAMAÑO);  // Retorna true si el número de elementos es igual al tamaño máximo
    }

    // Método para verificar si la cola circular está vacía
    boolean vacio(){
        return (elementos == 0);  // Retorna true si no hay elementos en la cola
    }

    // Método principal para ejecutar el programa y manejar el menú
    public static void iniciar() {
        ColaCircular cola = new ColaCircular(5);  // Crea una cola circular con capacidad para 5 elementos

        int opcion = 0;  // Variable para controlar el menú

        // Ciclo para mostrar el menú hasta que el usuario decida salir
        do {
            System.out.println("1.- insertar");
            System.out.println("2.- eliminar");
            System.out.println("3.- ver cola");
            System.out.println("4.- Salir");
            opcion = sc.nextInt();  // Lee la opción del usuario

            switch (opcion) {
                case 1:
                    cola.insertar(sc.nextInt());  // Inserta el valor en la cola
                    break;
                case 2:
                    cola.eliminar();  // Elimina el valor del frente de la cola
                    break;
                case 3:
                    cola.printCola();  // Muestra los elementos actuales de la cola
                    break;
                case 4:
                    System.out.println("Saliendo...");  // Mensaje de salida
                    break;
                default:
                    System.out.println("Opción inválida");  // Manejo de opción inválida
                    break;
            }
        } while (opcion != 4);  // El ciclo se repite hasta que el usuario seleccione la opción de salir
    }
}
