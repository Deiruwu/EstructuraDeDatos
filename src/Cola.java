import java.util.Scanner;

public class Cola {
    static Scanner sc = new Scanner(System.in);  // Scanner para recibir entradas del usuario

    int[] cola;  // Arreglo que representa la cola
    int tamaño;  // Número actual de elementos en la cola
    int tamañoMax;  // Capacidad máxima de la cola

    // Constructor para inicializar la cola con un tamaño dado
    public Cola(int tamaño) {
        cola = new int[tamaño];  // Crear arreglo con el tamaño dado
        this.tamaño = 0;  // Inicializa el número de elementos en 0
        tamañoMax = cola.length;  // Define el tamaño máximo de la cola
    }

    // Método que verifica si la cola está llena
    boolean lleno() {
        return (tamaño == tamañoMax);  // Retorna true si la cola está llena
    }

    // Método que verifica si la cola está vacía
    boolean vacio() {
        return (tamaño == 0);  // Retorna true si no hay elementos en la cola
    }

    // Método para insertar un valor en la cola
    void insertar(int valor) {
        if (!lleno()) {  // Si la cola no está llena
            cola[tamaño] = valor;  // Añade el valor al final de la cola
            System.out.println("\n*=====================================================*");
            System.out.println("\tSe insertó el valor " + valor + " en la posición " + tamaño);
            System.out.println("*=====================================================*\n");
            tamaño++;  // Incrementa el tamaño de la cola
        } else {
            System.err.println("La cola está llena");  // Si la cola está llena, muestra un error
        }
    }

    // Método para eliminar el primer valor de la cola
    void eliminar() {
        if (!vacio()) {  // Si la cola no está vacía
            System.out.println("\n*=====================================================*");
            System.out.println("\tSe eliminó el valor " + cola[0] + " de la posición 0");
            System.out.println("*=====================================================*\n");

            // Desplaza los elementos hacia la izquierda para "eliminar" el primer valor
            for (int i = 0; i < tamaño - 1; i++) {
                cola[i] = cola[i + 1];
            }
            tamaño--;  // Reduce el tamaño de la cola
        } else {
            System.out.println("La cola está vacía");  // Si no hay elementos, muestra un mensaje
        }
    }

    // Método para imprimir los elementos actuales de la cola
    void verColar() {
        if (vacio()) {  // Si la cola está vacía
            System.out.println("Cola vacía");
            return;  // No hace nada más
        }

        System.out.print("\n*========================*\n\t");
        for (int i = 0; i < tamaño; i++) {  // Itera sobre los elementos de la cola
            System.out.print(cola[i] + " ");  // Imprime cada elemento
        }
        System.out.println("\n*========================*\n");  // Formato final
    }

    // Método principal para manejar las opciones del usuario
    public static void iniciar() {
        Cola cola = new Cola(5);  // Crea una cola con capacidad para 5 elementos

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
                    System.out.print("Ingrese el valor: ");
                    cola.insertar(sc.nextInt());  // Inserta el valor en la cola
                    break;
                case 2:
                    cola.eliminar();  // Elimina el primer valor de la cola
                    break;
                case 3:
                    cola.verColar();  // Muestra los elementos de la cola
                    break;
                case 4:
                    System.out.println("Saliendo...");  // Mensaje de salida
                    break;
                default:
                    System.out.println("Opción inválida");  // Manejo de opción inválida
                    break;
            }
        } while (opcion != 4);  // El ciclo se repite hasta que el usuario seleccione salir
    }
}
